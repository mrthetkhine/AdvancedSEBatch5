package com.turing.tdd.advancedse5.tdd.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.turing.tdd.advancedse5.tdd.webserver.handler.HandlerFactory;

import lombok.extern.slf4j.Slf4j;



@Slf4j
public class SimpleHttpServer {
	int port;
	boolean isClosed = false;
	ServerSocket serverSocket;
	
	HandlerFactory handlerFactory;
	
	public SimpleHttpServer(int port,HandlerFactory handlerFactory)
	{
		this.port = port;
		this.handlerFactory = handlerFactory;
	}
	public int getPort()
	{
		return this.port;
	}
	public void start()
	{
		try
		{
			this.serverSocket = new ServerSocket(this.port);
			log.info("Server started at port "+port);
			while(!this.isClosed)
			{
				Socket client = this.serverSocket.accept();
				log.info("Client received");
				
				this.handlerFactory.handleRequest(client);
				
			}
		}
		catch(Exception e)
		{
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}
	public void shutdown()
	{
		try {
			this.isClosed = true;
			this.serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//log.info(e.getMessage());
		}
	}
}
