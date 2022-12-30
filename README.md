# Java Requests

A simple python requests like library for Java.

## Usage

```java
import com.kunalchhabra.requests.Requests;

import java.io.IOException;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws IOException {
        // api endpoint
        String url = "http://127.0.0.1:5000/users";

        // request headers
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");

        // request params
        HashMap<String, String> params = new HashMap<>();
        params.put("name", "Jane Doe");

        // create a new Requests object
        Requests request = new Requests();
        Response response = request.get(url, headers, params);

        // print the response
        System.out.println("Response: " + response);
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("User Id: " + response.toJsonObject().getInt("id"));
    }
}

```
### Output
```bash
>> Response: {"id":2,"name":"Jane Doe"}
>> Status Code: 200
>> User Id: 2
```
## Notes
- This is work in progress. I will be adding more features as I go.
- Only HTTP protocol and GET method is supported as of now.

## Author
Kunal Chhabra

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## Contact
Feel free to reach out to me over email mentioned in my GitHub profile.