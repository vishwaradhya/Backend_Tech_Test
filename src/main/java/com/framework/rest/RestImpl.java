package com.framework.rest;

import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

/**
 * @author Vishwaradhya Hiremath
 *
 */

public class RestImpl {

	Response response;

	/**
	 * This method is used to send POST HTTP request
	 * 
	 * @param url         - Base URI
	 * @param path        - Get Request Path
	 * @param contentType - Content Type for the request
	 * @return - Returns the httpResponse for the POST request
	 */
	public Response postRequest(String url, String path, Object makePost) {

		RestAssured.baseURI = url + path;
		response = given().contentType(ContentType.JSON).body(makePost).when().post().then().extract().response();

		return this.response;
	}

	/**
	 * This method is used to send PUT HTTP request
	 * 
	 * @param url         - Base URI
	 * @param path        - Get Request Path
	 * @param contentType - Content Type for the request
	 * @return - Returns the httpResponse for the PUT request
	 */
	public Response putRequest(String url, String path, Object makePost) {

		RestAssured.baseURI = url + path;
		response = given().contentType(ContentType.JSON).body(makePost).when().put().then().extract().response();

		return this.response;
	}
	
	/**
	 * This method is used to Send HTTP GET request
	 * 
	 * @param url  - Base URI
	 * @param path - Get Request Path
	 * @return - Returns the httpResponse for the get request
	 */
	public Response getRequest(String url, String path) {

		response = given().log().all().get(url + path).then().extract().response();

		return this.response;
	}

}
