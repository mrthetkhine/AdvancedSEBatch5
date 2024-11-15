package com.turing.tdd.advancedse5.tdd.webserver.handler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.turing.tdd.advancedse5.tdd.webserver.requestresponse.HttpRequest;
import com.turing.tdd.advancedse5.tdd.webserver.requestresponse.HttpResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpResponseHandler {
	
	ResponseHandlerFactory factory;
	public HttpResponseHandler(ResponseHandlerFactory factory)
	{
		this.factory = factory;
	}
	
	public HttpResponse handle(HttpRequest request)
	{
		HttpResponse response = new HttpResponse();
		
		ResponseHandler handler = this.factory.getResponseHandler(request.getHttpMethod());
		handler.handle(request, response);
		
		return response;
	}

	
}
