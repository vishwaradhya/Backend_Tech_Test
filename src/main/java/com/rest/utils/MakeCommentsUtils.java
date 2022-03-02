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
import com.rest.pojos.makecomments.MakeCommentRequest;
import cucumber.api.DataTable;

public class MakeCommentsUtils extends RestImpl {

	private static Logger logger = LogManager.getLogger(MakeCommentsUtils.class);
	ParseResponseUtils gsonObj = new ParseResponseUtils();
	Response response;
	
	public Response makeComment(DataTable dataTable) {
		
		
		for (final Map<String, String> row : dataTable.asMaps(String.class, String.class)) {

			MakeCommentRequest makePost = new MakeCommentRequest();
			makePost.setId(Integer.parseInt(row.get("id")));
			makePost.setPostId(Integer.parseInt(row.get("postId")));
			makePost.setName(row.get("name"));
			makePost.setEmail(row.get("email"));
			makePost.setBody(row.get("body"));			
			response = postRequest(PropertiesFile.getPropertyValue(ConfigurationPath.CONFIG_PATH, "BASE_URL"), EndPoints.POSTS, makePost);

		}
		logger.info("Make Comment Status Code is : " + response.getStatusCode());
		logger.info("Make Comment Response is :  " + response.asString());
		return response;

	}

}
