package sparkweave4j.client;

public class SwHelpers
{
  static String AdaptPath(String path)
  {
    if (path.startsWith("/")) {
      path = path.substring(1);
    }
    return path;
  }

  static String RemoveTrailingCharacter(String str, char character)
  {
    if (str == null || str.length() == 0) {
      return str;
    }
    if (str.charAt(str.length() - 1) == character) {
      str = str.substring(0, str.length() - 1);
    }
    return str;
  }

  static String TrimEnd(String input, String suffixToRemove)
  {
    if (input != null 
    && suffixToRemove != null
    && input.endsWith(suffixToRemove)) {
      return input.substring(0, input.length() - suffixToRemove.length());
    }
    return input;
  }

  static String MakePathUnix(String path)
  {
    String nPath = path;
    nPath = nPath.replace("\\", "/").replace("//", "/");
    return (nPath == "/") ? nPath : TrimEnd(nPath, "/");
  }

  static String RelativePath(String absPath)
  {
    String path = MakePathUnix(absPath);
    return path.startsWith("/") ? path.substring(1) : path;
  }
}
