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

import com.turing.tdd.advancedse5.tdd.webserver.handler.custom.ServerAction1;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PostHandler extends ResponseHandler{

	
	
	@Override
	public void handle(HttpRequest request, HttpResponse response) {
		
		handlePost(request,response);
	}
	private void handlePost(HttpRequest request, HttpResponse response) {
		Path path = getPathFromUrl(request);
		log.info("Action URL Path "+ path);
		try {
			//Path path =Paths.get(Config.ROOT_URL+"/index.html");
			log.info("Path "+path);
			
			Class serverAction = Class.forName("com.turing.tdd.advancedse5.tdd.webserver.handler.custom."+path.toString());
			ResponseHandler serverSideCode = (ResponseHandler) serverAction.newInstance();
			
			serverSideCode.handle(request, response);
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			response.setHttpVersion(request.getHttpVersion());
			response.setHeader("Content-Type", "text/html");
			setResponseCode(response,500,"Internal Server Error");
			e.printStackTrace();
		}
	}

	

	private Path getPathFromUrl(HttpRequest request) {
		String filePath = request.getUrl();
		if(filePath.startsWith("/"))
		{
			//Remove prefix /
			filePath =filePath.substring(1);
		}
		Path path = null;
		
		path =Paths.get(filePath);
		return path;
	}

	
}
