package org.sparkweave.filesync4j.client;

import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.UriBuilder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/*
 import org.json.simple.JSONArray;
 import org.json.simple.JSONObject;
 import org.json.simple.parser.JSONParser;
 import org.json.simple.parser.ParseException;
 */

public class FileSyncClient
{
  private Client              JerseyClient;
  private String              Server;
  private String              UserEmail;
  private String              Password;
  private String              MiddleWareToken;
  private static final String API_VERSION = "1";
  private static final String ROOT_PARAM  = "filesync";
  private List<Cookie>        Cookies;

  private boolean             UseHttps;

  public void Server(String server)
  {
    Server = server;
  }

  public String Server()
  {
    return Server;
  }

  public void UserEmail(String userEmail)
  {
    UserEmail = userEmail;
  }

  public String UserEmail()
  {
    return UserEmail;
  }

  public void Password(String password)
  {
    Password = password;
  }

  public String Password()
  {
    return Password;
  }

  public void MiddleWareToken(String token)
  {
    MiddleWareToken = token;
  }

  public String MiddleWareToken()
  {
    return MiddleWareToken;
  }

  public void UseHttps(boolean useHttps)
  {
    UseHttps = useHttps;
  }

  public boolean UseHttps()
  {
    return UseHttps;
  }

  public FileSyncClient() {
  }

  static Cookie FindCookieByName(List<Cookie> cookies, String name)
  {
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals(name)) {
        return cookie;
      }
    }
    // throw exception or return null
    return null;
  }

  static NewCookie FindNewCookieByName(List<NewCookie> cookies, String name)
  {
    for (NewCookie cookie : cookies) {
      if (cookie.getName().equals(name)) {
        return cookie;
      }
    }
    // throw exception or return null
    return null;
  }

  private void AddCookies(WebResource.Builder wrBuilder)
  {
    if (Cookies != null) {
      for (Cookie cookie : Cookies) {
        wrBuilder.cookie(cookie);
      }
    }
  }

  private WebResource.Builder CreateClient(String path)
  {
    if (JerseyClient == null) {
      ClientConfig cc = new DefaultClientConfig();
      // cc.getClasses().add(MultiPartWriter.class);
      JerseyClient = Client.create(cc);
    }
    UriBuilder uriBuilder = UriBuilder.fromUri("http://localhost");
    uriBuilder = uriBuilder.scheme((UseHttps() == true) ? "https" : "http");
    URI uri = uriBuilder.host(Server()).build();

    System.out.println(uri);

    WebResource resource = JerseyClient.resource(uri).path(path);
    WebResource.Builder builder = resource.getRequestBuilder();
    AddCookies(builder);

    return builder;
  }

  private String CreateMetadataResource()
  {
    return String.format("/api/vfs/%s/metadata/%s/", API_VERSION, ROOT_PARAM);
  }

  private String CreateFolderResource()
  {
    return String.format("/api/vfs/%s/fileops/create_folder", API_VERSION);
  }

  private String CreateUploadFileResource(String path)
  {
    return String.format("/api/vfs/%s/files_put/%s/%s", API_VERSION,
        ROOT_PARAM, path);
  }

  private String CreateDownloadFileResource(String path)
  {
    return String.format("/api/vfs/%s/files/%s/%s", API_VERSION, ROOT_PARAM,
        path);
  }
  
  private String CreateDeleteResource()
  {
    return String.format("/api/vfs/%s/fileops/delete", API_VERSION);
  }

  public boolean Login()
  {
    boolean isLoggedIn = false;

    try {
      WebResource.Builder builder = CreateClient("/api/auth/login");
      ClientResponse response = builder.accept("application/json").get(
          ClientResponse.class);

      if (response.getStatus() != 200) {
        throw new RuntimeException("Failed : HTTP error code : "
            + response.getStatus());
      }

      JSONParser parser = new JSONParser();
      String output = response.getEntity(String.class);
      if (response.getCookies() != null) {
        if (Cookies == null) {
          Cookies = new ArrayList<Cookie>();
          for (NewCookie newCook : response.getCookies()) {
            Cookies.add(newCook.toCookie());
          }
        }
      }

      JSONObject jsonObject = (JSONObject) parser.parse(output);
      JSONObject result = (JSONObject) jsonObject.get("result");
      String token = (String) result.get("csrf_token");
      MiddleWareToken(token);

      MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
      formData.add("csrfmiddlewaretoken", MiddleWareToken());
      formData.add("username", UserEmail());
      formData.add("password", Password());
      formData.add("client", "SyncWeave");

      builder = CreateClient("/api/auth/login");
      response = builder.accept("application/json").post(ClientResponse.class,
          formData);
      if (response.getStatus() != 200) {
        throw new RuntimeException("Failed : HTTP error code : "
            + response.getStatus());
      }

      // Update the dw-user-cookie value
      if (response.getCookies() != null) {
        List<NewCookie> cookies = response.getCookies();
        NewCookie newDwCookie = FindNewCookieByName(cookies, "dw-user-cookie");
        Cookie oldDwCookie = FindCookieByName(Cookies, "dw-user-cookie");
        Cookies.remove(oldDwCookie);
        Cookies.add(newDwCookie.toCookie());
      }

      output = response.getEntity(String.class);

      jsonObject = (JSONObject) parser.parse(output);
      result = (JSONObject) jsonObject.get("result");
      UserInfo userInfo = JsonHelpers.getJsonFromString(result.toJSONString(),
          UserInfo.class);
      // System.out.println(userInfo.toString());

      isLoggedIn = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return isLoggedIn;
  }

  public List<String> GetRoot() throws Exception
  {
    return GetFolder("/");
  }

  public List<String> GetFolder(String path) throws Exception
  {
    final String apiUrl = CreateMetadataResource() + SwHelpers.AdaptPath(path);
    WebResource.Builder builder = CreateClient(apiUrl);

    ClientResponse response = builder.accept("application/json").get(
        ClientResponse.class);

    if (response.getStatus() != 200) {
      throw new RuntimeException("Failed : HTTP error code : "
          + response.getStatus());
    }
    String output = response.getEntity(String.class);

    final JSONObject root = (JSONObject) JSONValue.parse(output);
    final JSONArray files = (JSONArray) root.get("contents");
    List<String> paths = new ArrayList<String>(files.size());
    for (int i = 0; i < files.size(); i++) {
      JSONObject file = (JSONObject) files.get(i);
      paths.add(file.get("path").toString());
    }
    return paths;
  }

  public String UploadFile(InputStream fileDataObj, boolean overwrite,
      String path) throws Exception
  {
    String output = null;
    String apiUrl = CreateUploadFileResource(path);

    apiUrl.concat(String.format("?overwrite=%s", Boolean.valueOf(overwrite)));

    final InputStream fileData = (InputStream) fileDataObj;

    WebResource.Builder builder = CreateClient(apiUrl);

    output = builder.type(MediaType.MULTIPART_FORM_DATA)
        .accept("application/json").post(String.class, fileData);

    return output;

  }

  public String CreateFolder(String path) throws Exception
  {
    final String apiUrl = CreateFolderResource();
    WebResource.Builder builder = CreateClient(apiUrl);

    MultivaluedMap<String, String> formData = new MultivaluedMapImpl();

    path = SwHelpers.AdaptPath(path);
    formData.add("csrfmiddlewaretoken", MiddleWareToken());
    formData.add("root", ROOT_PARAM);
    formData.add("path", path);
    ClientResponse response = builder.accept("application/json").post(
        ClientResponse.class, formData);

    // If we get a 403 the directory probably exists
    if (response.getStatus() == 403) {
      return null;
    }

    if (response.getStatus() != 200) {
      throw new RuntimeException("Failed : HTTP error code : "
          + response.getStatus());
    }

    String output = response.getEntity(String.class);
    System.out.println("Create_Folder : " + output);

    return output;

  }

  public String Delete(String path) throws Exception
  {
    String output = null;
    final String apiUrl = CreateDeleteResource();
    WebResource.Builder builder = CreateClient(apiUrl);

    MultivaluedMap<String, String> formData = new MultivaluedMapImpl();

    path = SwHelpers.AdaptPath(path);
    formData.add("csrfmiddlewaretoken", MiddleWareToken());
    formData.add("root", ROOT_PARAM);
    formData.add("path", path);
    ClientResponse response = builder.accept("application/json").post(
        ClientResponse.class, formData);

    // If we get a 403 the directory probably exists
    if (response.getStatus() == 403) {
      return null;
    }

    if (response.getStatus() != 200) {
      throw new RuntimeException("Failed : HTTP error code : "
          + response.getStatus());
    }

    output = response.getEntity(String.class);
    System.out.println("Delete file/folder : " + output);

    return output;
  }

  public InputStream DownloadFile(String path, boolean delete) throws Exception
  {
    String apiUrl = CreateDownloadFileResource(path);
    WebResource.Builder builder = CreateClient(apiUrl);

    InputStream response = builder.get(InputStream.class);

    if (delete) {
      Delete(path);
    }
    return response;
  }
  

}
