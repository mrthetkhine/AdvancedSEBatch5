package com.turing.tdd.advancedse5.tdd.webserver;

import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpRequestParser {
	
	HttpRequest parseRequest(String httpRequest)
	{
		HttpRequest response = new HttpRequest();
		String[] lines = httpRequest.split("\r\n");
		
		parseStatusLine(response, lines);
		parseHeadersAndBody(response, lines);
		
		return response;
	}

	private void parseHeadersAndBody(HttpRequest response, String[] lines) {
		HashMap<String, String> headers = response.getHeaders();
		int i=1;
		for(;i< lines.length;i++)
		{
			String header = lines[i];
			if(header.isBlank())//body
			{
				break;
			}
			else
			{
				String keyValues[] = header.split(": ");
				headers.put(keyValues[0], keyValues[1]);
			}
		}
		if( i < lines.length-1)//we have body
		{
			String body = lines[lines.length-1];
			log.info("Body "+body);
			response.setBody(body);
		}
	}

	private void parseStatusLine(HttpRequest response, String[] lines) {
		String firstLine = lines[0];
		String[] requestLines = firstLine.split(" ");
		String method = requestLines[0];
		String url = requestLines[1];
		String httpVersion = requestLines[2];
		
		response.setHttpMethod(method);
		response.setHttpVersion(httpVersion);
		response.setUrl(url);
	}
}
