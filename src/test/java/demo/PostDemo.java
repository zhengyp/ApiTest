package demo;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class PostDemo {
    @Test
    public void jsonBodyTest(){
        RestAssured.baseURI = "http://10.10.10.175";
        RestAssured.basePath = "/api/login/";
        String psd = tools.md5.encrypByMd5Jar("xujiuming");
        String jsonBody = "{\n" +
                "                \"phone\":\"18688886666\",\n" +
                "                \"password\":\"123456\"\n" +
                "            }";
        Response response = given()
                .header("Content-Type","application/json")
//                .param("id","30592034")
                .body(jsonBody)
                .when().log().all().post();
        int responseCode = response.statusCode();
        String responseContent = response.getBody().print();
        System.out.println("响应状态码："+String.valueOf(responseCode));
        System.out.println(responseContent);

    }
}
