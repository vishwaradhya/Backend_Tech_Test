package com.rest.utils;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.framework.rest.RestImpl;
import com.jayway.restassured.response.Response;
import com.rest.commonutils.ParseResponseUtils;
import com.rest.commonutils.PropertiesFile;
import com.rest.constants.ConfigurationPath;
import com.rest.constants.EndPoints;
import com.rest.pojos.makeposts.MakePostRequest;
import cucumber.api.DataTable;

public class MakePostsUtils extends RestImpl {

	private static Logger logger = LogManager.getLogger(MakePostsUtils.class);
	ParseResponseUtils gsonObj = new ParseResponseUtils();
	Response response;

	public Response createPosts(DataTable dataTable) {

		for (final Map<String, String> row : dataTable.asMaps(String.class, String.class)) {

			MakePostRequest makePost = new MakePostRequest();
			makePost.setId(Integer.parseInt(row.get("id")));
			makePost.setUserId(Integer.parseInt(row.get("userId")));
			makePost.setTitle(row.get("title"));
			makePost.setBody(row.get("body"));
			response = postRequest(PropertiesFile.getPropertyValue(ConfigurationPath.CONFIG_PATH, "BASE_URL"),
					EndPoints.POSTS, makePost);

		}
		logger.info("Create WorkFlow Status Code is : " + response.getStatusCode());
		logger.info("Create WorkFlow Response is :  " + response.asString());
		return response;

	}

	public int healthCheck() {

		response = getRequest(PropertiesFile.getPropertyValue(ConfigurationPath.CONFIG_PATH, "BASE_URL"),
				EndPoints.EMPTY);
		return response.getStatusCode();
	}

	public Response invalidMethod(DataTable dataTable) {
		for (final Map<String, String> row : dataTable.asMaps(String.class, String.class)) {

			MakePostRequest makePost = new MakePostRequest();
			makePost.setId(Integer.parseInt(row.get("id")));
			makePost.setUserId(Integer.parseInt(row.get("userId")));
			makePost.setTitle(row.get("title"));
			makePost.setBody(row.get("body"));
			response = putRequest(PropertiesFile.getPropertyValue(ConfigurationPath.CONFIG_PATH, "BASE_URL"),
					EndPoints.POSTS, makePost);

		}
		logger.info("Create WorkFlow Status Code is : " + response.getStatusCode());
		logger.info("Create WorkFlow Response is :  " + response.asString());
		return response;
	}

}
