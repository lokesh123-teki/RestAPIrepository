package stepDefinitionfiles;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojoclasses.LocationSubClass;
import pojoclasses.MainPayLoad;
import static org.junit.Assert.*;


import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import Payloadpack.Payloaddata;
import Utilspack.Enumclass;
import Utilspack.Utils;

@RunWith(Cucumber.class)
public class addPlaceapistepdef extends Utils{
	static RequestSpecification request;
	ResponseSpecification responsevalue;
	Response rout;
	static String place_id_value;
	static Payloaddata p;
	@Given("^Add place payload \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void add_place_payload_(String name, int accuracy, String phonenumber) throws Throwable {
		responsevalue= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		p= new Payloaddata();
		
		request= given().spec(utilsdata())
		.body(p.addplacepay(name, accuracy, phonenumber));
		Response response= request.when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).extract().response();
		place_id_value= getPlaceapi(response, "place_id");
	}
    @When("^User calls \"([^\"]*)\" with \"([^\"]*)\" http request$")
    public void user_calls_something_with_something_http_request(String strArg1, String strArg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
    	Enumclass resources= Enumclass.valueOf(strArg1);
    	if(strArg2.equalsIgnoreCase("POST"))
		rout= request.when().post(resources.getResource());
    	else if(strArg2.equalsIgnoreCase("GET"))
    	rout= request.when().get(resources.getResource());	
		 
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions 
		Integer.toString(rout.getStatusCode());

	}
    @Then("^Verify \"([^\"]*)\" using \"([^\"]*)\"$")
    public void verify_something_using_something(String actualname, String apitype) throws Throwable {
    	
    	request= given().spec(utilsdata()).queryParam("place_id", place_id_value);
    	user_calls_something_with_something_http_request("GetplaceAPI", "GET");
    	String expectedname= getPlaceapi(rout,"name");
    	System.out.println(actualname);
    	System.out.println(expectedname);
    	assertEquals(actualname, expectedname);	 	
    }
    @Given("^API deletion$")
    public void api_deletion() throws Throwable {
    	request= given().spec(request).body(p.deleteapipayload(place_id_value));
    }
}

