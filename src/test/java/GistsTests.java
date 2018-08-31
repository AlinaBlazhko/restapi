import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;

public class GistsTests {
    @Test
    public void postQuery() {
        given()
                .auth().oauth2("a5e59c0252842d5457b2680e3077814f3676749f")
                .body("{\n" +
                        "  \"description\": \"Hello World Examples\",\n" +
                        "  \"public\": true,\n" +
                        "  \"files\": {\n" +
                        "    \"hello_world.rb\": {\n" +
                        "      \"content\": \"class HelloWorld\\n   def initialize(name)\\n      @name = name.capitalize\\n   end\\n   def sayHi\\n      puts \\\"Hello !\\\"\\n   end\\nend\\n\\nhello = HelloWorld.new(\\\"World\\\")\\nhello.sayHi\"\n" +
                        "    },\n" +
                        "    \"hello_world.py\": {\n" +
                        "      \"content\": \"class HelloWorld:\\n\\n    def __init__(self, name):\\n        self.name = name.capitalize()\\n       \\n    def sayHi(self):\\n        print \\\"Hello \\\" + self.name + \\\"!\\\"\\n\\nhello = HelloWorld(\\\"world\\\")\\nhello.sayHi()\"\n" +
                        "    },\n" +
                        "    \"hello_world_ruby.txt\": {\n" +
                        "      \"content\": \"Run `ruby hello_world.rb` to print Hello World\"\n" +
                        "    },\n" +
                        "    \"hello_world_python.txt\": {\n" +
                        "      \"content\": \"Run `python hello_world.py` to print Hello World\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "}")
                .post("https://api.github.com/gists")
                .then().assertThat().statusCode(201);
    }

    @Test
    public void putQuery(){
        // Find id for our gist
        JsonPath id = given().auth().oauth2("a5e59c0252842d5457b2680e3077814f3676749f").get("https://api.github.com/gists").getBody().jsonPath();

        given().auth().oauth2("a5e59c0252842d5457b2680e3077814f3676749f")
                .when()
                .put("https://api.github.com/gists/" + id.getList("id").get(0) + "/star")
                .then()
                .assertThat()
                .statusLine("HTTP/1.1 204 No Content");
    }

    @Test
    public void patchQuery() {
        // Find id for our gist
        JsonPath id = given().auth().oauth2("a5e59c0252842d5457b2680e3077814f3676749f").get("https://api.github.com/gists").getBody().jsonPath();

        given()
                .auth().oauth2("a5e59c0252842d5457b2680e3077814f3676749f")
                .body("{\n" +
                        "  \"description\": \"Hello World Examples\",\n" +
                        "  \"files\": {\n" +
                        "    \"hello_world_ruby.txt\": {\n" +
                        "      \"content\": \"Run `ruby hello_world.rb` or `python hello_world.py` to print Hello World\",\n" +
                        "      \"filename\": \"hello_world.md\"\n" +
                        "    },\n" +
                        "    \"hello_world_python.txt\": null,\n" +
                        "    \"new_file.txt\": {\n" +
                        "      \"content\": \"This is a new placeholder file.\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "}")
                .patch("https://api.github.com/gists/" + id.getList("id").get(0))
                .then().assertThat().statusCode(200);
    }

    @Test
    public void deleteQuery() {
        // Find id for our gist
        JsonPath id = given().auth().oauth2("a5e59c0252842d5457b2680e3077814f3676749f").get("https://api.github.com/gists").getBody().jsonPath();

        System.out.println("Session id: " + id.getList("id").get(0));
        given()
                .auth().oauth2("a5e59c0252842d5457b2680e3077814f3676749f")
                .delete("https://api.github.com/gists/" + id.getList("id").get(0))
                .then().assertThat().statusCode(204);
    }

}
