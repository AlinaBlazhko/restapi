import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class RestTests {
    @BeforeTest
    public void setUp(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void verifyThatStatusCodeAndContentTypeCorrect() {
        get("/users")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .assertThat()
                .contentType("application/json; charset=utf-8");
    }

    @Test
    public void bodyTest(){
        List<String> count = given()
                                .get("/users")
                                .jsonPath()
                                .getList("id");
        System.out.println(count.size());
        Assert.assertTrue(count.size() == 10);
    }
}
