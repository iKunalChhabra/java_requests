# Java Requests

A simple python requests like library for Java.

## Usage

```java
package com.kunalchhabra.examples;

import com.kunalchhabra.requests.Header;
import com.kunalchhabra.requests.Param;
import com.kunalchhabra.requests.Requests;
import com.kunalchhabra.requests.Response;
import org.json.JSONObject;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        // api endpoint
        String url = "https://jsonplaceholder.typicode.com/users/1";

        // create a new request and get the response
        Response response = Requests.get(url);

        // print the response
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response);

        // get deep nested values in Json
        JSONObject geo = response.toJsonObject().getJSONObject("address").getJSONObject("geo");
        double lat = geo.getDouble("lat");
        double lng = geo.getDouble("lng");
        System.out.println("(Lat, Lng): (" + lat + ", " + lng + ")");
    }
}


```
### Output
```bash
Status Code: 200

Response: {
  "id": 1,
  "name": "Leanne Graham",
  "username": "Bret",
  "email": "Sincere@april.biz",
  "address": {
    "street": "Kulas Light",
    "suite": "Apt. 556",
    "city": "Gwenborough",
    "zipcode": "92998-3874",
    "geo": {
      "lat": "-37.3159",
      "lng": "81.1496"
    }
  },
  "phone": "1-770-736-8031 x56442",
  "website": "hildegard.org",
  "company": {
    "name": "Romaguera-Crona",
    "catchPhrase": "Multi-layered client-server neural-net",
    "bs": "harness real-time e-markets"
  }
}

(Lat, Lng): (-37.3159, 81.1496)
```
[See other examples](src/main/java/com/kunalchhabra/examples/)

## Notes
- This is work in progress. I will be adding more features as I go.
- Protocol supported : HTTP
- Methods supported : GET, POST, PUT, PATCH, DELETE
- Response format supported : JSON, TEXT, BYTE, BASE64, FILE, HASH
- POST and PUT data format supported : BYTE
- Authentication is not supported yet.
- Logging, Testing and Documentation are yet to be added.

## Author
Kunal Chhabra

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## Contact
Feel free to reach out to me over email mentioned in my GitHub profile.