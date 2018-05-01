package apis;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class body {
    @Parameters({"phone","password"})
    @Test
    public void jsonBodyTest(String phone,String password){
        RestAssured.baseURI = "http://localhost:12306";
        RestAssured.basePath = "/register";
        String jsonBody = "{\n" +
                "                \"phone\":\""+phone+"\",\n" +
                "                \"password\":\""+password+"\"\n" +
                "            }";
        Response response = given()
//                .header("Content-Type","text/html:charset-utf-8")
//                .param("id","30592034")
                .body(jsonBody)
                .when().log().all().post();
        int responseCode = response.statusCode();
        String responseContent = response.getBody().print();
        System.out.println("响应状态码："+String.valueOf(responseCode));
        System.out.println(responseContent);

    }
}
