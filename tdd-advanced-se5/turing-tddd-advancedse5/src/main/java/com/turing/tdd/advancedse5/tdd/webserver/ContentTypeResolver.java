package com.turing.tdd.advancedse5.tdd.webserver;

public class ContentTypeResolver {
	public String resolve(String fileExtension)
	{
		if("html".equals(fileExtension))
		{
			return "text/html";
		}
		else if("htm".equals(fileExtension))
		{
			return "text/html";
		}
		else if("css".equals(fileExtension))
		{
			return "text/css";		
		}
		else if("js".equals(fileExtension)) 
		{
			return "text/javascript";
		}
		else
		{
			return "text/plain";
		}
	}
}
