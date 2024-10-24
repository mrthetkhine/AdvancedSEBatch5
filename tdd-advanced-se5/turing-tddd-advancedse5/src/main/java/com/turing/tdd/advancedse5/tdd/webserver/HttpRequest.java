package com.turing.tdd.advancedse5.tdd.webserver;

import java.util.HashMap;

public class HttpRequest {
	String httpMethod;
	HashMap<String,String> headers;
	String body;
	
	public HttpRequest()
	{
		this.headers = new HashMap<>();
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public HashMap<String, String> getHeaders() {
		return headers;
	}
	public String getHeaderValue(String header)
	{
		String value = this.headers.get(header);
		return value ==null?"":value;
	}
	public void setHeaders(HashMap<String, String> headers) {
		this.headers = headers;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
}
