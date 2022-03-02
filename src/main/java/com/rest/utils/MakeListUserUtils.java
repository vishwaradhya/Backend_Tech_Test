package com.rest.utils;

import com.framework.rest.RestImpl;
import com.jayway.restassured.response.Response;
import com.rest.commonutils.ParseResponseUtils;
import com.rest.commonutils.PropertiesFile;
import com.rest.constants.ConfigurationPath;
import com.rest.constants.EndPoints;

public class MakeListUserUtils extends RestImpl {

	ParseResponseUtils gsonObj = new ParseResponseUtils();
	Response response;

	public Response listUser(String userID) {

		response = getRequest(PropertiesFile.getPropertyValue(ConfigurationPath.CONFIG_PATH, "BASE_URL"),
				EndPoints.USERS + userID);

		return response;
	}

}
