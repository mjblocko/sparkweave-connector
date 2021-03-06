/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

/**
 * This file was automatically generated by the Mule Development Kit
 */

package org.mule.sparkweave;

import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Connect;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;
import org.mule.api.annotations.param.Payload;
import org.mule.api.Connection;
import org.mule.api.ConnectionException;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.List;

import sparkweave4j.client.FileSyncClient;


/**
 * SparkWeave Cloud Connector
 * 
 * @author SparkWeave, LLC.
 */
@Connector(name = "sparkweave", schemaVersion = "1.0", configElementName="config", friendlyName="SparkWeave Connector")
public class SparkWeaveConnector
{
  private Logger logger = LoggerFactory.getLogger(Connection.class);
  
  private FileSyncClient FsClient;

    /**
     * Debug parameter
     */
  @Configurable
  @Optional
  @Default("false")
  private boolean Debug;

    /**
     * UseHttps parameter
     */
  @Configurable
  @Optional
  @Default("false")
  private boolean UseHttps;

  
  public void setUseHttps(boolean value)
  {
    UseHttps = value;
  }

  public boolean getUseHttps()
  {
    return UseHttps;
  }

  public boolean isDebug()
  {
    return Debug;
  }

  public void setDebug(boolean debug)
  {
    this.Debug = debug;
  }

  /**
   * Connect
   * 
   * @param ckServer
   *          SparkWeave server name
   * @param ckUserEmail
   *          SMTP email address of user
   * @param ckPassword
   *          A password
   * @throws ConnectionException
   */
  @Connect
  public void connect(@ConnectionKey String ckServer, String ckUserEmail, String ckPassword)
      throws ConnectionException
  {
    FsClient = new FileSyncClient();
    FsClient.server(ckServer);
    FsClient.userEmail(ckUserEmail);
    FsClient.password(ckPassword);
    FsClient.useHttps(UseHttps);
    FsClient.login();
  }

  /**
   * Disconnect
   */
  @Disconnect
  public void disconnect()
  {
    FsClient = null;
  }

  /**
   * Are we connected
   */
  @ValidateConnection
  public boolean isConnected()
  {
    return FsClient != null;
  }

  /*
   * return a string for a session id?
   */
  @ConnectionIdentifier
  public String getSessionId()
  {
    return "SparkWeave";
  }

  /**
   * Upload file to SparkWeave. The payload is an InputStream containing bytes
   * of the data to be uploaded.
   * 
   * {@sample.xml ../../../doc/sparkweave-connector.xml.sample sparkweave:upload-file}
   * 
   * @param fileDataObj
   *          file to be uploaded
   * @param overwrite
   *          overwrite file in case it already exists
   * @param path
   *          The destination path to file
   * @param filename
   *          The destination filename
   * 
   * @return http response
   * @throws Exception
   *           exception
   */
  @Processor
  // public String uploadFile(@Payload InputStream fileDataObj,
  public String uploadFile(@Optional @Default("#[payload]") InputStream fileDataObj,
                           @Optional @Default("false") Boolean overwrite, 
                           String path,
                           String filename)
      throws Exception
  {
    String result = FsClient.uploadFile(fileDataObj, overwrite, path, filename);
    return result;
  }

  /**
   * Create new folder on SparkWeave
   * 
   * {@sample.xml ../../../doc/sparkweave-connector.xml.sample
   * sparkweave:create-folder}
   * 
   * @param path
   *          full path of the folder to be created
   * 
   * @return http response
   * @throws Exception
   *           exception
   */
  @Processor
  public String createFolder(String path) throws Exception
  {
    return FsClient.createFolder(path);
  }
  
  /**
   * Deletes a file or folder.
   * 
   * {@sample.xml ../../../doc/sparkweave-connector.xml.sample sparkweave:delete}
   * 
   * @param accessToken
   *            accessToken
   * @param accessTokenSecret
   *            access token secret
   * @param path
   *            full path to the file to be deleted
   * 
   * @return http response
   * @throws Exception
   *             exception
   */
  @Processor
  public String delete(String path) throws Exception {
    return FsClient.delete(path);
  }

  /**
   * Downloads a file from sparkweave
   * 
   * {@sample.xml ../../../doc/sparkweave-connector.xml.sample sparkweave:download-file}
   * 
   * @param accessToken
   *            accessToken
   * @param accessTokenSecret
   *            access token secret
   * @param path
   *            path to the file
   * @param delete
   *            delete the file on the sparkweave after download (ignored if
   *            moveTo is set)
   * @param moveTo
   *            Specifies the destination path, including the new name for the
   *            file or folder, relative to root.
   * 
   * @return Stream containing the downloaded file data
   * @throws Exception
   *             exception
   */
  @Processor
  public InputStream downloadFile(String path,
      @Optional @Default("false") boolean delete) throws Exception {
    return FsClient.downloadFile(path, delete);
  }

  /**
   * Lists the content of the remote directory
   * 
   * {@sample.xml ../../../doc/sparkweave-connector.xml.sample sparkweave:list}
   * 
   * @param accessToken
   *            accessToken
   * @param accessTokenSecret
   *            access token secret
   * @param path
   *            path to the remote directory
   * 
   * @return List of files and/or folders
   * @throws Exception
   *             exception
   */
  @Processor
  public List<String> list(String path) throws Exception {
    return FsClient.getFolder(path);
  }

}
