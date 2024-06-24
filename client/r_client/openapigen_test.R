# Title     : TODO
# Objective : TODO
# Created by: sidi
# Created on: 15.06.21


library(magrittr)
# library(rapiclient)
library(stringr)

library(httr)

project_url_addition <- "project"
create_project_str <- "createProject"
getProjectTagsStr <- "getProjectTags"
getProjectAttributes <- "getProjectAttributes"
headers_char_post <- c(
  "Grpc-Metadata-source" ="PythonClient",
  "Grpc-Metadata-email"="stefan.petrov@toptal.com" ,
  "Grpc-Metadata-developer_key"= "43e5360c-3a20-47f2-aec4-ff7baeaa996c" ,
  "Grpc-Metadata-scheme"= "https",
  "Content-type"="application/json"
)

library(vertaprojectserv)
api <- ApiClient$new(basePath = "https://dev.verta.ai/api/v1/modeldb",defaultHeaders = headers_char_post)
api$basePath
projectService <- openapi::ProjectServiceApi$new(apiClient = api)

projectService$ProjectServiceCreateProjectWithHttpInfo

projectService$ProjectServiceGetProjectById(id = "3f976112-3d32-42e6-98c6-62b24b63bd24")
# projectService$ProjectServiceGetProjectByIdWithHttpInfo
# projectService$ProjectServiceCreateProject(
#   vertaprojectserv$
# )

projnew <- vertaprojectserv::ModeldbCreateProject$new(name = "test_service_1",workspace_name = "Stefan_Petrov")

resp3 <- projectService$ProjectServiceCreateProject(
  projnew
)

resp3
