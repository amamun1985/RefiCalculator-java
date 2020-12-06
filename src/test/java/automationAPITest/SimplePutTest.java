package automationAPITest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimplePutTest {
    private static final Logger LOGGER= LogManager.getLogger(SimplePutTest.class);
    @Test
    public void updateExistingUsers(){
        String userName="Rifat Hossain";
        String userRoll="Tester Automation";
        String jobs="TeacherQA";
        String email="zzzzzzzzzzzzzzzzz@yahoo.com";

        RestAssured.baseURI="https://reqres.in/api/users";
        RequestSpecification httpRequest=RestAssured.given();

        JSONObject rowJsonBodyObject=new JSONObject();//we need to create obj for json row body
        rowJsonBodyObject.put("name",userName);
        rowJsonBodyObject.put("job",userRoll);
        rowJsonBodyObject.put("Title",jobs);
        rowJsonBodyObject.put("WebEmail",email);
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(rowJsonBodyObject.toJSONString());
        LOGGER.debug("Request body : "+rowJsonBodyObject);

        //This will return the response from server
        Response response=httpRequest.request(Method.PUT,"/3");
        //this is just for print the body of response
        LOGGER.debug(response.getBody().asString());//or down line
        //LOGGER.debug(response.getBody().prettyPrint());
        //this is the status of body response of status
        LOGGER.debug("Actual status code : "+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);


        //now validate the jsonPath from response
        JsonPath jsonPath=response.jsonPath();
        //validate the user record updated
        String record=jsonPath.getString("name");
        Assert.assertEquals(record,userName);
        String record1=jsonPath.getString("Title");
        Assert.assertEquals(record1,jobs);
    }
}
