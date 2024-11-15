package com.turing.tdd.advancedse5.tdd.webserver.handler;

import com.turing.tdd.advancedse5.tdd.webserver.ContentTypeResolver;
import com.turing.tdd.advancedse5.tdd.webserver.requestresponse.HttpRequest;
import com.turing.tdd.advancedse5.tdd.webserver.requestresponse.HttpResponse;

public abstract class ResponseHandler {
	ContentTypeResolver contentTypeResolver = new ContentTypeResolver();
	
	public abstract void handle(HttpRequest request,HttpResponse response);
	
	protected void setResponseCode(HttpResponse response,int statusCode, String  statusCodeDescripton) {
		response.setStatusCode(statusCode);
		response.setStatusCodeDescription(statusCodeDescripton);
	}
}
