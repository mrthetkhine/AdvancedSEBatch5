package com.turing.tdd.advancedse5.tdd.webserver.requestresponse;

public class HttpResponse extends HttpMessage{
	private int statusCode;
	private String statusCodeDescription;
	
	public HttpResponse()
	{
		super();
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusCodeDescription() {
		return statusCodeDescription;
	}

	public void setStatusCodeDescription(String statusCodeDescription) {
		this.statusCodeDescription = statusCodeDescription;
	}
	
}
