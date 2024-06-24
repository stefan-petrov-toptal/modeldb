library(httr)
library(jsonlite)
library(stringr)
library(magrittr)

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


{{define "stopifnotcharacter"}} {{if (eq .type "string")}} stopifnot(is.character({{.name}})) {{end}} {{end}}

{{define "stopifnotnumeric"}} {{if (eq .type "integer")}} stopifnot(is.numeric({{.name}})) {{end}} {{end}}

{{define "stopifnotvector"}} {{if (eq .type "array")}} stopifnot(is.vector({{.}})) {{end}} {{end}}

{{define "stopifnotlogical"}} {{if (eq .type "boolean")}} stopifnot(is.logical({{.}})) {{end}} {{end}}

{{define "stopifrequiredbutnull"}} {{if .required}} stopifnot(!is.null({{.name}})) {{end}} {{end}}


{{define "addParamWithDefaultValue"}}
{{if .default}} name={{.name}} {{end}}
{{end}}



{{ $typeToRType := dict "array" "vector" "integer" "numeric" "string" "character" "boolean" "logical"}}
# {{ $typeToRFunc := dict "array"  "is.vector" "integer" "is.numeric" "string" "is.character" "boolean" "is.logical"}}


{{- range $path, $path_details := .paths }}

{{- range $op, $op_details := $path_details }}



{{$op_details.operationId}} <- function(

{{$first := true}}
{{- range $param,$param_details := $op_details.parameters}}
{{if $first}}
{{$first = false}}
{{else}}
,
{{end}}
{{$param_details.name}}

{{- end}}

) {
{{- range $param,$param_details := $op_details.parameters}}
  {{template "stopifrequiredbutnull" $param_details}}

  {{if (eq $op_details.operationId "get")}}
    {{template "stopifnotlogical" $param_details}}
    {{template "stopifnotvector" $param_details}}
    {{template "stopifnotnumeric" $param_details}}
    {{template "stopifnotcharacter" $param_details}}
  {{- end}}
{{- end}}


resp <- {{upper $op}}(

url = str_c(verta_url,modeldb_base,"{{$path}}"),
add_headers(
.headers= {{if (eq $op "post")}}  headers_char_post {{else}}  headers_char_get {{end}}
),
{{if eq $op "get"}}
query = list(
{{$first := true}}
{{- range $param,$param_details := $op_details.parameters}}
{{if $first}}
  {{$first = false}}
{{else}}
,
{{end}}
{{$param_details.name}} = {{$param_details.name}}
{{end}}
)
{{else if eq $op "post"}}
body=body
{{end}}
, encode="json"
)


return(resp)

}
{{- end }}
{{- end }}
