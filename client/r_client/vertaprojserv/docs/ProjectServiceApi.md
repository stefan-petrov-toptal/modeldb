# ProjectServiceApi

All URIs are relative to *http://localhost/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**ProjectServiceAddProjectAttributes**](ProjectServiceApi.md#ProjectServiceAddProjectAttributes) | **POST** /project/addProjectAttributes | 
[**ProjectServiceAddProjectTag**](ProjectServiceApi.md#ProjectServiceAddProjectTag) | **POST** /project/addProjectTag | 
[**ProjectServiceAddProjectTags**](ProjectServiceApi.md#ProjectServiceAddProjectTags) | **POST** /project/addProjectTags | 
[**ProjectServiceCreateProject**](ProjectServiceApi.md#ProjectServiceCreateProject) | **POST** /project/createProject | 
[**ProjectServiceDeepCopyProject**](ProjectServiceApi.md#ProjectServiceDeepCopyProject) | **POST** /project/deepCopyProject | 
[**ProjectServiceDeleteArtifact**](ProjectServiceApi.md#ProjectServiceDeleteArtifact) | **DELETE** /project/deleteArtifact | 
[**ProjectServiceDeleteProject**](ProjectServiceApi.md#ProjectServiceDeleteProject) | **DELETE** /project/deleteProject | 
[**ProjectServiceDeleteProjectAttributes**](ProjectServiceApi.md#ProjectServiceDeleteProjectAttributes) | **DELETE** /project/deleteProjectAttributes | 
[**ProjectServiceDeleteProjectTag**](ProjectServiceApi.md#ProjectServiceDeleteProjectTag) | **DELETE** /project/deleteProjectTag | 
[**ProjectServiceDeleteProjectTags**](ProjectServiceApi.md#ProjectServiceDeleteProjectTags) | **DELETE** /project/deleteProjectTags | 
[**ProjectServiceDeleteProjects**](ProjectServiceApi.md#ProjectServiceDeleteProjects) | **DELETE** /project/deleteProjects | 
[**ProjectServiceFindProjects**](ProjectServiceApi.md#ProjectServiceFindProjects) | **POST** /project/findProjects | queries
[**ProjectServiceGetArtifacts**](ProjectServiceApi.md#ProjectServiceGetArtifacts) | **GET** /project/getArtifacts | 
[**ProjectServiceGetProjectAttributes**](ProjectServiceApi.md#ProjectServiceGetProjectAttributes) | **GET** /project/getProjectAttributes | 
[**ProjectServiceGetProjectById**](ProjectServiceApi.md#ProjectServiceGetProjectById) | **GET** /project/getProjectById | 
[**ProjectServiceGetProjectByName**](ProjectServiceApi.md#ProjectServiceGetProjectByName) | **GET** /project/getProjectByName | 
[**ProjectServiceGetProjectCodeVersion**](ProjectServiceApi.md#ProjectServiceGetProjectCodeVersion) | **GET** /project/getProjectCodeVersion | 
[**ProjectServiceGetProjectDatasetCount**](ProjectServiceApi.md#ProjectServiceGetProjectDatasetCount) | **GET** /project/getProjectDatasetCount | 
[**ProjectServiceGetProjectReadme**](ProjectServiceApi.md#ProjectServiceGetProjectReadme) | **GET** /project/getProjectReadme | 
[**ProjectServiceGetProjectShortName**](ProjectServiceApi.md#ProjectServiceGetProjectShortName) | **GET** /project/getProjectShortName | 
[**ProjectServiceGetProjectTags**](ProjectServiceApi.md#ProjectServiceGetProjectTags) | **GET** /project/getProjectTags | 
[**ProjectServiceGetProjects**](ProjectServiceApi.md#ProjectServiceGetProjects) | **GET** /project/getProjects | 
[**ProjectServiceGetSummary**](ProjectServiceApi.md#ProjectServiceGetSummary) | **GET** /project/getSummary | 
[**ProjectServiceGetUrlForArtifact**](ProjectServiceApi.md#ProjectServiceGetUrlForArtifact) | **POST** /project/getUrlForArtifact | artifacts
[**ProjectServiceLogArtifacts**](ProjectServiceApi.md#ProjectServiceLogArtifacts) | **POST** /project/logArtifacts | artifacts
[**ProjectServiceLogProjectCodeVersion**](ProjectServiceApi.md#ProjectServiceLogProjectCodeVersion) | **POST** /project/logProjectCodeVersion | code version
[**ProjectServiceSetProjectReadme**](ProjectServiceApi.md#ProjectServiceSetProjectReadme) | **POST** /project/setProjectReadme | 
[**ProjectServiceSetProjectShortName**](ProjectServiceApi.md#ProjectServiceSetProjectShortName) | **POST** /project/setProjectShortName | 
[**ProjectServiceUpdateProjectAttributes**](ProjectServiceApi.md#ProjectServiceUpdateProjectAttributes) | **POST** /project/updateProjectAttributes | 
[**ProjectServiceUpdateProjectDescription**](ProjectServiceApi.md#ProjectServiceUpdateProjectDescription) | **POST** /project/updateProjectDescription | 
[**ProjectServiceUpdateProjectName**](ProjectServiceApi.md#ProjectServiceUpdateProjectName) | **POST** /project/updateProjectName | 
[**ProjectServiceVerifyConnection**](ProjectServiceApi.md#ProjectServiceVerifyConnection) | **GET** /project/verifyConnection | 


# **ProjectServiceAddProjectAttributes**
> ModeldbAddProjectAttributesResponse ProjectServiceAddProjectAttributes(body)



### Example
```R
library(openapi)

var.body <- modeldbAddProjectAttributes$new("id_example", list(commonKeyValue$new("key_example", 123, ValueTypeEnumValueType$new()))) # ModeldbAddProjectAttributes | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceAddProjectAttributes(var.body)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ModeldbAddProjectAttributes**](ModeldbAddProjectAttributes.md)|  | 

### Return type

[**ModeldbAddProjectAttributesResponse**](modeldbAddProjectAttributesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceAddProjectTag**
> ModeldbAddProjectTagResponse ProjectServiceAddProjectTag(body)



### Example
```R
library(openapi)

var.body <- modeldbAddProjectTag$new("id_example", "tag_example") # ModeldbAddProjectTag | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceAddProjectTag(var.body)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ModeldbAddProjectTag**](ModeldbAddProjectTag.md)|  | 

### Return type

[**ModeldbAddProjectTagResponse**](modeldbAddProjectTagResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceAddProjectTags**
> ModeldbAddProjectTagsResponse ProjectServiceAddProjectTags(body)



### Example
```R
library(openapi)

var.body <- modeldbAddProjectTags$new("id_example", list("tags_example")) # ModeldbAddProjectTags | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceAddProjectTags(var.body)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ModeldbAddProjectTags**](ModeldbAddProjectTags.md)|  | 

### Return type

[**ModeldbAddProjectTagsResponse**](modeldbAddProjectTagsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceCreateProject**
> ModeldbCreateProjectResponse ProjectServiceCreateProject(body)



### Example
```R
library(openapi)

var.body <- modeldbCreateProject$new("name_example", "description_example", list(commonKeyValue$new("key_example", 123, ValueTypeEnumValueType$new())), list("tags_example"), "readme_text_example", modeldbProjectVisibility$new(), list(commonArtifact$new("key_example", "path_example", "path_only_example", ArtifactTypeEnumArtifactType$new(), "linked_artifact_id_example", "filename_extension_example")), "workspace_name_example", "date_created_example", uacCollaboratorPermissions$new(CollaboratorTypeEnumCollaboratorType$new(), TernaryEnumTernary$new(), TernaryEnumTernary$new()), uacResourceVisibility$new()) # ModeldbCreateProject | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceCreateProject(var.body)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ModeldbCreateProject**](ModeldbCreateProject.md)|  | 

### Return type

[**ModeldbCreateProjectResponse**](modeldbCreateProjectResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceDeepCopyProject**
> ModeldbDeepCopyProjectResponse ProjectServiceDeepCopyProject(body)



### Example
```R
library(openapi)

var.body <- modeldbDeepCopyProject$new("id_example") # ModeldbDeepCopyProject | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceDeepCopyProject(var.body)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ModeldbDeepCopyProject**](ModeldbDeepCopyProject.md)|  | 

### Return type

[**ModeldbDeepCopyProjectResponse**](modeldbDeepCopyProjectResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceDeleteArtifact**
> ModeldbDeleteProjectArtifactResponse ProjectServiceDeleteArtifact(body)



### Example
```R
library(openapi)

var.body <- modeldbDeleteProjectArtifact$new("id_example", "key_example") # ModeldbDeleteProjectArtifact | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceDeleteArtifact(var.body)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ModeldbDeleteProjectArtifact**](ModeldbDeleteProjectArtifact.md)|  | 

### Return type

[**ModeldbDeleteProjectArtifactResponse**](modeldbDeleteProjectArtifactResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceDeleteProject**
> ModeldbDeleteProjectResponse ProjectServiceDeleteProject(body)



### Example
```R
library(openapi)

var.body <- modeldbDeleteProject$new("id_example") # ModeldbDeleteProject | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceDeleteProject(var.body)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ModeldbDeleteProject**](ModeldbDeleteProject.md)|  | 

### Return type

[**ModeldbDeleteProjectResponse**](modeldbDeleteProjectResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceDeleteProjectAttributes**
> ModeldbDeleteProjectAttributesResponse ProjectServiceDeleteProjectAttributes(body)



### Example
```R
library(openapi)

var.body <- modeldbDeleteProjectAttributes$new("id_example", list("attribute_keys_example"), "delete_all_example") # ModeldbDeleteProjectAttributes | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceDeleteProjectAttributes(var.body)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ModeldbDeleteProjectAttributes**](ModeldbDeleteProjectAttributes.md)|  | 

### Return type

[**ModeldbDeleteProjectAttributesResponse**](modeldbDeleteProjectAttributesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceDeleteProjectTag**
> ModeldbDeleteProjectTagResponse ProjectServiceDeleteProjectTag(body)



### Example
```R
library(openapi)

var.body <- modeldbDeleteProjectTag$new("id_example", "tag_example") # ModeldbDeleteProjectTag | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceDeleteProjectTag(var.body)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ModeldbDeleteProjectTag**](ModeldbDeleteProjectTag.md)|  | 

### Return type

[**ModeldbDeleteProjectTagResponse**](modeldbDeleteProjectTagResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceDeleteProjectTags**
> ModeldbDeleteProjectTagsResponse ProjectServiceDeleteProjectTags(body)



### Example
```R
library(openapi)

var.body <- modeldbDeleteProjectTags$new("id_example", list("tags_example"), "delete_all_example") # ModeldbDeleteProjectTags | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceDeleteProjectTags(var.body)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ModeldbDeleteProjectTags**](ModeldbDeleteProjectTags.md)|  | 

### Return type

[**ModeldbDeleteProjectTagsResponse**](modeldbDeleteProjectTagsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceDeleteProjects**
> ModeldbDeleteProjectsResponse ProjectServiceDeleteProjects(body)



### Example
```R
library(openapi)

var.body <- modeldbDeleteProjects$new(list("ids_example")) # ModeldbDeleteProjects | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceDeleteProjects(var.body)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ModeldbDeleteProjects**](ModeldbDeleteProjects.md)|  | 

### Return type

[**ModeldbDeleteProjectsResponse**](modeldbDeleteProjectsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceFindProjects**
> ModeldbFindProjectsResponse ProjectServiceFindProjects(body)

queries

### Example
```R
library(openapi)

var.body <- modeldbFindProjects$new(list("project_ids_example"), list(commonKeyValueQuery$new("key_example", 123, ValueTypeEnumValueType$new(), OperatorEnumOperator$new())), "ids_only_example", "workspace_name_example", 123, 123, "ascending_example", "sort_key_example") # ModeldbFindProjects | 

#queries
api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceFindProjects(var.body)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ModeldbFindProjects**](ModeldbFindProjects.md)|  | 

### Return type

[**ModeldbFindProjectsResponse**](modeldbFindProjectsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceGetArtifacts**
> ModeldbGetArtifactsResponse ProjectServiceGetArtifacts(id=var.id, key=var.key)



### Example
```R
library(openapi)

var.id <- 'id_example' # character | 
var.key <- 'key_example' # character | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceGetArtifacts(id=var.id, key=var.key)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **character**|  | [optional] 
 **key** | **character**|  | [optional] 

### Return type

[**ModeldbGetArtifactsResponse**](modeldbGetArtifactsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceGetProjectAttributes**
> ModeldbGetAttributesResponse ProjectServiceGetProjectAttributes(id=var.id, attribute.keys=var.attribute.keys, get.all=var.get.all)



### Example
```R
library(openapi)

var.id <- 'id_example' # character | 
var.attribute.keys <- list("inner_example") # array[character] | 
var.get.all <- 'get.all_example' # character | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceGetProjectAttributes(id=var.id, attribute.keys=var.attribute.keys, get.all=var.get.all)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **character**|  | [optional] 
 **attribute.keys** | list( **character** )|  | [optional] 
 **get.all** | **character**|  | [optional] 

### Return type

[**ModeldbGetAttributesResponse**](modeldbGetAttributesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceGetProjectById**
> ModeldbGetProjectByIdResponse ProjectServiceGetProjectById(id=var.id)



### Example
```R
library(openapi)

var.id <- 'id_example' # character | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceGetProjectById(id=var.id)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **character**|  | [optional] 

### Return type

[**ModeldbGetProjectByIdResponse**](modeldbGetProjectByIdResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceGetProjectByName**
> ModeldbGetProjectByNameResponse ProjectServiceGetProjectByName(name=var.name, workspace.name=var.workspace.name)



### Example
```R
library(openapi)

var.name <- 'name_example' # character | 
var.workspace.name <- 'workspace.name_example' # character | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceGetProjectByName(name=var.name, workspace.name=var.workspace.name)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **character**|  | [optional] 
 **workspace.name** | **character**|  | [optional] 

### Return type

[**ModeldbGetProjectByNameResponse**](modeldbGetProjectByNameResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceGetProjectCodeVersion**
> ModeldbGetProjectCodeVersionResponse ProjectServiceGetProjectCodeVersion(id=var.id)



### Example
```R
library(openapi)

var.id <- 'id_example' # character | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceGetProjectCodeVersion(id=var.id)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **character**|  | [optional] 

### Return type

[**ModeldbGetProjectCodeVersionResponse**](modeldbGetProjectCodeVersionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceGetProjectDatasetCount**
> ModeldbGetProjectDatasetCountResponse ProjectServiceGetProjectDatasetCount(project.id=var.project.id)



### Example
```R
library(openapi)

var.project.id <- 'project.id_example' # character | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceGetProjectDatasetCount(project.id=var.project.id)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project.id** | **character**|  | [optional] 

### Return type

[**ModeldbGetProjectDatasetCountResponse**](modeldbGetProjectDatasetCountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceGetProjectReadme**
> ModeldbGetProjectReadmeResponse ProjectServiceGetProjectReadme(id=var.id)



### Example
```R
library(openapi)

var.id <- 'id_example' # character | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceGetProjectReadme(id=var.id)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **character**|  | [optional] 

### Return type

[**ModeldbGetProjectReadmeResponse**](modeldbGetProjectReadmeResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceGetProjectShortName**
> ModeldbGetProjectShortNameResponse ProjectServiceGetProjectShortName(id=var.id)



### Example
```R
library(openapi)

var.id <- 'id_example' # character | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceGetProjectShortName(id=var.id)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **character**|  | [optional] 

### Return type

[**ModeldbGetProjectShortNameResponse**](modeldbGetProjectShortNameResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceGetProjectTags**
> ModeldbGetTagsResponse ProjectServiceGetProjectTags(id=var.id)



### Example
```R
library(openapi)

var.id <- 'id_example' # character | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceGetProjectTags(id=var.id)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **character**|  | [optional] 

### Return type

[**ModeldbGetTagsResponse**](modeldbGetTagsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceGetProjects**
> ModeldbGetProjectsResponse ProjectServiceGetProjects(page.number=var.page.number, page.limit=var.page.limit, ascending=var.ascending, sort.key=var.sort.key, workspace.name=var.workspace.name)



### Example
```R
library(openapi)

var.page.number <- 56 # integer | 
var.page.limit <- 56 # integer | 
var.ascending <- 'ascending_example' # character | 
var.sort.key <- 'sort.key_example' # character | 
var.workspace.name <- 'workspace.name_example' # character | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceGetProjects(page.number=var.page.number, page.limit=var.page.limit, ascending=var.ascending, sort.key=var.sort.key, workspace.name=var.workspace.name)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page.number** | **integer**|  | [optional] 
 **page.limit** | **integer**|  | [optional] 
 **ascending** | **character**|  | [optional] 
 **sort.key** | **character**|  | [optional] 
 **workspace.name** | **character**|  | [optional] 

### Return type

[**ModeldbGetProjectsResponse**](modeldbGetProjectsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceGetSummary**
> ModeldbGetSummaryResponse ProjectServiceGetSummary(entity.id=var.entity.id)



### Example
```R
library(openapi)

var.entity.id <- 'entity.id_example' # character | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceGetSummary(entity.id=var.entity.id)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entity.id** | **character**|  | [optional] 

### Return type

[**ModeldbGetSummaryResponse**](modeldbGetSummaryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceGetUrlForArtifact**
> ModeldbGetUrlForArtifactResponse ProjectServiceGetUrlForArtifact(body)

artifacts

### Example
```R
library(openapi)

var.body <- modeldbGetUrlForArtifact$new("id_example", "key_example", "method_example", ArtifactTypeEnumArtifactType$new(), "part_number_example") # ModeldbGetUrlForArtifact | 

#artifacts
api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceGetUrlForArtifact(var.body)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ModeldbGetUrlForArtifact**](ModeldbGetUrlForArtifact.md)|  | 

### Return type

[**ModeldbGetUrlForArtifactResponse**](modeldbGetUrlForArtifactResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceLogArtifacts**
> ModeldbLogProjectArtifactsResponse ProjectServiceLogArtifacts(body)

artifacts

### Example
```R
library(openapi)

var.body <- modeldbLogProjectArtifacts$new("id_example", list(commonArtifact$new("key_example", "path_example", "path_only_example", ArtifactTypeEnumArtifactType$new(), "linked_artifact_id_example", "filename_extension_example"))) # ModeldbLogProjectArtifacts | 

#artifacts
api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceLogArtifacts(var.body)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ModeldbLogProjectArtifacts**](ModeldbLogProjectArtifacts.md)|  | 

### Return type

[**ModeldbLogProjectArtifactsResponse**](modeldbLogProjectArtifactsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceLogProjectCodeVersion**
> ModeldbLogProjectCodeVersionResponse ProjectServiceLogProjectCodeVersion(body)

code version

### Example
```R
library(openapi)

var.body <- modeldbLogProjectCodeVersion$new("id_example", modeldbCodeVersion$new(modeldbGitSnapshot$new(list("filepaths_example"), "repo_example", "hash_example", TernaryEnumTernary$new()), commonArtifact$new("key_example", "path_example", "path_only_example", ArtifactTypeEnumArtifactType$new(), "linked_artifact_id_example", "filename_extension_example"), "date_logged_example")) # ModeldbLogProjectCodeVersion | 

#code version
api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceLogProjectCodeVersion(var.body)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ModeldbLogProjectCodeVersion**](ModeldbLogProjectCodeVersion.md)|  | 

### Return type

[**ModeldbLogProjectCodeVersionResponse**](modeldbLogProjectCodeVersionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceSetProjectReadme**
> ModeldbSetProjectReadmeResponse ProjectServiceSetProjectReadme(body)



### Example
```R
library(openapi)

var.body <- modeldbSetProjectReadme$new("id_example", "readme_text_example") # ModeldbSetProjectReadme | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceSetProjectReadme(var.body)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ModeldbSetProjectReadme**](ModeldbSetProjectReadme.md)|  | 

### Return type

[**ModeldbSetProjectReadmeResponse**](modeldbSetProjectReadmeResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceSetProjectShortName**
> ModeldbSetProjectShortNameResponse ProjectServiceSetProjectShortName(body)



### Example
```R
library(openapi)

var.body <- modeldbSetProjectShortName$new("id_example", "short_name_example") # ModeldbSetProjectShortName | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceSetProjectShortName(var.body)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ModeldbSetProjectShortName**](ModeldbSetProjectShortName.md)|  | 

### Return type

[**ModeldbSetProjectShortNameResponse**](modeldbSetProjectShortNameResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceUpdateProjectAttributes**
> ModeldbUpdateProjectAttributesResponse ProjectServiceUpdateProjectAttributes(body)



### Example
```R
library(openapi)

var.body <- modeldbUpdateProjectAttributes$new("id_example", commonKeyValue$new("key_example", 123, ValueTypeEnumValueType$new())) # ModeldbUpdateProjectAttributes | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceUpdateProjectAttributes(var.body)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ModeldbUpdateProjectAttributes**](ModeldbUpdateProjectAttributes.md)|  | 

### Return type

[**ModeldbUpdateProjectAttributesResponse**](modeldbUpdateProjectAttributesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceUpdateProjectDescription**
> ModeldbUpdateProjectDescriptionResponse ProjectServiceUpdateProjectDescription(body)



### Example
```R
library(openapi)

var.body <- modeldbUpdateProjectDescription$new("id_example", "description_example") # ModeldbUpdateProjectDescription | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceUpdateProjectDescription(var.body)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ModeldbUpdateProjectDescription**](ModeldbUpdateProjectDescription.md)|  | 

### Return type

[**ModeldbUpdateProjectDescriptionResponse**](modeldbUpdateProjectDescriptionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceUpdateProjectName**
> ModeldbUpdateProjectNameResponse ProjectServiceUpdateProjectName(body)



### Example
```R
library(openapi)

var.body <- modeldbUpdateProjectName$new("id_example", "name_example") # ModeldbUpdateProjectName | 

api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceUpdateProjectName(var.body)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ModeldbUpdateProjectName**](ModeldbUpdateProjectName.md)|  | 

### Return type

[**ModeldbUpdateProjectNameResponse**](modeldbUpdateProjectNameResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

# **ProjectServiceVerifyConnection**
> ModeldbVerifyConnectionResponse ProjectServiceVerifyConnection()



### Example
```R
library(openapi)


api.instance <- ProjectServiceApi$new()
result <- api.instance$ProjectServiceVerifyConnection()
dput(result)
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ModeldbVerifyConnectionResponse**](modeldbVerifyConnectionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A successful response. |  -  |
| **0** | An unexpected error response |  -  |

