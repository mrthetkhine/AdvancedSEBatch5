package com.turing.tdd.advancedse5.tdd.webserver;



public class Starter {
	public static void main(String[]args)
	{
		HandlerFactory factory = new HandlerFactory();
		SimpleHttpServer server = new SimpleHttpServer(8080,factory);
		server.start();
	}
}
