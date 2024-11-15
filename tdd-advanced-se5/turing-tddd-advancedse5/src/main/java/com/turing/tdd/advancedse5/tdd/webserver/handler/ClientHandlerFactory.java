package com.turing.tdd.advancedse5.tdd.webserver.handler;

import java.net.Socket;

import com.turing.tdd.advancedse5.tdd.webserver.HttpRequestParser;
import com.turing.tdd.advancedse5.tdd.webserver.HttpResponseTransformer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientHandlerFactory {
	public void handleRequest(Socket socket)
	{
		log.info("HandleRequest ");
		HttpRequestParser parser = new HttpRequestParser();
		
		ResponseHandlerFactory responseHandlerFactory = new ResponseHandlerFactory();
		HttpResponseHandler responseHandler = new HttpResponseHandler(responseHandlerFactory);
		HttpResponseTransformer transformer = new HttpResponseTransformer();
		HttpClientHandler handler = new HttpClientHandler(socket,parser,responseHandler,transformer);
		
		handler.start();
	}
}
