package com.turing.tdd.advancedse5.tdd.webserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebServerTest {

	static SimpleHttpServer server;
	static HandlerFactory factory = new HandlerFactory();
	@BeforeAll
	static public void setUpServer()
	{
		log.info("setupserver");
		server = new SimpleHttpServer(8080,factory);
		CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				server.start();
			}
			
		});
	}
	@AfterAll
	static public void shutDownServer()
	{
		log.info("shutDownServer");
		server.shutdown();
	}
	@Test
	public void testServerStartAtPort()
	{
		
		assertEquals(8080,server.getPort());
	}
	
	@Test
	public void testServerCanStartAndListen()throws Exception
	{
		
		Socket socket = new Socket("localhost", 8080);
		
		log.info("Connected ");
		assertTrue(socket.isBound());
		log.info("socket connected");
		
		socket.close();
		
	}

	
	@Test
	public void testBasicHttp200Ok()throws Exception
	{
		HttpRequest request = null;
		request = HttpRequest.newBuilder()
				  .uri(new URI("http://localhost:8080"))
				  //.headers("Content-Type", "text/plain;charset=UTF-8")
				  .build();
		HttpClient client =  HttpClient.newHttpClient();
		HttpResponse<String> response =client.send(request, BodyHandlers.ofString());
		log.info("body "+response.body());
	}
}
