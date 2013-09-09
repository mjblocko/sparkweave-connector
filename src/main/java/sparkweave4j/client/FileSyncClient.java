/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package sparkweave4j.client;

import java.io.InputStream;
import java.io.File;
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

  public void server(String server)
  {
    Server = server;
  }

  public String server()
  {
    return Server;
  }

  public void userEmail(String userEmail)
  {
    UserEmail = userEmail;
  }

  public String userEmail()
  {
    return UserEmail;
  }

  public void password(String password)
  {
    Password = password;
  }

  public String password()
  {
    return Password;
  }

  public void middleWareToken(String token)
  {
    MiddleWareToken = token;
  }

  public String middleWareToken()
  {
    return MiddleWareToken;
  }

  public void useHttps(boolean useHttps)
  {
    UseHttps = useHttps;
  }

  public boolean useHttps()
  {
    return UseHttps;
  }

  public FileSyncClient()
  {
  }

   static Cookie findCookieByName(List<Cookie> cookies, String name)
  {
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals(name)) {
        return cookie;
      }
    }
    // throw exception or return null
    return null;
  }

  static NewCookie findNewCookieByName(List<NewCookie> cookies, String name)
  {
    for (NewCookie cookie : cookies) {
      if (cookie.getName().equals(name)) {
        return cookie;
      }
    }
    // throw exception or return null
    return null;
  }

  private void addCookies(WebResource.Builder wrBuilder)
  {
    if (Cookies != null) {
      for (Cookie cookie : Cookies) {
        wrBuilder.cookie(cookie);
      }
    }
  }

  private WebResource.Builder createClient(String path)
  {
    if (JerseyClient == null) {
      ClientConfig cc = new DefaultClientConfig();
      // cc.getClasses().add(MultiPartWriter.class);
      JerseyClient = Client.create(cc);
    }
    UriBuilder uriBuilder = UriBuilder.fromUri("http://localhost");
    uriBuilder = uriBuilder.scheme((useHttps() == true) ? "https" : "http");
    URI uri = uriBuilder.host(server()).build();

    System.out.println(uri);

    WebResource resource = JerseyClient.resource(uri).path(path);
    WebResource.Builder builder = resource.getRequestBuilder();
    addCookies(builder);

    return builder;
  }

  private String createMetadataResource()
  {
    return String.format("/api/vfs/%s/metadata/%s/", API_VERSION, ROOT_PARAM);
  }

  private String createFolderResource()
  {
    return String.format("/api/vfs/%s/fileops/create_folder", API_VERSION);
  }

  private String createUploadFileResource(String path)
  {
    return String.format("/api/vfs/%s/files_put/%s/%s", API_VERSION, ROOT_PARAM, path);
  }

  private String createDownloadFileResource(String path)
  {
    return String.format("/api/vfs/%s/files/%s/%s", API_VERSION, ROOT_PARAM, path);
  }

  private String createDeleteResource()
  {
    return String.format("/api/vfs/%s/fileops/delete", API_VERSION);
  }

  public boolean login()
  {
    boolean isLoggedIn = false;

    try {
      WebResource.Builder builder = createClient("/api/auth/login");
      ClientResponse response = builder.accept("application/json").get(ClientResponse.class);

      if (response.getStatus() != 200) {
        throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
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
      middleWareToken(token);

      MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
      formData.add("csrfmiddlewaretoken", middleWareToken());
      formData.add("username", userEmail());
      formData.add("password", password());
      formData.add("client", "SyncWeave");

      builder = createClient("/api/auth/login");
      response = builder.accept("application/json").post(ClientResponse.class, formData);
      if (response.getStatus() != 200) {
        throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
      }

      // Update the dw-user-cookie value
      if (response.getCookies() != null) {
        List<NewCookie> cookies = response.getCookies();
        NewCookie newDwCookie = findNewCookieByName(cookies, "dw-user-cookie");
        Cookie oldDwCookie = findCookieByName(Cookies, "dw-user-cookie");
        Cookies.remove(oldDwCookie);
        Cookies.add(newDwCookie.toCookie());
      }

      output = response.getEntity(String.class);

      jsonObject = (JSONObject) parser.parse(output);
      result = (JSONObject) jsonObject.get("result");
      // UserInfo userInfo = JsonHelpers.getJsonFromString(result.toJSONString(), UserInfo.class);
      // System.out.println(userInfo.toString());

      isLoggedIn = true;
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return isLoggedIn;
  }

  public List<String> getRoot() throws Exception
  {
    return getFolder("/");
  }

  public List<String> getFolder(String path) throws Exception
  {
    final String apiUrl = createMetadataResource() + SwHelpers.adaptPath(path);
    WebResource.Builder builder = createClient(apiUrl);

    ClientResponse response = builder.accept("application/json").get(ClientResponse.class);

    if (response.getStatus() != 200) {
      throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
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

  public String uploadFile(InputStream fileDataObj, boolean overwrite, String path, String filename) throws Exception
  {
    String output = null;
    String absPath = SwHelpers.pathCombine(path, filename);
    String absPath2 = SwHelpers.makePathUnix(absPath);
    String apiUrl = createUploadFileResource(absPath2);

    // System.out.println("Path is "+path);
    // System.out.println("filename is "+filename);
    System.out.println("apiUrl is " + apiUrl);

    apiUrl.concat(String.format("?overwrite=%s", Boolean.valueOf(overwrite)));

    final InputStream fileData = (InputStream) fileDataObj;

    WebResource.Builder builder = createClient(apiUrl);

    output = builder.type(MediaType.MULTIPART_FORM_DATA).accept("application/json").post(String.class, fileData);

    return output;

  }

  public String createFolder(String path) throws Exception
  {
    final String apiUrl = createFolderResource();
    WebResource.Builder builder = createClient(apiUrl);

    MultivaluedMap<String, String> formData = new MultivaluedMapImpl();

    path = SwHelpers.adaptPath(path);
    formData.add("csrfmiddlewaretoken", middleWareToken());
    formData.add("root", ROOT_PARAM);
    formData.add("path", path);
    ClientResponse response = builder.accept("application/json").post(ClientResponse.class, formData);

    // If we get a 403 the directory probably exists
    if (response.getStatus() == 403) {
      return null;
    }

    if (response.getStatus() != 200) {
      throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
    }

    String output = response.getEntity(String.class);
    // System.out.println("Create_Folder : " + output);

    return output;

  }

  public String delete(String path) throws Exception
  {
    String output = null;
    final String apiUrl = createDeleteResource();
    WebResource.Builder builder = createClient(apiUrl);

    MultivaluedMap<String, String> formData = new MultivaluedMapImpl();

    path = SwHelpers.adaptPath(path);
    formData.add("csrfmiddlewaretoken", middleWareToken());
    formData.add("root", ROOT_PARAM);
    formData.add("path", path);
    ClientResponse response = builder.accept("application/json").post(ClientResponse.class, formData);

    // If we get a 403 the directory probably exists
    if (response.getStatus() == 403) {
      return null;
    }

    if (response.getStatus() != 200) {
      throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
    }

    output = response.getEntity(String.class);
    // System.out.println("Delete file/folder : " + output);

    return output;
  }

  public InputStream downloadFile(String path, boolean delete) throws Exception
  {
    String apiUrl = createDownloadFileResource(path);
    WebResource.Builder builder = createClient(apiUrl);

    InputStream response = builder.get(InputStream.class);

    if (delete) {
      delete(path);
    }
    return response;
  }

}
