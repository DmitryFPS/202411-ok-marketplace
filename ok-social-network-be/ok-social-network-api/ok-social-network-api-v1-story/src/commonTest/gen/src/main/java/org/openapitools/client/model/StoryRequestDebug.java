/*
 * SocialNetwork ${VERSION_APP}
 * It's a place where people communicate with each other
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Arrays;
import org.openapitools.client.model.StoryDebug;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openapitools.client.JSON;

/**
 * StoryRequestDebug
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-17T00:28:35.731692+03:00[Europe/Moscow]", comments = "Generator version: 7.7.0")
public class StoryRequestDebug {
  public static final String SERIALIZED_NAME_DEBUG = "debug";
  @SerializedName(SERIALIZED_NAME_DEBUG)
  private StoryDebug debug;

  public StoryRequestDebug() {
  }

  public StoryRequestDebug debug(StoryDebug debug) {
    this.debug = debug;
    return this;
  }

  /**
   * Get debug
   * @return debug
   */
  @javax.annotation.Nullable
  public StoryDebug getDebug() {
    return debug;
  }

  public void setDebug(StoryDebug debug) {
    this.debug = debug;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StoryRequestDebug storyRequestDebug = (StoryRequestDebug) o;
    return Objects.equals(this.debug, storyRequestDebug.debug);
  }

  @Override
  public int hashCode() {
    return Objects.hash(debug);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StoryRequestDebug {\n");
    sb.append("    debug: ").append(toIndentedString(debug)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("debug");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to StoryRequestDebug
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!StoryRequestDebug.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in StoryRequestDebug is not found in the empty JSON string", StoryRequestDebug.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!StoryRequestDebug.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `StoryRequestDebug` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the optional field `debug`
      if (jsonObj.get("debug") != null && !jsonObj.get("debug").isJsonNull()) {
        StoryDebug.validateJsonElement(jsonObj.get("debug"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!StoryRequestDebug.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'StoryRequestDebug' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<StoryRequestDebug> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(StoryRequestDebug.class));

       return (TypeAdapter<T>) new TypeAdapter<StoryRequestDebug>() {
           @Override
           public void write(JsonWriter out, StoryRequestDebug value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public StoryRequestDebug read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of StoryRequestDebug given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of StoryRequestDebug
   * @throws IOException if the JSON string is invalid with respect to StoryRequestDebug
   */
  public static StoryRequestDebug fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, StoryRequestDebug.class);
  }

  /**
   * Convert an instance of StoryRequestDebug to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

