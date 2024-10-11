package com.turing.tdd.advancedse5.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
	
	int port = 8080;
	ServerSocket serverSocket;
	HttpServer()
	{
		try {
			this.serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.startServer();
	}
	public void startServer()
	{
		
		while(true)
		{
			try {
				Socket clientSocket = this.serverSocket.accept();
				Handler handler = new Handler(clientSocket);
				handler.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class Handler extends Thread
	{
		Socket client ;
		Handler(Socket client)
		{
			this.client = client;
		}
		public void run()
		{
			try {
				DataInputStream din = new DataInputStream(client.getInputStream());
				String requestLine = din.readLine();
				String header = din.readLine();
				String body = din.readLine();
				
				System.out.println("Reqsuestline "+requestLine);
				System.out.println("Header "+header);
				System.out.println("body "+body);
				
				DataOutputStream dout = new DataOutputStream(client.getOutputStream());
				String bodyResponse = "<html>Hello</html>";
				String response = "HTTP/1.1 200 OK\r\n"
								+"Connection:Closed\r\n"
								+"Content-Length:"+bodyResponse.length()+"\r\n\r\n"
								+ bodyResponse;
				dout.write(response.getBytes());
				din.close();
				dout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[]args)
	{
		new HttpServer();
	}
}
