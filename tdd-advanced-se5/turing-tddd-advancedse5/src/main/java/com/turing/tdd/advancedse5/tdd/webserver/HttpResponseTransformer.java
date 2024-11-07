package com.turing.tdd.advancedse5.tdd.webserver;

import java.util.Map.Entry;

import com.turing.tdd.advancedse5.tdd.webserver.requestresponse.HttpResponse;

public class HttpResponseTransformer {
	public byte[] transformResponse(HttpResponse response)
	{
		StringBuffer responseStr = new StringBuffer();
		
		String bodyResponse = response.getBody();
		responseStr.append(response.getHttpVersion()+" "+ response.getStatusCode() + " "+response.getStatusCodeDescription()+"\r\n");
		for(Entry<String, String> header: response.getHeaders().entrySet())
		{
			responseStr.append(header.getKey()+": "+header.getValue()+"\r\n");
		}
		responseStr.append("Connection: Closed\r\n");
		responseStr.append("\r\n");
		if(bodyResponse !=null)
		{
			responseStr.append(bodyResponse);
		}
		
		return responseStr.toString().getBytes();
	}
}
