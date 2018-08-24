import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class RestTests {
    @BeforeTest
    public void setUp(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
    }

        @Test
    public void firstTest() {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();

        Integer statusCode = response.statusCode();
        System.out.println(statusCode);

        Assert.assertTrue(200 == statusCode);
    }

    @Test
    public void secondTest() {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();

        String contentType = response.header("Content-Type");
        System.out.println("Content-Type value: " + contentType);
        Assert.assertEquals(contentType, "application/json; charset=utf-8");
    }

    @Test
    public void bodyTest(){
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();

        List<String> jsonResponse = response.jsonPath().getList("id");
        System.out.println(jsonResponse.size());
    }
}
