package org.sparkweave.filesync4j.client;

import java.util.Arrays;

public class UserInfo
{
  private long     retain_fulcrum;
  private long     max_file_size;
  private boolean  default_notification_policy;
  private long     retain_large;
  private long     cabinet_size;
  private long     retain_small;
  private long     cabinet_used;
  private long     reroute_size;
  private String[] permissions;

  public long RetainFulcrum()
  {
    return retain_fulcrum;
  }

  public void RetainFulcrum(long fulcrum)
  {
    retain_fulcrum = fulcrum;
  }

  public long MaxFileSize()
  {
    return max_file_size;
  }

  public void MaxFileSize(long size)
  {
    max_file_size = size;
  }

  public boolean DefaultNotificationPolicy()
  {
    return default_notification_policy;
  }

  public void DefaultNotificationPolicy(boolean value)
  {
    default_notification_policy = value;
  }

  public long RetainLarge()
  {
    return retain_large;
  }

  public void RetainLarge(long value)
  {
    retain_large = value;
  }

  public long CabinetSize()
  {
    return cabinet_size;
  }

  public void CabinetSize(long size)
  {
    cabinet_size = size;
  }

  public long RetainSmall()
  {
    return retain_small;
  }

  public void retain_small(long size)
  {
    retain_small = size;
  }

  public long CabinetUsed()
  {
    return cabinet_used;
  }

  public void CabinetUsed(long size)
  {
    cabinet_used = size;
  }

  public long RerouteSize()
  {
    return reroute_size;
  }

  public void RerouteSize(long size)
  {
    reroute_size = size;
  }

  public String[] Permissions()
  {
    return permissions;
  }

  public void Permissions(String[] perms)
  {
    permissions = perms;
  }

  @Override
  public String toString()
  {
    StringBuilder result = new StringBuilder();
    String NEW_LINE = System.getProperty("line.separator");

    result.append(this.getClass().getName() + " Object {" + NEW_LINE);
    result.append(" RetainFulcrum : " + RetainFulcrum() + NEW_LINE);
    result.append(" MaxFileSize   : " + MaxFileSize() + NEW_LINE);
    result.append(" DefNoticPolicy: " + DefaultNotificationPolicy() + NEW_LINE);
    result.append(" RetainLarge   : " + RetainLarge() + NEW_LINE);
    result.append(" CabinetSize   : " + CabinetSize() + NEW_LINE);
    result.append(" RetainSmall   : " + RetainSmall() + NEW_LINE);
    result.append(" CabinetUsed   : " + CabinetUsed() + NEW_LINE);
    result.append(" RerouteSize   : " + RerouteSize() + NEW_LINE);
    result.append(" Permissions   : " + Arrays.toString(Permissions()) + NEW_LINE);
    result.append("}");

    return result.toString();
  }
}
