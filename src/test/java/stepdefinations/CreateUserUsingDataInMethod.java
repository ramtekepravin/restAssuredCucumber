package stepdefinations;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;

import com.github.javafaker.Faker;


public class CreateUserUsingDataInMethod {
	
	 String BaseURL = "https://reqres.in";
	 String BasePath = "/api/users";
	 
	 RequestSpecification request;
	 Response response;
	 
	
	
	@Given("Post endpoint with body data is available")
	public void post_endpoint_with_body_data_is_available() 
	{
		
		// Generating data using JSONObject class
		JSONObject data = new JSONObject();
		data.put("name","Prakash");
		data.put("job","Developer");
		
		
		// Generating data using Faker class
	/*	Faker data1 = new Faker();
		String name = data1.name().firstName();
		String job = data1.job().title(); */
		
;
		
		request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body(data.toString());
		
	    
	}

	@When("User hits the post endpoint")
	public void user_hits_the_post_endpoint() 
	{
		RestAssured.baseURI = BaseURL;
		RestAssured.basePath = BasePath;

	    response = request.post(BaseURL + BasePath);
	    
        String userdata = response.getBody().asString();
	    
	    System.out.println(userdata);

	   
	}

	@Then("User should get created")
	public void user_should_get_created() 
	{ 
		Assert.assertEquals(201,response.getStatusCode());
		
			
	}
}
