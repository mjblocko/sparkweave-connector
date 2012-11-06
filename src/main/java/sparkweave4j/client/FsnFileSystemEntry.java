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

  public void Hash(String str)
  {
    hash = str;
  }

  public String Hash()
  {
    return hash;
  }

  public void Revision(String str)
  {
    revision = str;
  }

  public String Revision()
  {
    return revision;
  }

  public void Bytes(long value)
  {
    bytes = value;
  }

  public long Bytes()
  {
    return bytes;
  }

  public void ThumbExists(boolean value)
  {
    thumb_exists = value;
  }

  public boolean ThumbExists()
  {
    return thumb_exists;
  }

  public void Rev(String str)
  {
    rev = str;
  }

  public String Rev()
  {
    return rev;
  }

  public void Modified(String str)
  {
    modified = str;
  }

  public String Modified()
  {
    return modified;
  }

  public void AbsolutePath(String str)
  {
    String absolutePath = str;
  }
  public String RelativePath() { 
    return SwHelpers.RelativePath(AbsolutePath());
  }
  public String AbsolutePath()
  {
    return absolutePath;
  }

  public void IsDirectory(boolean value)
  {
    is_dir = value;
  }

  public boolean IsDirectory()
  {
    return is_dir;
  }

  public void Size(long value)
  {
    size = value;
  }

  public long Size()
  {
    return size;
  }
  
  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    String NEW_LINE = System.getProperty("line.separator");

    sb.append(this.getClass().getName() + " Object {" + NEW_LINE);
    sb.append("Absolute Path   : " + AbsolutePath() + NEW_LINE);
    sb.append("Relative Path   : " + RelativePath() + NEW_LINE);
    sb.append("RelativeDirPath : " + RelativeDirectoryPath() + NEW_LINE);
    sb.append("Rev             : " + Rev() + NEW_LINE);
    sb.append("Hash            : " + Hash() + NEW_LINE);
    sb.append("Revision        : " + Revision() + NEW_LINE);
    sb.append("Identity        : " + Identity() + NEW_LINE);
    sb.append("Size            : " + Size() + NEW_LINE);
    sb.append("Modified        : " + Modified() + NEW_LINE);
    sb.append("IsDeleted       : " + IsDeleted() + NEW_LINE);
    sb.append("ThumbExists     : " + ThumbExists() + NEW_LINE);
    sb.append("MimeType        : " + MimeType() + NEW_LINE);
    sb.append("Icon            : " + Icon() + NEW_LINE);
    return sb.toString();
  }

  private String Icon()
  {
    // TODO Auto-generated method stub
    return null;
  }
  
  private void Icon(String str)
  {
    Icon = str;
  }

  private String MimeType()
  {
    return mime_type;
  }
  
  private void MimeType(String str)
  {
    mime_type = str;
  }

  private Boolean IsDeleted()
  {
    return null;
  }
  
  private void IsDeleted(boolean value)
  {
    is_deleted = value;
  }

  public String Identity()
  {
      return IsDirectory() ? Hash() : Revision();
  }

  private String RelativeDirectoryPath()
  {
    String absolutePath = AbsolutePath();
    if (absolutePath.isEmpty()) {
      return absolutePath;
    }
    
    String absPath = SwHelpers.MakePathUnix(absolutePath);
    int idx = absPath.lastIndexOf("/");
    absPath = idx <= 0 ? "" : absPath.substring(0, idx);

    return SwHelpers.RelativePath(absPath);
  }
}
