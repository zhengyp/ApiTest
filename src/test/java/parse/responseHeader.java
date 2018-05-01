package parse;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class responseHeader {
    @Test
    public void responseHeaderTest(){
        RestAssured.baseURI = "http://localhost:12306";
        RestAssured.basePath = "/register";
        String jsonBodyValue = "{\n" +
                "                \"phone\":\"18688886666\",\n" +
                "                \"password\":\"123456\"\n" +
                "            }";
        Response response = given()
                .header("Content-Type","application/json")
                .body(jsonBodyValue)
                .when().log().all().post();
        int responseCode = response.statusCode();
        System.out.println("响应状态码："+String.valueOf(responseCode));
        String responseHeader = response.getHeader("token");
        System.out.println("响应头域token："+responseHeader);


    }
}
