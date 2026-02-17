import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BasicPost {

    @Test
    public void createPost() {

        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .header("Content-Type", "application/json")
                .body("""
                {
                  "title": "foo",
                  "body": "bar",
                  "userId": 1
                }
            """)
                .when().log().all()
                .post("/posts")
                .then()
                .statusCode(201).log().all()
                .body("title", equalTo("foo"));
    }
}



