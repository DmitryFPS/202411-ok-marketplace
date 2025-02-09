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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.client.model.Error;
import org.openapitools.client.model.IResponse;
import org.openapitools.client.model.ResponseResult;
import org.openapitools.client.model.StoryResponseObject;

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
 * StoryReadResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-17T00:28:35.731692+03:00[Europe/Moscow]", comments = "Generator version: 7.7.0")
public class StoryReadResponse extends IResponse {
  public static final String SERIALIZED_NAME_STORY = "story";
  @SerializedName(SERIALIZED_NAME_STORY)
  private StoryResponseObject story;

  public StoryReadResponse() {
    this.responseType = this.getClass().getSimpleName();
  }

  public StoryReadResponse story(StoryResponseObject story) {
    this.story = story;
    return this;
  }

  /**
   * Get story
   * @return story
   */
  @javax.annotation.Nullable
  public StoryResponseObject getStory() {
    return story;
  }

  public void setStory(StoryResponseObject story) {
    this.story = story;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StoryReadResponse storyReadResponse = (StoryReadResponse) o;
    return Objects.equals(this.story, storyReadResponse.story) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(story, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StoryReadResponse {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    story: ").append(toIndentedString(story)).append("\n");
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
    openapiFields.add("responseType");
    openapiFields.add("result");
    openapiFields.add("errors");
    openapiFields.add("story");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to StoryReadResponse
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!StoryReadResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in StoryReadResponse is not found in the empty JSON string", StoryReadResponse.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!StoryReadResponse.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `StoryReadResponse` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!StoryReadResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'StoryReadResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<StoryReadResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(StoryReadResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<StoryReadResponse>() {
           @Override
           public void write(JsonWriter out, StoryReadResponse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public StoryReadResponse read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of StoryReadResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of StoryReadResponse
   * @throws IOException if the JSON string is invalid with respect to StoryReadResponse
   */
  public static StoryReadResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, StoryReadResponse.class);
  }

  /**
   * Convert an instance of StoryReadResponse to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

