package com.turing.tdd.advancedse5.tdd.webserver.handler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.turing.tdd.advancedse5.tdd.webserver.Config;
import com.turing.tdd.advancedse5.tdd.webserver.ContentTypeResolver;
import com.turing.tdd.advancedse5.tdd.webserver.requestresponse.HttpRequest;
import com.turing.tdd.advancedse5.tdd.webserver.requestresponse.HttpResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetHandler extends ResponseHandler{

	ContentTypeResolver contentTypeResolver = new ContentTypeResolver();
	
	@Override
	public void handle(HttpRequest request, HttpResponse response) {
		
		handleGet(request,response);
	}
	private void handleGet(HttpRequest request, HttpResponse response) {
		Path path = getPathFromUrl(request);
		try {
			//Path path =Paths.get(Config.ROOT_URL+"/index.html");
			log.info("Path "+path);
		
			String fileExtension = getFileExtension(path);
			String contentType = this.contentTypeResolver.resolve(fileExtension);
			String text = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
			
			create200Response(request, response, contentType, text);
		}
		catch(NoSuchFileException notFound)
		{
			setResponseCode(response,404,"Not Found");
			
			response.setHeader("Content-Type","text/html");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			response.setHttpVersion(request.getHttpVersion());
			setResponseCode(response,500,"Internal Server Error");
			e.printStackTrace();
		}
	}

	private void create200Response(HttpRequest request, HttpResponse response, String contentType, String text) {
		response.setHttpVersion(request.getHttpVersion());
		setResponseCode(response,200,"OK");
		response.setHeader("Content-Length", text.length()+"");
		response.setHeader("Content-Type",contentType);
		
		response.setBody(text);
	}

	private String getFileExtension(Path path) {
		String fileName = path.getFileName().toString();
		String fileExtension = fileName.substring(fileName.lastIndexOf(".")+1);
		return fileExtension;
	}

	private Path getPathFromUrl(HttpRequest request) {
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
		return path;
	}

	private void setResponseCode(HttpResponse response,int statusCode, String  statusCodeDescripton) {
		response.setStatusCode(statusCode);
		response.setStatusCodeDescription(statusCodeDescripton);
	}
}
