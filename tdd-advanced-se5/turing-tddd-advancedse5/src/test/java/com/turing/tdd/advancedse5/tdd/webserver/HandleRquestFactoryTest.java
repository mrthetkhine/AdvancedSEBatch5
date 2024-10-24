package com.turing.tdd.advancedse5.tdd.webserver;

import static org.mockito.ArgumentMatchers.any;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class HandleRquestFactoryTest {

	@Test
	public void testRequestHandleWhenConnect() throws UnknownHostException, IOException
	{
		
		HandlerFactory factory = Mockito.mock(HandlerFactory.class);
		SimpleHttpServer server = new SimpleHttpServer(8080,factory);
		CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				server.start();
			}	
		});
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Socket socket = new Socket("localhost", 8080);
		Mockito.verify(factory).handleRequest(any(Socket.class));
		server.shutdown();
	}
}
