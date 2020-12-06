package automationAPITest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleDeleteTest {
    private static final Logger LOGGER= LogManager.getLogger(SimpleDeleteTest.class);
    @Test
    public void getSingleUser(){
        //This is for base url or end point from the rest API
        RestAssured.baseURI="https://reqres.in/api/users";
        //RequestSpecification --this part sent request to the server
        // and server specified by the baseUr in the above step and object store in "httpRequest"
        RequestSpecification httpRequest=RestAssured.given();
        //This will return the response from server
        Response response=httpRequest.request(Method.DELETE,"/2");
        //this is just for print the body of response
        LOGGER.debug(response.getBody().asString());//or down line
        //LOGGER.debug(response.getBody().prettyPrint());
        //this is the status of body response of status
        LOGGER.debug("Actual status code : "+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),204);


    }
}
