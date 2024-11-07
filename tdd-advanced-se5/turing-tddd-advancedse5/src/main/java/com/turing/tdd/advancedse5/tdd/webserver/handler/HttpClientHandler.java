package com.turing.tdd.advancedse5.tdd.webserver.handler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import com.turing.tdd.advancedse5.tdd.webserver.HttpRequestParser;
import com.turing.tdd.advancedse5.tdd.webserver.HttpResponseTransformer;
import com.turing.tdd.advancedse5.tdd.webserver.io.HttpRequestReader;
import com.turing.tdd.advancedse5.tdd.webserver.io.HttpResponseWriter;
import com.turing.tdd.advancedse5.tdd.webserver.requestresponse.HttpRequest;
import com.turing.tdd.advancedse5.tdd.webserver.requestresponse.HttpResponse;

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
		HttpRequestReader reader;
		String result= "";
		try {
			reader = new HttpRequestReader(this.socket.getInputStream());
			result = reader.readHttpRequestStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
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
		
		HttpResponseWriter writer;
		try {
			writer = new HttpResponseWriter(this.socket.getOutputStream());
			writer.write(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
