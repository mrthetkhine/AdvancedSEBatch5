package com.turing.tdd.advancedse5.tdd.webserver;

import java.util.HashMap;

import com.turing.tdd.advancedse5.tdd.webserver.requestresponse.HttpRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpRequestParser {
	
	public HttpRequest parseRequest(String httpRequest)
	{
		HttpRequest response = new HttpRequest();
		String[] lines = httpRequest.split("\r\n");
		
		parseStatusLine(response, lines);
		parseHeadersAndBody(response, lines);
		
		return response;
	}

	private void parseHeadersAndBody(HttpRequest response, String[] httpRequestLines) {
		HashMap<String, String> headers = response.getHeaders();
		int i=1;
		for(;i< httpRequestLines.length;i++)
		{
			String header = httpRequestLines[i];
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
		if( i < httpRequestLines.length-1)//we have body
		{
			String body = httpRequestLines[httpRequestLines.length-1];
			log.info("Body "+body);
			response.setBody(body);
		}
	}

	private void parseStatusLine(HttpRequest response, String[] lines) {
		if(lines.length>0)
		{
			String statusLine = lines[0];
			String[] requestLines = statusLine.split(" ");
			String method = requestLines[0];
			String url = requestLines[1];
			String httpVersion = requestLines[2];
			
			response.setHttpMethod(method);
			response.setHttpVersion(httpVersion);
			response.setUrl(url);
		}
		
	}
}
