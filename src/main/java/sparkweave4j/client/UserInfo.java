/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package sparkweave4j.client;

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

  public long retainFulcrum()
  {
    return retain_fulcrum;
  }

  public void retainFulcrum(long fulcrum)
  {
    retain_fulcrum = fulcrum;
  }

  public long maxFileSize()
  {
    return max_file_size;
  }

  public void maxFileSize(long size)
  {
    max_file_size = size;
  }

  public boolean defaultNotificationPolicy()
  {
    return default_notification_policy;
  }

  public void defaultNotificationPolicy(boolean value)
  {
    default_notification_policy = value;
  }

  public long retainLarge()
  {
    return retain_large;
  }

  public void retainLarge(long value)
  {
    retain_large = value;
  }

  public long cabinetSize()
  {
    return cabinet_size;
  }

  public void cabinetSize(long size)
  {
    cabinet_size = size;
  }

  public long retainSmall()
  {
    return retain_small;
  }

  public void retain_small(long size)
  {
    retain_small = size;
  }

  public long cabinetUsed()
  {
    return cabinet_used;
  }

  public void cabinetUsed(long size)
  {
    cabinet_used = size;
  }

  public long rerouteSize()
  {
    return reroute_size;
  }

  public void rerouteSize(long size)
  {
    reroute_size = size;
  }

  public String[] permissions()
  {
    return permissions;
  }

  public void permissions(String[] perms)
  {
    permissions = perms;
  }

  @Override
  public String toString()
  {
    StringBuilder result = new StringBuilder();
    String NEW_LINE = System.getProperty("line.separator");

    result.append(this.getClass().getName() + " Object {" + NEW_LINE);
    result.append(" RetainFulcrum : " + retainFulcrum() + NEW_LINE);
    result.append(" MaxFileSize   : " + maxFileSize() + NEW_LINE);
    result.append(" DefNoticPolicy: " + defaultNotificationPolicy() + NEW_LINE);
    result.append(" RetainLarge   : " + retainLarge() + NEW_LINE);
    result.append(" CabinetSize   : " + cabinetSize() + NEW_LINE);
    result.append(" RetainSmall   : " + retainSmall() + NEW_LINE);
    result.append(" CabinetUsed   : " + cabinetUsed() + NEW_LINE);
    result.append(" RerouteSize   : " + rerouteSize() + NEW_LINE);
    result.append(" Permissions   : " + Arrays.toString(permissions())
        + NEW_LINE);
    result.append("}");

    return result.toString();
  }
}
