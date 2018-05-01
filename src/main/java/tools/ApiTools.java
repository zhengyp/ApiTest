package tools;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;

public class ApiTools {
    public static String getAppToken(){
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
        String token = response.getHeader("token");
        return token;

    }
    public static String getWebCookie(){
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
        String cookie = response.getCookie("cookie");
        return cookie;

    }
    public static Response appPost(String url){
        String token = ApiTools.getAppToken();
        String jsonBody = "{\n" +
                "                \"phone\":\"18688886666\",\n" +
                "                \"password\":\"123456\"\n" +
                "            }";
        Response response = given()
                .header("token",token)
                .body(jsonBody)
                .when().log().all().post(url);
        return response;


    }
    public static Response webpost(String url){
        String cookie = ApiTools.getWebCookie();
        String jsonBody = "{\n" +
                "                \"phone\":\"18688886666\",\n" +
                "                \"password\":\"123456\"\n" +
                "            }";
        Response response = given()
                .cookie("cookie",cookie)
                .body(jsonBody)
                .when().log().all().post(url);
        return response;

    }
}
