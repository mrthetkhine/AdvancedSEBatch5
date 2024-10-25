package com.turing.tdd.advancedse5.tdd.webserver;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpResponseHandler {
	private static final String DELETE = "DELETE";
	private static final String POST = "POST";
	private static final String GET = "GET";

	public HttpResponse handle(HttpRequest request)
	{
		HttpResponse response = new HttpResponse();
		if(GET.equals(request.getHttpMethod()))
		{
			String filePath = request.getUrl();
			Path path = null;
			
			if(request.getUrl().equals("/"))
			{
				path =Paths.get(Config.ROOT_URL+"/index.html");
			}
			else
			{
				filePath = request.getUrl();
				path =Paths.get(Config.ROOT_URL+filePath);
			}
			try {
				//Path path =Paths.get(Config.ROOT_URL+"/index.html");
				log.info("Path "+path);
				String text = new String(Files.readAllBytes(Paths.get(Config.ROOT_URL+"/index.html")), StandardCharsets.UTF_8);
				
				response.setHttpVersion(request.getHttpVersion());
				response.setStatusCode(200);
				
				response.setStatusCodeDescription("OK");
				response.setHeader("Content-Length", text.length()+"");
				response.setHeader("Content-Type","text/html");
				
				response.setBody(text);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				response.setHttpVersion(request.getHttpVersion());
				response.setStatusCode(500);
				
				response.setStatusCodeDescription("Internal Server");
				e.printStackTrace();
			}
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
