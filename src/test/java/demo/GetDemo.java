package demo;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;

public class GetDemo {
    public void Get(){
        RestAssured.baseURI = "http://10.10.10.175";
        RestAssured.basePath = "//api/user/authorization/page-meta/userInfo";
        Response response = given()
                .header("Content-Type","application/json")
//                .param("id","30592034")
                .when().log().all().get();
        int responseCode = response.statusCode();
        String responseContent = response.getBody().print();
        System.out.println("响应状态码："+String.valueOf(responseCode));
        System.out.println(responseContent);



    }
    public static void main(String args[]){
        GetDemo getDemo = new GetDemo();
        getDemo.Get();
    }
}
