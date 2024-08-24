package stepdefinations;

import io.cucumber.java.en.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.PojoClassForData;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;


public class CreateUserUsingPojoclassData {
	
	
	String BaseURL = "https://reqres.in";
	String BasePath = "/api/users";
	 
	 RequestSpecification request;
	 Response response;
	 
	 PojoClassForData data = new PojoClassForData();
	 
	
	@Given("Post endpoint with body data is available from pojo class")
	public void post_endpoint_with_body_data_is_available_from_pojo_class() {
	    
		// Generating data using POJO class methods 
		 data.setName("Kumar");
		 data.setJob("Admin");
		
		request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body(data);
		
	    
	}

	@When("User hits the post endpoint to create user")
	public void user_hits_the_post_endpoint_to_create_user() {
		
		RestAssured.baseURI = BaseURL;
		RestAssured.basePath = BasePath;

	    response = request.post(BaseURL + BasePath);
	    
       String userdata = response.getBody().asString();
	    
	    System.out.println(userdata);

    
	}

	@Then("User should get created as required")
	public void user_should_get_created_as_required() {
		
		Assert.assertEquals(201,response.getStatusCode());
	    
	}



}
