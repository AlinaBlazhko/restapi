import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class GistsTests {
    @Test
    public void checkPutQuery(){
        RestAssured.baseURI = "https://api.github.com/gists/e90edbb214cdd696f350e776eb681f2a?access_token=c196bd3fc948d302c5bca71090d880cdcda8d5cd";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();

        Integer statusCode = response.statusCode();
        System.out.println(statusCode);

        Assert.assertTrue(200 == statusCode);
    }

    @Test
    public void postQuery(){
        RestAssured.baseURI = "https://api.github.com/gists/public";
        RequestSpecification httpRequest = RestAssured.given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"description\": \"Hello World Examples\",\n" +
                        "  \"public\": true,\n" +
                        "  \"files\": {\n" +
                        "    \"hello_world.rb\": {\n" +
                        "      \"content\": \"class HelloWorld\\n   def initialize(name)\\n      @name = name.capitalize\\n   end\\n   def sayHi\\n      puts \\\"Hello !\\\"\\n   end\\nend\\n\\nhello = HelloWorld.new(\\\"World\\\")\\nhello.sayHi\"\n" +
                        "   }}}");

        Response response = httpRequest.
                post();
        System.out.println(response.statusCode());
//        RestAssured.baseURI  = "https://api.github.com/gists/e90edbb214cdd696f350e776eb681f2a?access_token=c196bd3fc948d302c5bca71090d880cdcda8d5cd";
//
//        Response r = given()
//                .contentType("application/json").
//                        body("{\"description\": \"Hello World Examples\",\"public\": true,\"hello_world.py\":{\"content\": \"class HelloWorld:\\n\\n\"}}").
//                        when().
//                        post();
//
//        String body = r.getBody().asString();
//        System.out.println(body);


    }
}
