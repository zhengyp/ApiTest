package info;

import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;
import tools.ApiTools;

public class GetHomePageInfo {
    @Test
    public void getAppHomePage(){
        String url = "http://localhost:12306/register";
        Response response =ApiTools.appPost(url);
        response.getBody().print();
    }
    @Test
    public void getWebHomePage(){
        String url = "http://localhost:12306/register";
        Response response =ApiTools.webpost(url);
        response.getBody().print();
    }

}
