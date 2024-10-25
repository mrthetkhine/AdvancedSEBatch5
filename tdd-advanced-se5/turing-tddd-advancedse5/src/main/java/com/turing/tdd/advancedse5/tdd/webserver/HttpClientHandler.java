package com.turing.tdd.advancedse5.tdd.webserver;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpClientHandler extends Thread{
	
	HttpRequestParser parser;
	
	Socket socket;
	HttpRequest request;
	
	public HttpClientHandler(Socket socket,HttpRequestParser parser)
	{
		this.socket = socket;
		this.parser = parser;
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
		String httpRequestString =  readHttpRequestStream();
		this.request =  this.parser.parseRequest(httpRequestString);
	}
	private String readHttpRequestStream() {
		String httpRequest = "";
		try(DataInputStream  din = new DataInputStream(this.socket.getInputStream()))
		{
			log.info("Parse Request");
			int contentLength = 0;
			
			String line = din.readLine();
			while(line!= null && !line.isEmpty())
			{
				log.info("Line "+line);
				httpRequest += line +"\r\n";
				line = din.readLine();
				if(line.startsWith("Content-Length"))
				{
					contentLength = Integer.parseInt(line.split(":")[1].trim());
				}
			}
			httpRequest += "\r\n";
			if(contentLength>0)
			{
				byte[] bytes = new byte[contentLength];
				din.read(bytes);
				String body = new String(bytes);
				log.info("Body-> "+body);
				httpRequest += body ;
			}
			log.info("Done ");
			log.info(httpRequest);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return httpRequest;
	}
	void procesResponse()
	{
		log.info("procesResponse");
	}
}
