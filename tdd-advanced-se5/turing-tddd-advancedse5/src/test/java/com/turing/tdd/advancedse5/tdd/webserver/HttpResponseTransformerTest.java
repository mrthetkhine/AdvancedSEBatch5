package com.turing.tdd.advancedse5.tdd.webserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.turing.tdd.advancedse5.tdd.webserver.requestresponse.HttpResponse;

public class HttpResponseTransformerTest {
	@Test
	public void testStatusLine()
	{
		HttpResponse response = new HttpResponse();
		response.setHttpVersion("HTTP/1.1");
		response.setStatusCode(200);
		response.setStatusCodeDescription("OK");
		
		HttpResponseTransformer transformer = new HttpResponseTransformer();
		String data = new String(transformer.transformResponse(response));
		
		String[] lines = data.split("\r\n");
		String statusLine = lines[0];
		assertEquals("HTTP/1.1 200 OK",statusLine);
	}
	@Test
	public void testHeader()
	{
		HttpResponse response = new HttpResponse();
		response.setHttpVersion("HTTP/1.1");
		response.setStatusCode(200);
		response.setStatusCodeDescription("OK");
		
		response.setHeader("Content-Type", "text/html");
		HttpResponseTransformer transformer = new HttpResponseTransformer();
		String data = new String(transformer.transformResponse(response));
		
		String[] lines = data.split("\r\n");
		String statusLine = lines[0];
		assertEquals("HTTP/1.1 200 OK",statusLine);
		assertTrue(data.contains("Content-Type: text/html"));
	}
}
