
package stepdefinations;

import java.util.HashMap;

import org.json.JSONObject;
import org.junit.Assert;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUserUsingScenarioOutlneMethod {
	
	String BaseURL = "https://reqres.in";
	 String BasePath = "/api/users";
	 
	 RequestSpecification request;
	 Response response;
	 
	
	@Given("Post endpoint with body data is available as {string}, {string}")
	public void post_endpoint_with_body_data_is_available_as(String name, String job) 
	{
		
		HashMap map = new HashMap();
		
		map.put("name", name);
		map.put("job", job);
		
		request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body(map);
		
		
	}

	@When("User hits the post endpoint to create data")
	public void user_hits_the_post_endpoint_to_create_data()
	{
		RestAssured.baseURI = BaseURL;
		RestAssured.basePath = BasePath;

	    response = request.post(BaseURL + BasePath);
	    
	    String userdata = response.getBody().asString();
	    
	    System.out.println(userdata);

	}

	@Then("User should get created with proper status code")
	public void user_should_get_created_with_proper_status_code() 
	{
		Assert.assertEquals(201,response.getStatusCode());
	}


}
