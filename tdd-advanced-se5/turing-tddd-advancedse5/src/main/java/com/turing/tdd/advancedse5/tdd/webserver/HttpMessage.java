package com.turing.tdd.advancedse5.tdd.webserver;

import java.util.HashMap;

public class HttpMessage {
	private String httpVersion;
	
	private HashMap<String,String> headers;
	private String body;
	
	HttpMessage()
	{
		this.headers = new HashMap<>();
	}

	public String getHttpVersion() {
		return httpVersion;
	}

	public void setHttpVersion(String httpVersion) {
		this.httpVersion = httpVersion;
	}

	public HashMap<String, String> getHeaders() {
		return headers;
	}
	public void setHeader(String key, String value)
	{
		this.headers.put(key,value);
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
	public String getHeaderValue(String key)
	{
		String value = this.headers.get(key);
		return value==null?"":value;
	}
}
