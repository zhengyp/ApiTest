package demo;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;

public class PostDemo {
    public void Get(){
        RestAssured.baseURI = "http://music.163.com";
        RestAssured.basePath = "/playlist";
        Response response = given()
                .header("Content-Type","text/html:charset-utf-8")
                .param("id","30592034")
                .when().log().all().get();
        int responseCode = response.statusCode();
        String responseContent = response.getBody().print();
        System.out.println("响应状态码："+String.valueOf(responseCode));
        System.out.println(responseContent);



    }
    public static void main(String args[]){
        PostDemo getDemo = new PostDemo();
        getDemo.Get();
    }
}
