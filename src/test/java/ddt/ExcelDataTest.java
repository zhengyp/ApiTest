package ddt;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class ExcelDataTest {

        @DataProvider(name = "test2")
        public Object[][] excelData() {
            String filePath = "C:/test/test.xls";
            String sheetName = "sheet1";
            Object test [][] = ExcelUtils.getTableArray(filePath,sheetName);
            return test;
        }
        @Test(dataProvider = "test2")
        public void jsonBodyExcelDataTest(String uri,String requestBody,String headKey,String headValue,String cookieKey,String cookieValue){
            RestAssured.baseURI = "http://localhost:12306";
            RestAssured.basePath = uri;
            String jsonBody = requestBody;
            Response response = given()
                .header(headKey,headValue)
                .cookie(cookieKey,cookieValue)
                .body(jsonBody)
                .when().log().all().post();
            int responseCode = response.statusCode();
            String responseContent = response.getBody().print();
            System.out.println("响应状态码："+String.valueOf(responseCode));
            System.out.println(responseContent);

        }
    }

