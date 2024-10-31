package com.turing.tdd.advancedse5.tdd.webserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpClientHandler extends Thread{
	
	HttpRequestParser parser;
	HttpResponseHandler responseHandler;
	HttpResponseTransformer responseTransformer;
	
	Socket socket;
	HttpRequest request;
	HttpResponse response;
	
	public HttpClientHandler(Socket socket,
			HttpRequestParser parser,
			HttpResponseHandler responseHandler,
			HttpResponseTransformer responseTransformer)
	{
		this.socket = socket;
		this.parser = parser;
		this.responseHandler = responseHandler;
		this.responseTransformer  = responseTransformer;
	}
	public void run()
	{
		//Request Handling
		//Response writing
		this.parseRequest();
		this.procesResponse();
		this.writeResponse();
		try
		{
			this.socket.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	void parseRequest()
	{
		String httpRequestString =  readHttpRequestStream();
		this.request =  this.parser.parseRequest(httpRequestString);
	}
	private String readHttpRequestStream() {
		String httpRequest = "";
		DataInputStream  din = null;
		try
		{
			din = new DataInputStream(this.socket.getInputStream());
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
		this.response = this.responseHandler.handle(request);
	}
	void writeResponse()
	{
		byte[] data = this.responseTransformer.transformResponse(response);
		String responseStr = new String(data);
		log.info("Response "+responseStr);
		
		try(DataOutputStream dout = new DataOutputStream(this.socket.getOutputStream()))
		{
			dout.write(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
