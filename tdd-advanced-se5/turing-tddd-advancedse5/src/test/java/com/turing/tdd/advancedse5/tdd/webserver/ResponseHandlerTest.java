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
		HttpRequest request = makeHttpGetRequest();
		request.setUrl("/");
		
		HttpResponseHandler handler = new HttpResponseHandler();
		HttpResponse response = handler.handle(request);
		
		assertEquals(200,response.getStatusCode());
		assertEquals("text/html",response.getHeaderValue("Content-Type"));
		assertTrue(response.getHeaders().size()>0);
		assertNotNull(response.getBody());
	}
	private HttpRequest makeHttpGetRequest() {
		HttpRequest request = new HttpRequest();
		request.setHttpMethod("GET");
		request.setHttpVersion("HTTP/1.1");
		return request;
	}
	@Test
	public void testGetIndexPage()
	{
		HttpRequest request = makeHttpGetRequest();
		request.setUrl("/index.html");
		
		HttpResponseHandler handler = new HttpResponseHandler();
		HttpResponse response = handler.handle(request);
		
		assertEquals(200,response.getStatusCode());
		assertEquals("text/html",response.getHeaderValue("Content-Type"));
		assertTrue(response.getHeaders().size()>0);
		assertNotNull(response.getBody());
	}
	@Test
	public void testNotFound()
	{
		HttpRequest request = makeHttpGetRequest();
		request.setUrl("/home.html");
		
		HttpResponseHandler handler = new HttpResponseHandler();
		HttpResponse response = handler.handle(request);
		
		assertEquals(404,response.getStatusCode());
		assertEquals("text/html",response.getHeaderValue("Content-Type"));
	
	}
	@Test
	public void testHelloPage()
	{
		HttpRequest request = makeHttpGetRequest();
		request.setUrl("/hello.html");
		
		HttpResponseHandler handler = new HttpResponseHandler();
		HttpResponse response = handler.handle(request);
		
		assertEquals(200,response.getStatusCode());
		assertEquals("text/html",response.getHeaderValue("Content-Type"));
		assertTrue(response.getBody().contains("Welcome"));
	}
	@Test
	public void testCSSContentType()
	{
		HttpRequest request = makeHttpGetRequest();
		request.setUrl("/theme.css");
		
		HttpResponseHandler handler = new HttpResponseHandler();
		HttpResponse response = handler.handle(request);
		
		assertEquals(200,response.getStatusCode());
		assertEquals("text/css",response.getHeaderValue("Content-Type"));
		
	}
	@Test
	public void testJSContentType()
	{
		HttpRequest request = makeHttpGetRequest();
		request.setUrl("/lib.js");
		
		HttpResponseHandler handler = new HttpResponseHandler();
		HttpResponse response = handler.handle(request);
		
		assertEquals(200,response.getStatusCode());
		assertEquals("text/javascript",response.getHeaderValue("Content-Type"));
		
	}
	
}
