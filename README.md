# Java Requests

A simple python requests like library for Java.

- [Download java_requests-1.0.0.jar](https://github.com/iKunalChhabra/java_requests/releases/download/1.0.0/java_requests-1.0.0.jar)

- [Go to latest release](https://github.com/iKunalChhabra/java_requests/releases/tag/1.0.0)

- [Go to code examples](https://github.com/iKunalChhabra/java_requests/tree/main/src/main/java/com/kunalchhabra/examples)


## Usage

```java
package com.kunalchhabra.examples;

import com.kunalchhabra.requests.https.HttpsRequests;
import com.kunalchhabra.requests.response.Response;

import java.io.IOException;

class Example {
  public static void main(String[] args) throws IOException {

    // create a new request and get the response
    HttpsRequests requests = new HttpsRequests();
    Response response = requests.get("https://jsonplaceholder.typicode.com/users");

    // print the response status code
    System.out.println("Status Code: " + response.getStatusCode());

    // parse and print the response
    double lat = response.toJson().get("[0]->address->geo->lat").toDouble();
    System.out.println("latitude: " + lat);
  }
}

```
### Output
```bash
>> Status Code: 200
>> latitude: -37.3159
```

## Project Status
### Available Functionality
- **Protocols:**
  - HTTP
  - HTTPS
- **Methods:**
  - GET
  - POST
  - PUT
  - PATCH
  - DELETE
- **Response formats:**
  - JSON
  - TEXT
  - BYTE
  - BASE64
  - FILE
  - HASH
    - MD5
    - SHA1
    - SHA256
    - SHA512
- **POST, PUT, PATCH data formats:**
  - BYTE
  - STRING
  - JSON
  - FILE
  - BASE64
  - JAVA HashMap
- **Authentication:**
  - Basic
  - Bearer
  - Custom

## Author
[Kunal Chhabra](https://github.com/iKunalChhabra/)

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## Contact
Feel free to reach out to me over email mentioned in my GitHub profile.