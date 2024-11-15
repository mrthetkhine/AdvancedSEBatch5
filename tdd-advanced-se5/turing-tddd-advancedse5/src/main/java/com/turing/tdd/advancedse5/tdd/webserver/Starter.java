package com.turing.tdd.advancedse5.tdd.webserver;

import com.turing.tdd.advancedse5.tdd.webserver.handler.ClientHandlerFactory;

public class Starter {
	public static void main(String[]args)
	{
		ClientHandlerFactory factory = new ClientHandlerFactory();
		SimpleHttpServer server = new SimpleHttpServer(8080,factory);
		server.start();
	}
}
