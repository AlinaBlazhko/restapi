import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class GistsTests {
    @Test
    public void checkPutQuery(){
        RestAssured.baseURI = "https://api.github.com/gists/e90edbb214cdd696f350e776eb681f2a?access_token=23e549cba9296ca8d7a4e0833a59b6ea8f06fc86";
//        RestAssured.baseURI = "https://api.github.com/gists/23e549cba9296ca8d7a4e0833a59b6ea8f06fc86";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();

        Integer statusCode = response.statusCode();
        System.out.println(statusCode);

        Assert.assertTrue(200 == statusCode);
//        String contentType = response.header();
//        System.out.println("Content-Type value: " + contentType);
//        get("https://api.github.com/gists/0f52a9cc5eb1c1065f9c31d942da6826c9ec295e").getHeaders();


    }

    @Test
    public void checkDeleteQuery(){
//        HttpHeaders requestHeaders = new HttpHeaders();
//        HttpEntity<Gist> entity = new HttpEntity<Gist>(requestHeaders);
//
//        ResponseEntity<Gist>  response = restTempl.exchange("https://api.github.com/gists/9f5d3732772148fe3260e7794513f590", HttpMethod.DELETE, new HttpEntity<Gist>(requestHeaders), Gist.class);
//        Assert.assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
    }


    @Test
    public void checkPatchQuery(){
//        restTempl.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
//        File file = new File("Yaaaaay!");
//        Map<String, File> files = new HashMap<String, File>();
//        files.put("file3.txt", file);
//        Gist gist = new Gist("yay!", true, files);
//
//        HttpEntity<Gist> entity = new HttpEntity<Gist>(gist);
//        ResponseEntity<Gist>  response = restTempl.exchange("https://api.github.com/gists/9f5d3732772148fe3260e7794513f590", HttpMethod.PATCH, new HttpEntity<Gist>(gist), Gist.class);
//        Assert.assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
    }

    @Test
    public void test() throws Exception{
//        org.eclipse.egit.github.core.Gist gist = new org.eclipse.egit.github.core.Gist();
//        GistService service = new GistService();
//        service.starGist("4946619");
    }
}
