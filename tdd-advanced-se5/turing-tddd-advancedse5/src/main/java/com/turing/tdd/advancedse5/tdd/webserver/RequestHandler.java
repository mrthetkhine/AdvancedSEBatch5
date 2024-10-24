package com.turing.tdd.advancedse5.tdd.webserver;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestHandler extends Thread{
	Socket socket;
	HttpRequest request;
	public RequestHandler(Socket socket)
	{
		this.socket = socket;
	}
	public void run()
	{
		//Request Handling
		//Response writing
		this.parseRequest();
		this.procesResponse();
	}
	void parseRequest()
	{
		try(DataInputStream  din = new DataInputStream(this.socket.getInputStream()))
		{
			log.info("Parse Request");
			String statusLine = din.readLine();
			//byte bytes[] = din.readAllBytes();
			//int count;
			//String data= new String(bytes);
			
			log.info("Http Request string>> "+ statusLine);
			//log.info("Http Request "+ data);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	void procesResponse()
	{
		log.info("procesResponse");
	}
}
