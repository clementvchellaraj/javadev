This is an **Zoro Cart** API to demonstrate features of the OpenAPI specification.

# Introduction

This API definition is intended to to be a good starting point for
describing your API in 

[OpenAPI/Swagger
format](https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md).

It also demonstrates features of the
[create-openapi-repo](https://github.com/Redocly/create-openapi-repo) tool
and 

the [Redoc](https://github.com/Redocly/Redoc) documentation engine. Beyond
the standard OpenAPI syntax, we use a few 

[vendor
extensions](https://github.com/Redocly/Redoc/blob/master/docs/redoc-vendor-extensions.md).


# OpenAPI Specification

The goal of The OpenAPI Specification is to define a standard,
language-agnostic interface to REST APIs which

allows both humans and computers to discover and understand the capabilities
of the service without access to source

code, documentation, or through network traffic inspection. When properly
defined via OpenAPI, a consumer can 

understand and interact with the remote service with a minimal amount of
implementation logic. Similar to what

interfaces have done for lower-level programming, OpenAPI removes the
guesswork in calling the service.

# Authentication

This topic describes the different forms of authentication that are available in the Zoro API, and how to use them.

Zoro offers 2 forms of authentication based on authenticated vs public (or guest) access: API key, JSON Web Tokens and public signature key.

- API key: Use to make requests from the server side. Never share these keys. Keep them guarded and secure.
- JWT: Use to make short-life tokens that expire after a set period of time and associated with user authenticated against Zoro Okta.

## Manage API keys

To create or manage API keys, follow the steps below:

- Use the APIgee Developer portal: go to [Apigee Developer Portal](https://zoro-apiportal.apigee.io/)
- Follow instructions in **Getting Started** page to register for access
- Follow steps to create **App** to API and request **API Key**

# Errors

We follow the error response format proposed in [RFC 7807](https://tools.ietf.org/html/rfc7807)
also known as Problem Details for HTTP APIs. As with our normal API responses,
your client must be prepared to gracefully handle additional members of the response.

- Stardard HTTP errors need to be handled
- APIs have specific errors based on certain business condition validation

## CartNotFound
<RedocResponse pointer={"#/components/schemas/Cart-Not-Found-Error"} />

# SDKs

Zoro offers a Javascript SDK and a Python SDK to help interact with
the API.  However, no SDK is required to use the API.


## Node SDK
```node.js
const fetch = require('node-fetch');

let url = 'https://api-dev.zoro.com/v1/cart';

let options = {
  method: 'POST',
  headers: {'Content-Type': 'application/json', Authorization: 'Bearer undefined'},
  body: '{"items":[{"qty":1,"zoroNo":"G1739841"},{"qty":2,"zoroNo":"G0014777"},{"qty":3,"zoroNo":"H9999999"}]}'
};

fetch(url, options)
  .then(res => res.json())
  .then(json => console.log(json))
  .catch(err => console.error('error:' + err));
```

## Python SDK
For all Python SDK examples provided in these docs you need to configure the `$apikey`.
You may do it like this:

```python
import http.client

conn = http.client.HTTPSConnection("api-dev.zoro.com")
apikey = 'my key'
payload = "{\n  \"items\": [\n    {\n      \"qty\": 1,\n      \"zoroNo\": \"G1739841\"\n    },\n    {\n      \"qty\": 2,\n      \"zoroNo\": \"G0014777\"\n    },\n    {\n      \"qty\": 3,\n      \"zoroNo\": \"H9999999\"\n    }\n  ]\n}"
headers = {
    'Content-Type': "application/json",
    'Authorization': "Bearer undefined"
    }
conn.request("POST", "/v1/cart", payload, headers)
res = conn.getresponse()
data = res.read()
print(data.decode("utf-8"))
```

# Getting started guide

This API collection has over 30 API.
That's more than you need to implement your use cases.
If you have a use case you would like to implement,
please consult us for feedback on the best API operations for the task.

Our [getting started guides](https://zoro-apiportal.apigee.io/get-started) demonstrates API use cases.
It allows us to highlight core resources in Zoro that are helpful for many other use cases too.