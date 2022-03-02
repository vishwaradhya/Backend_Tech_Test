package com.rest.commonutils;

import com.google.gson.Gson;
import com.rest.pojos.listusers.ListUserResponse;
import com.rest.pojos.makecomments.MakeCommentResponse;
import com.rest.pojos.makeposts.MakePostResponse;

public class ParseResponseUtils {

	public MakePostResponse getMakePostResponse(String body) {

		MakePostResponse getResObj = new Gson().fromJson(body, MakePostResponse.class);

		return getResObj;
	}

	public MakeCommentResponse getCommentResponse(String body) {

		MakeCommentResponse getResObj = new Gson().fromJson(body, MakeCommentResponse.class);

		return getResObj;
	}

	public ListUserResponse getListUserResponse(String body) {

		ListUserResponse getResObj = new Gson().fromJson(body, ListUserResponse.class);

		return getResObj;
	}

}
