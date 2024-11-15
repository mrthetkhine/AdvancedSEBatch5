package com.turing.tdd.advancedse5.tdd.webserver.handler;

import java.util.HashMap;

public class ResponseHandlerFactory {

	private static final String DELETE = "DELETE";
	private static final String POST = "POST";
	private static final String GET = "GET";
	
	private ResponseHandler getMethodHandler = new GetHandler();
	private ResponseHandler postMethodHandler = new PostHandler();
	private ResponseHandler deleteMethodHandler = new DeleteHandler();
	
	private HashMap<String,ResponseHandler> handlerMap;
	
	public ResponseHandlerFactory()
	{
		this.handlerMap = new HashMap<String,ResponseHandler>();
		this.handlerMap.put(GET, getMethodHandler);
		this.handlerMap.put(POST, postMethodHandler);
		this.handlerMap.put(DELETE, deleteMethodHandler);
		
	}
	public void addHandler(String method, ResponseHandler handler)
	{
		this.handlerMap.put(method, handler);
	}
	public ResponseHandler getResponseHandler(String httpMethod)
	{
		ResponseHandler handler = this.handlerMap.get(httpMethod);
		if(handler == null)
		{
			return this.getMethodHandler;
		}
		return handler;
	}
	
}
