package com.turing.tdd.advancedse5.tdd.webserver.requestresponse;

import java.util.HashMap;

public class HttpRequest extends HttpMessage{
	private String httpMethod;
	private String url;
	
	
	public HttpRequest()
	{
		super();
	}


	public String getHttpMethod() {
		return httpMethod;
	}


	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}

	
	
}
