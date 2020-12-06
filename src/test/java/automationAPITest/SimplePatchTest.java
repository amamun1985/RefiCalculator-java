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

public class SimplePatchTest {
    private static final Logger LOGGER= LogManager.getLogger(SimplePatchTest.class);
    @Test
    public void updateExistingUsersWithPatch(){

        String userRoll="manager";

        RestAssured.baseURI="https://reqres.in/api/users";
        RequestSpecification httpRequest=RestAssured.given();

        JSONObject rowJsonBodyObject=new JSONObject();//we need to create obj for json row body

        rowJsonBodyObject.put("job",userRoll);
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(rowJsonBodyObject.toJSONString());
        LOGGER.debug("Request body : "+rowJsonBodyObject);

        //This will return the response from server
        Response response=httpRequest.request(Method.PATCH,"/2");
        //this is just for print the body of response
        LOGGER.debug(response.getBody().asString());//or down line
        //LOGGER.debug(response.getBody().prettyPrint());
        //this is the status of body response of status
        LOGGER.debug("Actual status code : "+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);


        //now validate the jsonPath from response
        JsonPath jsonPath=response.jsonPath();
        //validate the user record updated
        String record=jsonPath.getString("job");
        Assert.assertEquals(record,userRoll);
    }
}
