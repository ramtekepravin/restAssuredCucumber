package stepdefinations;


import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Assert;


public class CreateUserUsingJSONFile {

	String BaseURL = "https://reqres.in";
	String BasePath = "/api/users";
	 
	 RequestSpecification request;
	 Response response;
	
	@Given("Post endpoint with body data is available from JSON File")
	public void post_endpoint_with_body_data_is_available_from_json_file() throws FileNotFoundException 
	
	{
		File f = new File("./src/test/resources/TestData/CreateUserData.json");
		
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		
		JSONObject data = new JSONObject(jt);

		request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body(data.toString());
		
	}

	@When("User hits the post endpoint to create user with JSON File")
	public void user_hits_the_post_endpoint_to_create_user_with_json_file() 
	
	{
		RestAssured.baseURI = BaseURL;
		RestAssured.basePath = BasePath;

	    response = request.post(BaseURL + BasePath);
	    
        String userdata = response.getBody().asString();
	    
	    System.out.println(userdata);


	}

	@Then("User should get created as required from JSON File")
	public void user_should_get_created_as_required_from_json_file() 
	
	{
		Assert.assertEquals(201,response.getStatusCode());
	}

}
