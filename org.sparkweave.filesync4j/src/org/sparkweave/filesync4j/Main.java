package org.sparkweave.filesync4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.sparkweave.filesync4j.client.FileSyncClient;

public class Main
{

  /**
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception
  {
    FileSyncClient fsClient = new FileSyncClient();
    fsClient.Server("mblock-vm1");
    fsClient.UseHttps(false);
    fsClient.UserEmail("mblock@sparkweave.com");
    fsClient.Password("123abc");
    fsClient.Login();

    String newFolder = fsClient.CreateFolder("/mblock2i_" + UUID.randomUUID());
    List<String> entries = fsClient.GetRoot();
    if (entries != null) {
      System.out.println(Arrays.toString(entries.toArray()));
    }
    InputStream input = new FileInputStream(
        "C:\\temp\\dir1\\JsonClassHelper.cs");
    String fileName = "/mblock2/TestFile" + UUID.randomUUID();
    String result = fsClient.UploadFile(input, false, fileName);
    System.out.println(result);
   
    input = fsClient.DownloadFile(fileName, false);
    FileOutputStream outputStream = null;
    try {
      outputStream = new FileOutputStream("c:/temp/robots-new.txt");
      int stream = input.read();
      while (stream != -1) {
        outputStream.write(stream);
        stream = input.read();
      }
    } finally {
      outputStream.close();
    }
    String output = fsClient.Delete(fileName);
    System.out.println(output);
  }
}
