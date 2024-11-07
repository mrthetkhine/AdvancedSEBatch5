package com.turing.tdd.advancedse5.tdd.webserver.io;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpRequestReader {
	InputStream in ;
	
	public HttpRequestReader(InputStream in)
	{
		this.in = in;
	}
	public String readHttpRequestStream()
	{
		String httpRequest = "";
		
		try
		{
			DataInputStream din = new DataInputStream(in);
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
				String body = readBody( din, contentLength);
				httpRequest += body;
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
	private String readBody(DataInputStream din, int contentLength) throws IOException {
		byte[] bytes = new byte[contentLength];
		din.read(bytes);
		String body = new String(bytes);
		log.info("Body-> "+body);
		
		return body;
	}
}
