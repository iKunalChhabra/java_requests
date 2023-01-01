# Java Requests

A simple python httpRequests like library for Java.

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
[See other examples](src/main/java/com/kunalchhabra/examples/)

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
- **Authentication:**
  - Basic
  - Bearer
  - Custom

## Author
Kunal Chhabra

## Contributing
Pull httpRequests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## Contact
Feel free to reach out to me over email mentioned in my GitHub profile.