package com.rest.stepdefinitions;

import com.jayway.restassured.response.Response;
import com.rest.commonutils.ParseResponseUtils;
import com.rest.pojos.makeposts.MakePostResponse;
import com.rest.utils.MakePostsUtils;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.junit.Assert.assertTrue;

import java.util.Map;

public class MakePostsStepDefinitions {

	private static int statusCode;
	MakePostsUtils makePostsObj = new MakePostsUtils();
	private static Response response;

	ParseResponseUtils parseResponse = new ParseResponseUtils();
	MakePostResponse responseOutput;

	@Given("^user makes posts with following details to server$")
	public void makePosts(DataTable dataTable) {

		response = makePostsObj.createPosts(dataTable);
		statusCode = response.statusCode();
		responseOutput = parseResponse.getMakePostResponse(response.asString());
	}

	@Given("^social network server is up and running$")
	public void healthCheck() throws Throwable {
		statusCode = makePostsObj.healthCheck();

		assertTrue("Health check failed ", statusCode == 200);
	}

	@Then("^user verifes the following details from the response for sucessfull post in the server$")
	public void verifyDetails(DataTable dataTable) {

		for (final Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
			assertTrue("title mismatch expected " + row.get("title") + " actual " + responseOutput.getUserId(),
					row.get("title").equals((responseOutput.getTitle())));
			assertTrue("body mismatch expected " + row.get("body") + " actual " + responseOutput.getBody(),
					row.get("body").equals((responseOutput.getBody())));
			assertTrue("userid mismatch expected " + row.get("userId") + " actual " + responseOutput.getUserId(),
					row.get("userId").equals(Integer.toString((responseOutput.getUserId()))));
			assertTrue("id mismatch expected " + row.get("id") + " actual " + responseOutput.getUserId(),
					row.get("id").equals(Integer.toString((responseOutput.getId()))));
		}

	}

	@Given("^user verifies the status code for make post as (\\d+)$")
	public void verifyStatusCode(int code) {
		assertTrue("Status code mismatch Expected " + code + " Actual is " + statusCode, statusCode == code);

	}

	@Given("^user calls for PUT method instead of POST for posting comments  with following data$")
	public void invalidMethod(DataTable dataTable) throws Throwable {

		response = makePostsObj.invalidMethod(dataTable);
		statusCode = response.statusCode();
	}

}