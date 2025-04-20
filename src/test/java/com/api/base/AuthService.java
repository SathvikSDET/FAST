package com.api.base;

import com.utils.ApiException;

import io.restassured.response.Response;

public class AuthService extends BaseService {
	private static final String BASE_PATH = "/api/auth/";

	public Response login(Object payload) throws ApiException {
		Response response = postRequest(BASE_PATH + "login", payload);
		if(response.getStatusCode() != 200) {
			throw new ApiException(ApiException.ExceptionType.INVALID_STATUS_CODE, "Expected 200 but got"+response.getStatusCode());
		}
		return response;
	}

	
	
	public Response signUp(Object payload) throws ApiException {
		Response response = postRequest(BASE_PATH + "signup", payload);
		if(response.getStatusCode() != 200) {
			throw new ApiException(ApiException.ExceptionType.INVALID_STATUS_CODE, "Expected 200 but got"+response.getStatusCode());
		}
		return response;
	}
	
	
	
	public Response resetPassword(Object payload) throws ApiException {
		Response response = sendRequest(HttpMetthod.POST, payload, BASE_PATH+"reset-password");
		if(response.getStatusCode() != 200) {
			throw new ApiException(ApiException.ExceptionType.INVALID_STATUS_CODE, "Expected 200 but got"+response.getStatusCode());
		}
		return response;
		
	}

}
