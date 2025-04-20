package com.api.filter;

import com.utils.LogManagerHelper;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter {

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		logRequest(requestSpec);
		Response response = ctx.next(requestSpec, responseSpec);
		logResponse(response);
		return response;
	}

	private void logRequest(FilterableRequestSpecification requestSpec) {
		LogManagerHelper.info("Request: " + requestSpec.getMethod() + " " + requestSpec.getURI());
		LogManagerHelper.info("Request Headers: " + requestSpec.getHeaders());
		if (requestSpec.getBody() != null) {
			LogManagerHelper.info("Request Body: " + requestSpec.getBody());
		}
	}

	private void logResponse(Response response) {
		LogManagerHelper.info("Response Status: " + response.getStatusCode());
		LogManagerHelper.info("Response Body: " + response.getBody().asString());
	}
}
