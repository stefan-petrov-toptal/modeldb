verta_url <- "https://dev.verta.ai"

headers_char_post <- c(
  "Grpc-Metadata-source" ="PythonClient",
  "Grpc-Metadata-email"=Sys.getenv("VERTA_EMAIL") ,
  "Grpc-Metadata-developer_key"= Sys.getenv("VERTA_DEV_KEY") ,
  "Grpc-Metadata-scheme"= "https",
  "Content-type"="application/json"
)

headers_char_get <- c(
  "Grpc-Metadata-source" ="PythonClient",
  "Grpc-Metadata-email"=Sys.getenv("VERTA_EMAIL") ,
  "Grpc-Metadata-developer_key"= Sys.getenv("VERTA_DEV_KEY") ,
  "Content-type"="application/json"
)

modeldb_base <- "/api/v1/modeldb"


















# 



ProjectService_addProjectAttributes <- function(





body

) {
    stopifnot(!is.null(body))  

  


resp <- POST(

url = str_c(verta_url,modeldb_base,"/project/addProjectAttributes"),
add_headers(
.headers=   headers_char_post 
),

body=body

, encode="json"
)


return(resp)

}



ProjectService_addProjectTag <- function(





body

) {
    stopifnot(!is.null(body))  

  


resp <- POST(

url = str_c(verta_url,modeldb_base,"/project/addProjectTag"),
add_headers(
.headers=   headers_char_post 
),

body=body

, encode="json"
)


return(resp)

}



ProjectService_addProjectTags <- function(





body

) {
    stopifnot(!is.null(body))  

  


resp <- POST(

url = str_c(verta_url,modeldb_base,"/project/addProjectTags"),
add_headers(
.headers=   headers_char_post 
),

body=body

, encode="json"
)


return(resp)

}



ProjectService_createProject <- function(





body

) {
    stopifnot(!is.null(body))  

  


resp <- POST(

url = str_c(verta_url,modeldb_base,"/project/createProject"),
add_headers(
.headers=   headers_char_post 
),

body=body

, encode="json"
)


return(resp)

}



ProjectService_deepCopyProject <- function(





body

) {
    stopifnot(!is.null(body))  

  


resp <- POST(

url = str_c(verta_url,modeldb_base,"/project/deepCopyProject"),
add_headers(
.headers=   headers_char_post 
),

body=body

, encode="json"
)


return(resp)

}



ProjectService_deleteArtifact <- function(





body

) {
    stopifnot(!is.null(body))  

  


resp <- DELETE(

url = str_c(verta_url,modeldb_base,"/project/deleteArtifact"),
add_headers(
.headers=   headers_char_get 
),

, encode="json"
)


return(resp)

}



ProjectService_deleteProject <- function(





body

) {
    stopifnot(!is.null(body))  

  


resp <- DELETE(

url = str_c(verta_url,modeldb_base,"/project/deleteProject"),
add_headers(
.headers=   headers_char_get 
),

, encode="json"
)


return(resp)

}



ProjectService_deleteProjectAttributes <- function(





body

) {
    stopifnot(!is.null(body))  

  


resp <- DELETE(

url = str_c(verta_url,modeldb_base,"/project/deleteProjectAttributes"),
add_headers(
.headers=   headers_char_get 
),

, encode="json"
)


return(resp)

}



ProjectService_deleteProjectTag <- function(





body

) {
    stopifnot(!is.null(body))  

  


resp <- DELETE(

url = str_c(verta_url,modeldb_base,"/project/deleteProjectTag"),
add_headers(
.headers=   headers_char_get 
),

, encode="json"
)


return(resp)

}



ProjectService_deleteProjectTags <- function(





body

) {
    stopifnot(!is.null(body))  

  


resp <- DELETE(

url = str_c(verta_url,modeldb_base,"/project/deleteProjectTags"),
add_headers(
.headers=   headers_char_get 
),

, encode="json"
)


return(resp)

}



ProjectService_deleteProjects <- function(





body

) {
    stopifnot(!is.null(body))  

  


resp <- DELETE(

url = str_c(verta_url,modeldb_base,"/project/deleteProjects"),
add_headers(
.headers=   headers_char_get 
),

, encode="json"
)


return(resp)

}



ProjectService_findProjects <- function(





body

) {
    stopifnot(!is.null(body))  

  


resp <- POST(

url = str_c(verta_url,modeldb_base,"/project/findProjects"),
add_headers(
.headers=   headers_char_post 
),

body=body

, encode="json"
)


return(resp)

}



ProjectService_getArtifacts <- function(





id

,

key

) {
    

  
    

  


resp <- GET(

url = str_c(verta_url,modeldb_base,"/project/getArtifacts"),
add_headers(
.headers=   headers_char_get 
),

query = list(


  

id = id


,

key = key

)

, encode="json"
)


return(resp)

}



ProjectService_getProjectAttributes <- function(





id

,

attribute_keys

,

get_all

) {
    

  
    

  
    

  


resp <- GET(

url = str_c(verta_url,modeldb_base,"/project/getProjectAttributes"),
add_headers(
.headers=   headers_char_get 
),

query = list(


  

id = id


,

attribute_keys = attribute_keys


,

get_all = get_all

)

, encode="json"
)


return(resp)

}



ProjectService_getProjectById <- function(





id

) {
    

  


resp <- GET(

url = str_c(verta_url,modeldb_base,"/project/getProjectById"),
add_headers(
.headers=   headers_char_get 
),

query = list(


  

id = id

)

, encode="json"
)


return(resp)

}



ProjectService_getProjectByName <- function(





name

,

workspace_name

) {
    

  
    

  


resp <- GET(

url = str_c(verta_url,modeldb_base,"/project/getProjectByName"),
add_headers(
.headers=   headers_char_get 
),

query = list(


  

name = name


,

workspace_name = workspace_name

)

, encode="json"
)


return(resp)

}



ProjectService_getProjectCodeVersion <- function(





id

) {
    

  


resp <- GET(

url = str_c(verta_url,modeldb_base,"/project/getProjectCodeVersion"),
add_headers(
.headers=   headers_char_get 
),

query = list(


  

id = id

)

, encode="json"
)


return(resp)

}



ProjectService_getProjectDatasetCount <- function(





project_id

) {
    

  


resp <- GET(

url = str_c(verta_url,modeldb_base,"/project/getProjectDatasetCount"),
add_headers(
.headers=   headers_char_get 
),

query = list(


  

project_id = project_id

)

, encode="json"
)


return(resp)

}



ProjectService_getProjectReadme <- function(





id

) {
    

  


resp <- GET(

url = str_c(verta_url,modeldb_base,"/project/getProjectReadme"),
add_headers(
.headers=   headers_char_get 
),

query = list(


  

id = id

)

, encode="json"
)


return(resp)

}



ProjectService_getProjectShortName <- function(





id

) {
    

  


resp <- GET(

url = str_c(verta_url,modeldb_base,"/project/getProjectShortName"),
add_headers(
.headers=   headers_char_get 
),

query = list(


  

id = id

)

, encode="json"
)


return(resp)

}



ProjectService_getProjectTags <- function(





id

) {
    

  


resp <- GET(

url = str_c(verta_url,modeldb_base,"/project/getProjectTags"),
add_headers(
.headers=   headers_char_get 
),

query = list(


  

id = id

)

, encode="json"
)


return(resp)

}



ProjectService_getProjects <- function(





page_number

,

page_limit

,

ascending

,

sort_key

,

workspace_name

) {
    

  
    

  
    

  
    

  
    

  


resp <- GET(

url = str_c(verta_url,modeldb_base,"/project/getProjects"),
add_headers(
.headers=   headers_char_get 
),

query = list(


  

page_number = page_number


,

page_limit = page_limit


,

ascending = ascending


,

sort_key = sort_key


,

workspace_name = workspace_name

)

, encode="json"
)


return(resp)

}



ProjectService_getSummary <- function(





entityId

) {
    

  


resp <- GET(

url = str_c(verta_url,modeldb_base,"/project/getSummary"),
add_headers(
.headers=   headers_char_get 
),

query = list(


  

entityId = entityId

)

, encode="json"
)


return(resp)

}



ProjectService_getUrlForArtifact <- function(





body

) {
    stopifnot(!is.null(body))  

  


resp <- POST(

url = str_c(verta_url,modeldb_base,"/project/getUrlForArtifact"),
add_headers(
.headers=   headers_char_post 
),

body=body

, encode="json"
)


return(resp)

}



ProjectService_logArtifacts <- function(





body

) {
    stopifnot(!is.null(body))  

  


resp <- POST(

url = str_c(verta_url,modeldb_base,"/project/logArtifacts"),
add_headers(
.headers=   headers_char_post 
),

body=body

, encode="json"
)


return(resp)

}



ProjectService_logProjectCodeVersion <- function(





body

) {
    stopifnot(!is.null(body))  

  


resp <- POST(

url = str_c(verta_url,modeldb_base,"/project/logProjectCodeVersion"),
add_headers(
.headers=   headers_char_post 
),

body=body

, encode="json"
)


return(resp)

}



ProjectService_setProjectReadme <- function(





body

) {
    stopifnot(!is.null(body))  

  


resp <- POST(

url = str_c(verta_url,modeldb_base,"/project/setProjectReadme"),
add_headers(
.headers=   headers_char_post 
),

body=body

, encode="json"
)


return(resp)

}



ProjectService_setProjectShortName <- function(





body

) {
    stopifnot(!is.null(body))  

  


resp <- POST(

url = str_c(verta_url,modeldb_base,"/project/setProjectShortName"),
add_headers(
.headers=   headers_char_post 
),

body=body

, encode="json"
)


return(resp)

}



ProjectService_updateProjectAttributes <- function(





body

) {
    stopifnot(!is.null(body))  

  


resp <- POST(

url = str_c(verta_url,modeldb_base,"/project/updateProjectAttributes"),
add_headers(
.headers=   headers_char_post 
),

body=body

, encode="json"
)


return(resp)

}



ProjectService_updateProjectDescription <- function(





body

) {
    stopifnot(!is.null(body))  

  


resp <- POST(

url = str_c(verta_url,modeldb_base,"/project/updateProjectDescription"),
add_headers(
.headers=   headers_char_post 
),

body=body

, encode="json"
)


return(resp)

}



ProjectService_updateProjectName <- function(





body

) {
    stopifnot(!is.null(body))  

  


resp <- POST(

url = str_c(verta_url,modeldb_base,"/project/updateProjectName"),
add_headers(
.headers=   headers_char_post 
),

body=body

, encode="json"
)


return(resp)

}



ProjectService_verifyConnection <- function(



) {


resp <- GET(

url = str_c(verta_url,modeldb_base,"/project/verifyConnection"),
add_headers(
.headers=   headers_char_get 
),

query = list(

)

, encode="json"
)


return(resp)

}
