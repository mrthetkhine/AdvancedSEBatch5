package com.turing.tdd.advancedse5.tdd.webserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.turing.tdd.advancedse5.tdd.webserver.handler.HttpResponseHandler;
import com.turing.tdd.advancedse5.tdd.webserver.handler.ResponseHandlerFactory;
import com.turing.tdd.advancedse5.tdd.webserver.requestresponse.HttpRequest;
import com.turing.tdd.advancedse5.tdd.webserver.requestresponse.HttpResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResponseHandlerTest {
	
	private HttpResponseHandler getHandler() {
		ResponseHandlerFactory factory = new ResponseHandlerFactory();
		HttpResponseHandler handler = new HttpResponseHandler(factory);
		return handler;
	}
	private HttpRequest makeHttpGetRequest() {
		HttpRequest request = new HttpRequest();
		request.setHttpMethod("GET");
		request.setHttpVersion("HTTP/1.1");
		return request;
	}
	private HttpRequest makePostRequest(String actionUrl) {
		HttpRequest request = new HttpRequest();
		request.setHttpMethod("POST");
		request.setUrl(actionUrl);
		request.setHttpVersion("HTTP/1.1");
		return request;
	}
	@Test
	public void testGetRootPage()
	{
		
		HttpRequest request = makeHttpGetRequest();
		request.setUrl("/");
		
		HttpResponseHandler handler = getHandler();
		HttpResponse response = handler.handle(request);
		
		assertEquals(200,response.getStatusCode());
		assertEquals("text/html",response.getHeaderValue("Content-Type"));
		assertTrue(response.getHeaders().size()>0);
		assertNotNull(response.getBody());
	}
	
	@Test
	public void testGetIndexPage()
	{
		HttpRequest request = makeHttpGetRequest();
		request.setUrl("/index.html");
		
		HttpResponseHandler handler = getHandler();
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
		
		HttpResponseHandler handler = getHandler();
		
		HttpResponse response = handler.handle(request);
		
		assertEquals(404,response.getStatusCode());
		assertEquals("text/html",response.getHeaderValue("Content-Type"));
	
	}
	@Test
	public void testHelloPage()
	{
		HttpRequest request = makeHttpGetRequest();
		request.setUrl("/hello.html");
		
		HttpResponseHandler handler = getHandler();
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
		
		HttpResponseHandler handler = getHandler();
		HttpResponse response = handler.handle(request);
		
		assertEquals(200,response.getStatusCode());
		assertEquals("text/css",response.getHeaderValue("Content-Type"));
		
	}
	@Test
	public void testJSContentType()
	{
		HttpRequest request = makeHttpGetRequest();
		request.setUrl("/lib.js");
		
		HttpResponseHandler handler = getHandler();
		HttpResponse response = handler.handle(request);
		
		assertEquals(200,response.getStatusCode());
		assertEquals("text/javascript",response.getHeaderValue("Content-Type"));
		
	}
	
	@Test
	public void testPostHandler()
	{
		HttpRequest request = this.makePostRequest("ServerAction1");
		HttpResponseHandler handler = getHandler();
		HttpResponse response = handler.handle(request);
		
		assertEquals(200,response.getStatusCode());
		assertTrue(response.getBody().startsWith("Welcome"));
	}
	@Test
	public void testPostHandlerServerAction2()
	{
		HttpRequest request = this.makePostRequest("ServerAction2");
		HttpResponseHandler handler = getHandler();
		HttpResponse response = handler.handle(request);
		
		assertEquals(200,response.getStatusCode());
		assertTrue(response.getBody().startsWith("Hi"));
		
	}
}
