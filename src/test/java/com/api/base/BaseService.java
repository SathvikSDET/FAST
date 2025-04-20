package com.api.base;

import java.lang.classfile.instruction.SwitchCase;

import com.api.filter.LoggingFilter;
import com.utils.ConfigManager;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

	protected RequestSpecification requestSpec;
	protected ConfigManager config;

	static {
		RestAssured.filters(new LoggingFilter());
	}

	public BaseService() {
		config = ConfigManager.getConfig();
		this.requestSpec = RestAssured.given().baseUri(config.getProperty("URL")).contentType(ContentType.JSON);

	}
	
	@Deprecated
	public Response postRequest(String endpoint, Object payload) {
		return requestSpec.body(payload).post(endpoint);
	}

	public Response sendRequest(HttpMetthod method, Object payload, String endpoint) {
		requestSpec.body(payload);

		switch (method) {
		case GET:
			return requestSpec.get(endpoint);
		case POST:
			return requestSpec.post(endpoint);
		case PUT:
			return requestSpec.put(endpoint);
		case DELETE:
			return requestSpec.delete(endpoint);
		case PATCH:
			return requestSpec.patch(endpoint);
		default:
			throw new IllegalArgumentException("Unsupported HTTP method: " + method);
		}

	}

}
