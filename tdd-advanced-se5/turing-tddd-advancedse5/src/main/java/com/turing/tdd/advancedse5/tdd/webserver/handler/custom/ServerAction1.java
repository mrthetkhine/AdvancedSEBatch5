package com.turing.tdd.advancedse5.tdd.webserver.handler.custom;

import com.turing.tdd.advancedse5.tdd.webserver.handler.ResponseHandler;
import com.turing.tdd.advancedse5.tdd.webserver.requestresponse.HttpRequest;
import com.turing.tdd.advancedse5.tdd.webserver.requestresponse.HttpResponse;

public class ServerAction1 extends ResponseHandler{

	@Override
	public void handle(HttpRequest request, HttpResponse response) {
		
		String responseText = "Welcome from serverside code";
		
		response.setHttpVersion(request.getHttpVersion());
		setResponseCode(response,200,"OK");
		response.setHeader("Content-Length", responseText.length()+"");
		response.setHeader("Content-Type","text/html");
		
		response.setBody(responseText);
	}

}
