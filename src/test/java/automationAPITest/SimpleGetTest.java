package automationAPITest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleGetTest {
    private static final Logger LOGGER= LogManager.getLogger(SimpleGetTest.class);
   // @Test
    public void getAllUsers(){
        //This is for base url or end point from the rest API
        RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
        //RequestSpecification --this part sent request to the server
        // and server specified by the baseUr in the above step and object store in "httpRequest"
        RequestSpecification httpRequest=RestAssured.given();
      //This will return the response from server
        Response response=httpRequest.request(Method.GET);
        //this is just for print the body of response
        LOGGER.debug(response.getBody().asString());//or down line
         //LOGGER.debug(response.getBody().prettyPrint());
        //this is the status of body response of status
        LOGGER.debug("Actual status code : "+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);
        //now validate the jsonPath from response
        JsonPath jsonPath=response.jsonPath();

  //validate the user record is not null
        String record=jsonPath.getString("data[0]");
        Assert.assertNotNull(record,"user record is null");
    }
    //this is for single user
   @Test
    public void getSingleUser(){
       //This is for base url or end point from the rest API
       RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employee";
       //RequestSpecification --this part sent request to the server
       // and server specified by the baseUr in the above step and object store in "httpRequest"
       RequestSpecification httpRequest=RestAssured.given();
       //This will return the response from server
       Response response=httpRequest.request(Method.GET,"/1");
       //this is just for print the body of response
       LOGGER.debug(response.getBody().asString());//or down line
       //LOGGER.debug(response.getBody().prettyPrint());
       //this is the status of body response of status
       LOGGER.debug("Actual status code : "+response.getStatusCode());
       Assert.assertEquals(response.getStatusCode(),200);
       //now validate the jsonPath from response
       JsonPath jsonPath=response.jsonPath();

       //validate the user record is not null
       String record=jsonPath.getString("data.employee_name");
       Assert.assertEquals(record,"Tiger Nixon");

   }
}
