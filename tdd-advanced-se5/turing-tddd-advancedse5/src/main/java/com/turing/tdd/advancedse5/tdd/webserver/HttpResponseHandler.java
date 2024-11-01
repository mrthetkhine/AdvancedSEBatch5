package com.turing.tdd.advancedse5.tdd.webserver;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpResponseHandler {
	private static final String DELETE = "DELETE";
	private static final String POST = "POST";
	private static final String GET = "GET";

	ResponseHandler getHandler = new GetHandler();
	
	public HttpResponse handle(HttpRequest request)
	{
		HttpResponse response = new HttpResponse();
		if(GET.equals(request.getHttpMethod()))
		{
			getHandler.handle(request, response);
		}
		else if(POST.equals(request.getHttpMethod()))
		{
			
		}
		else if(DELETE.equals(request.getHttpMethod()))
		{
			
		}
		
		return response;
	}

	
}
