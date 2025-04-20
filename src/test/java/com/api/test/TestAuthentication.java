package com.api.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.model.request.LoginRequest;
import com.api.model.request.ResetPasswordRequest;
import com.api.model.request.SignUpRequest;
import com.api.model.response.LoginResponse;
import com.utils.ApiException;

import io.restassured.response.Response;

public class TestAuthentication {
	
	
	@Test(enabled = false)
	public void testSuccesLogin() throws ApiException {
		LoginRequest request = new LoginRequest("uday123", "uday123");

		AuthService authServices = new AuthService();
		Response response =  authServices.login(request);
		System.out.println(response.asPrettyString());
		
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getUsername());
		
	}
	
	
	@Test
	public void testSuccessSignUp(ITestContext context) throws ApiException {
		SignUpRequest request = new SignUpRequest.Builder()
			    .username("sathviks")
			    .password("pass123")
			    .email("satssh@example.com")
			    .firstName("Sathas")
			    .lastName("Vikas")
			    .mobileNumber("9876543250")
			    .build();
		
		AuthService authServices = new AuthService();
		Response  response = authServices.signUp(request);
		System.out.println(response.asPrettyString());
		
		
		LoginRequest loginRequest = new LoginRequest("uday123", "uday123");

	
		response =  authServices.login(loginRequest );
		System.out.println(response.asPrettyString());
		
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getUsername());
		System.out.println(loginResponse.getToken());
		context.setAttribute("Token", loginResponse.getToken());
		
		
	}
	
	
	@Test(dependsOnMethods = "testSuccessSignUp")
	public void resetPassword(ITestContext context) throws ApiException {
		String token = context.getAttribute("Token").toString();

		ResetPasswordRequest request = new ResetPasswordRequest();
		request.setToken(token); // Use the token from login
		request.setNewPassword("newPass@123");
		request.setConfirmPassword("newPass@123");
		AuthService authService = new AuthService();
		Response response = authService.resetPassword(request);

		System.out.println(response.asPrettyString());
	}

}
