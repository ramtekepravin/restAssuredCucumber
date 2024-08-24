package stepdefinations;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.DataProviderUtility;



public class CreateUserDataUsingExcel {
	
	
	String BaseURL = "https://reqres.in";
	String BasePath = "/api/users";
	 
	 RequestSpecification request;
	 Response response;

	 	 
	 @Test(dataProvider = "getdata" , dataProviderClass = DataProviderUtility.class)
	 @Given("Post endpoint with body data is available from Excel File as {string} , {string}")
	 public void post_endpoint_with_body_data_is_available_from_excel_file_as(String name, String job) {
	     
		 request = RestAssured.given();
			request.header("Content-Type", "application/json");
			request.body();
			
			
			
	 }



	@When("User hits the post endpoint to create user with Excel File")
	public void user_hits_the_post_endpoint_to_create_user_with_excel_file() {
	   
	}

	@Then("User should get created as required from Excel File")
	public void user_should_get_created_as_required_from_excel_file() {
	    
	}



}
