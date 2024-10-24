package com.turing.tdd.advancedse5.tdd.webserver;

import java.net.Socket;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HandlerFactory {
	public void handleRequest(Socket socket)
	{
		log.info("HandleRequest ");
		RequestHandler handler = new RequestHandler(socket);
		handler.start();
	}
}
