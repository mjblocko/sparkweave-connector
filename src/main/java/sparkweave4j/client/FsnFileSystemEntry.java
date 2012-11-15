/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package sparkweave4j.client;

public class FsnFileSystemEntry
{
  private String  hash;
  private String  revision;
  private long    bytes;
  private boolean thumb_exists;
  private String  rev;
  private String  modified;
  private String  path;
  private boolean is_dir;
  private long    size;
  
  private String absolutePath;
  private String Icon;
  private String mime_type;
  private boolean is_deleted;

  public void hash(String str)
  {
    hash = str;
  }

  public String hash()
  {
    return hash;
  }

  public void revision(String str)
  {
    revision = str;
  }

  public String revision()
  {
    return revision;
  }

  public void bytes(long value)
  {
    bytes = value;
  }

  public long bytes()
  {
    return bytes;
  }

  public void thumbExists(boolean value)
  {
    thumb_exists = value;
  }

  public boolean thumbExists()
  {
    return thumb_exists;
  }

  public void rev(String str)
  {
    rev = str;
  }

  public String rev()
  {
    return rev;
  }

  public void modified(String str)
  {
    modified = str;
  }

  public String modified()
  {
    return modified;
  }

  public void absolutePath(String str)
  {
    String absolutePath = str;
  }
  
  public String relativePath() { 
    return SwHelpers.relativePath(absolutePath());
  }
  
  public String absolutePath()
  {
    return absolutePath;
  }

  public void isDirectory(boolean value)
  {
    is_dir = value;
  }

  public boolean isDirectory()
  {
    return is_dir;
  }

  public void size(long value)
  {
    size = value;
  }

  public long size()
  {
    return size;
  }
  
  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    String NEW_LINE = System.getProperty("line.separator");

    sb.append(this.getClass().getName() + " Object {" + NEW_LINE);
    sb.append("Absolute Path   : " + absolutePath() + NEW_LINE);
    sb.append("Relative Path   : " + relativePath() + NEW_LINE);
    sb.append("RelativeDirPath : " + relativeDirectoryPath() + NEW_LINE);
    sb.append("Rev             : " + rev() + NEW_LINE);
    sb.append("Hash            : " + hash() + NEW_LINE);
    sb.append("Revision        : " + revision() + NEW_LINE);
    sb.append("Identity        : " + identity() + NEW_LINE);
    sb.append("Size            : " + size() + NEW_LINE);
    sb.append("Modified        : " + modified() + NEW_LINE);
    sb.append("IsDeleted       : " + isDeleted() + NEW_LINE);
    sb.append("ThumbExists     : " + thumbExists() + NEW_LINE);
    sb.append("MimeType        : " + mimeType() + NEW_LINE);
    sb.append("Icon            : " + icon() + NEW_LINE);
    return sb.toString();
  }

  private String icon()
  {
    // TODO Auto-generated method stub
    return null;
  }
  
  private void icon(String str)
  {
    Icon = str;
  }

  private String mimeType()
  {
    return mime_type;
  }
  
  private void mimeType(String str)
  {
    mime_type = str;
  }

  private Boolean isDeleted()
  {
    return null;
  }
  
  private void isDeleted(boolean value)
  {
    is_deleted = value;
  }

  public String identity()
  {
      return isDirectory() ? hash() : revision();
  }

  private String relativeDirectoryPath()
  {
    String absolutePath = absolutePath();
    if (absolutePath.isEmpty()) {
      return absolutePath;
    }
    
    String absPath = SwHelpers.makePathUnix(absolutePath);
    int idx = absPath.lastIndexOf("/");
    absPath = idx <= 0 ? "" : absPath.substring(0, idx);

    return SwHelpers.relativePath(absPath);
  }
}
