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
 * Набор фильтров для поиска
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-17T00:28:35.731692+03:00[Europe/Moscow]", comments = "Generator version: 7.7.0")
public class StoryFindFilter {
  public static final String SERIALIZED_NAME_FIND_STORAGES = "findStorages";
  @SerializedName(SERIALIZED_NAME_FIND_STORAGES)
  private String findStorages;

  public StoryFindFilter() {
  }

  public StoryFindFilter findStorages(String findStorages) {
    this.findStorages = findStorages;
    return this;
  }

  /**
   * Идентификатор пользователя
   * @return findStorages
   */
  @javax.annotation.Nullable
  public String getFindStorages() {
    return findStorages;
  }

  public void setFindStorages(String findStorages) {
    this.findStorages = findStorages;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StoryFindFilter storyFindFilter = (StoryFindFilter) o;
    return Objects.equals(this.findStorages, storyFindFilter.findStorages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(findStorages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StoryFindFilter {\n");
    sb.append("    findStorages: ").append(toIndentedString(findStorages)).append("\n");
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
    openapiFields.add("findStorages");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to StoryFindFilter
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!StoryFindFilter.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in StoryFindFilter is not found in the empty JSON string", StoryFindFilter.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!StoryFindFilter.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `StoryFindFilter` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("findStorages") != null && !jsonObj.get("findStorages").isJsonNull()) && !jsonObj.get("findStorages").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `findStorages` to be a primitive type in the JSON string but got `%s`", jsonObj.get("findStorages").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!StoryFindFilter.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'StoryFindFilter' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<StoryFindFilter> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(StoryFindFilter.class));

       return (TypeAdapter<T>) new TypeAdapter<StoryFindFilter>() {
           @Override
           public void write(JsonWriter out, StoryFindFilter value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public StoryFindFilter read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of StoryFindFilter given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of StoryFindFilter
   * @throws IOException if the JSON string is invalid with respect to StoryFindFilter
   */
  public static StoryFindFilter fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, StoryFindFilter.class);
  }

  /**
   * Convert an instance of StoryFindFilter to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

