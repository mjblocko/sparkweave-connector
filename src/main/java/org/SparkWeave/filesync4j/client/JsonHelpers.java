package org.sparkweave.filesync4j.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonHelpers
{
  /**
   * Returns the JSON representation from string.
   * 
   * @param <T>
   * @param json
   * @param type
   * 
   */
  public static <T> T getJsonFromString(String json, Class<T> type)
  {
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.serializeNulls();
    Gson gson = gsonBuilder.create();
    return (T) gson.fromJson(json, type);
  }

}
