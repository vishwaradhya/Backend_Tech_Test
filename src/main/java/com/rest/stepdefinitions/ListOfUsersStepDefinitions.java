package com.rest.stepdefinitions;

import com.jayway.restassured.response.Response;
import com.rest.commonutils.ParseResponseUtils;
import com.rest.pojos.listusers.ListUserResponse;
import com.rest.utils.MakeListUserUtils;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ListOfUsersStepDefinitions {

	private static Logger logger = LogManager.getLogger(ListOfUsersStepDefinitions.class);
	private static Response response;
	MakeListUserUtils makeListUserObj = new MakeListUserUtils();
	ListUserResponse responseOutput;
	ParseResponseUtils parseResponse = new ParseResponseUtils();
	private static int statusCode;

	@Given("^user list users for user id \"([^\"]*)\"$")
	public void listUserDetails(String userID) {

		response = makeListUserObj.listUser(userID);
		logger.info("response > " + response.statusCode());
		logger.info("response > " + response.asString());

		responseOutput = parseResponse.getListUserResponse(response.asString());
	}

	@Then("^user verifes the following details for user id \"([^\"]*)\"$")
	public void verifyUser(String userID, DataTable dataTable) {

		for (final Map<String, String> row : dataTable.asMaps(String.class, String.class)) {

			assertTrue("name mismatch expected " + row.get("name") + " actual " + responseOutput.getName(),
					row.get("name").equals((responseOutput.getName())));

			assertTrue("username mismatch expected " + row.get("username") + " actual " + responseOutput.getUsername(),
					row.get("username").equals((responseOutput.getUsername())));

			assertTrue("email mismatch expected " + row.get("email") + " actual " + responseOutput.getEmail(),
					row.get("email").equals((responseOutput.getEmail())));

			assertTrue(
					"address-street mismatch expected " + row.get("address-street") + " actual "
							+ responseOutput.getAddress().getStreet(),
					row.get("address-street").equals((responseOutput.getAddress().getStreet())));

			assertTrue(
					"address-suite mismatch expected " + row.get("address-suite") + " actual "
							+ responseOutput.getAddress().getSuite(),
					row.get("address-suite").equals((responseOutput.getAddress().getSuite())));

			assertTrue(
					"address-city mismatch expected " + row.get("address-city") + " actual "
							+ responseOutput.getAddress().getCity(),
					row.get("address-city").equals((responseOutput.getAddress().getCity())));

			assertTrue(
					"address-zipcode mismatch expected " + row.get("address-zipcode") + " actual "
							+ responseOutput.getAddress().getZipcode(),
					row.get("address-zipcode").equals((responseOutput.getAddress().getZipcode())));

			assertTrue(
					"address-geo-lat mismatch expected " + row.get("address-geo-lat") + " actual "
							+ responseOutput.getAddress().getGeo().getLat(),
					row.get("address-geo-lat").equals((responseOutput.getAddress().getGeo().getLat())));

			assertTrue(
					"address-geo-lng mismatch expected " + row.get("address-geo-lng") + " actual "
							+ responseOutput.getAddress().getGeo().getLat(),
					row.get("address-geo-lng").equals((responseOutput.getAddress().getGeo().getLng())));

			assertTrue("phone mismatch expected " + row.get("phone") + " actual " + responseOutput.getPhone(),
					row.get("phone").equals((responseOutput.getPhone())));

			assertTrue("website mismatch expected " + row.get("website") + " actual " + responseOutput.getWebsite(),
					row.get("website").equals((responseOutput.getWebsite())));

			assertTrue(
					"company-name mismatch expected " + row.get("company-name") + " actual "
							+ responseOutput.getCompany().getName(),
					row.get("company-name").equals((responseOutput.getCompany().getName())));

			assertTrue(
					"company-catchPhrase mismatch expected " + row.get("company-catchPhrase") + " actual "
							+ responseOutput.getCompany().getCatchPhrase(),
					row.get("company-catchPhrase").equals((responseOutput.getCompany().getCatchPhrase())));

			assertTrue(
					"company-bs mismatch expected " + row.get("company-bs") + " actual "
							+ responseOutput.getCompany().getBs(),
					row.get("company-bs").equals((responseOutput.getCompany().getBs())));

		}

	}

	@Given("^user get list user with user id \"([^\"]*)\" which is not exists$")
	public void userNotExists(String userID) {

		response = makeListUserObj.listUser(userID);
		logger.info("response > " + response.statusCode());
		logger.info("response > " + response.asString());
		
		statusCode =response.getStatusCode(); 

	}
	
	@Then("^user verifies the status code for list user as (\\d+)$")
	public void verifyStatusCodeListUser(int code){
		assertTrue("Status code mismatch Expected " + code + " Actual is " + statusCode, statusCode == code);

	}
}