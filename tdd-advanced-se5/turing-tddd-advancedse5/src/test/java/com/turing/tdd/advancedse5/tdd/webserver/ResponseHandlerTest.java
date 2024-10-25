package com.turing.tdd.advancedse5.tdd.webserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResponseHandlerTest {
	@Test
	public void testGetRootPage()
	{
		HttpRequest request = new HttpRequest();
		request.setHttpMethod("GET");
		request.setHttpVersion("HTTP/1.1");
		request.setUrl("/");
		
		HttpResponseHandler handler = new HttpResponseHandler();
		HttpResponse response = handler.handle(request);
		
		assertEquals(200,response.getStatusCode());
		assertEquals("text/html",response.getHeaderValue("Content-Type"));
		assertTrue(response.getHeaders().size()>0);
		assertNotNull(response.getBody());
	}
	@Test
	public void testGetIndexPage()
	{
		HttpRequest request = new HttpRequest();
		request.setHttpMethod("GET");
		request.setHttpVersion("HTTP/1.1");
		request.setUrl("/index.html");
		
		HttpResponseHandler handler = new HttpResponseHandler();
		HttpResponse response = handler.handle(request);
		
		assertEquals(200,response.getStatusCode());
		assertEquals("text/html",response.getHeaderValue("Content-Type"));
		assertTrue(response.getHeaders().size()>0);
		assertNotNull(response.getBody());
	}
}
