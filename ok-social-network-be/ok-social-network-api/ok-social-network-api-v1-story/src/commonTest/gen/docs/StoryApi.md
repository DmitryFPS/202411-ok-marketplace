# StoryApi

All URIs are relative to *http://localhost:8080/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**storyCreate**](StoryApi.md#storyCreate) | **POST** /story/create | Create story |
| [**storyDelete**](StoryApi.md#storyDelete) | **POST** /story/delete | Delete story |
| [**storyFind**](StoryApi.md#storyFind) | **POST** /story/find | Search story |
| [**storyRead**](StoryApi.md#storyRead) | **POST** /story/read | Read story |
| [**storyUpdate**](StoryApi.md#storyUpdate) | **POST** /story/update | Update story |


<a id="storyCreate"></a>
# **storyCreate**
> StoryCreateResponse storyCreate(storyCreateRequest)

Create story

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StoryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/v1");

    StoryApi apiInstance = new StoryApi(defaultClient);
    StoryCreateRequest storyCreateRequest = new StoryCreateRequest(); // StoryCreateRequest | Request body
    try {
      StoryCreateResponse result = apiInstance.storyCreate(storyCreateRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StoryApi#storyCreate");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **storyCreateRequest** | [**StoryCreateRequest**](StoryCreateRequest.md)| Request body | |

### Return type

[**StoryCreateResponse**](StoryCreateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success |  -  |

<a id="storyDelete"></a>
# **storyDelete**
> StoryDeleteResponse storyDelete(storyDeleteRequest)

Delete story

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StoryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/v1");

    StoryApi apiInstance = new StoryApi(defaultClient);
    StoryDeleteRequest storyDeleteRequest = new StoryDeleteRequest(); // StoryDeleteRequest | Request body
    try {
      StoryDeleteResponse result = apiInstance.storyDelete(storyDeleteRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StoryApi#storyDelete");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **storyDeleteRequest** | [**StoryDeleteRequest**](StoryDeleteRequest.md)| Request body | |

### Return type

[**StoryDeleteResponse**](StoryDeleteResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success |  -  |

<a id="storyFind"></a>
# **storyFind**
> StoryFindResponse storyFind(storyFindRequest)

Search story

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StoryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/v1");

    StoryApi apiInstance = new StoryApi(defaultClient);
    StoryFindRequest storyFindRequest = new StoryFindRequest(); // StoryFindRequest | Request body
    try {
      StoryFindResponse result = apiInstance.storyFind(storyFindRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StoryApi#storyFind");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **storyFindRequest** | [**StoryFindRequest**](StoryFindRequest.md)| Request body | |

### Return type

[**StoryFindResponse**](StoryFindResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success |  -  |

<a id="storyRead"></a>
# **storyRead**
> StoryReadResponse storyRead(storyReadRequest)

Read story

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StoryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/v1");

    StoryApi apiInstance = new StoryApi(defaultClient);
    StoryReadRequest storyReadRequest = new StoryReadRequest(); // StoryReadRequest | Request body
    try {
      StoryReadResponse result = apiInstance.storyRead(storyReadRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StoryApi#storyRead");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **storyReadRequest** | [**StoryReadRequest**](StoryReadRequest.md)| Request body | |

### Return type

[**StoryReadResponse**](StoryReadResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success |  -  |

<a id="storyUpdate"></a>
# **storyUpdate**
> StoryUpdateResponse storyUpdate(storyUpdateRequest)

Update story

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StoryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/v1");

    StoryApi apiInstance = new StoryApi(defaultClient);
    StoryUpdateRequest storyUpdateRequest = new StoryUpdateRequest(); // StoryUpdateRequest | Request body
    try {
      StoryUpdateResponse result = apiInstance.storyUpdate(storyUpdateRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StoryApi#storyUpdate");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **storyUpdateRequest** | [**StoryUpdateRequest**](StoryUpdateRequest.md)| Request body | |

### Return type

[**StoryUpdateResponse**](StoryUpdateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success |  -  |

