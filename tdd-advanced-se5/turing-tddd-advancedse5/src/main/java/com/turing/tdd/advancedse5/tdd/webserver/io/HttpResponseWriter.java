package com.turing.tdd.advancedse5.tdd.webserver.io;

import java.io.DataOutputStream;
import java.io.OutputStream;

public class HttpResponseWriter {
	OutputStream out ;
	
	public HttpResponseWriter(OutputStream out) {
		this.out = out;
	}
	public void write(byte[]data)
	{
		try(DataOutputStream dout = new DataOutputStream(out))
		{
			dout.write(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
