/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package sparkweave4j.client;

public class SwHelpers
{
  static String adaptPath(String path)
  {
    if (path.startsWith("/")) {
      path = path.substring(1);
    }
    return path;
  }

  static String removeTrailingCharacter(String str, char character)
  {
    if (str == null || str.length() == 0) {
      return str;
    }
    if (str.charAt(str.length() - 1) == character) {
      str = str.substring(0, str.length() - 1);
    }
    return str;
  }

  static String trimEnd(String input, String suffixToRemove)
  {
    if (input != null 
    && suffixToRemove != null
    && input.endsWith(suffixToRemove)) {
      return input.substring(0, input.length() - suffixToRemove.length());
    }
    return input;
  }

  static String makePathUnix(String path)
  {
    String nPath = path;
    nPath = nPath.replace("\\", "/").replace("//", "/");
    return (nPath == "/") ? nPath : trimEnd(nPath, "/");
  }

  static String relativePath(String absPath)
  {
    String path = makePathUnix(absPath);
    return path.startsWith("/") ? path.substring(1) : path;
  }
}
