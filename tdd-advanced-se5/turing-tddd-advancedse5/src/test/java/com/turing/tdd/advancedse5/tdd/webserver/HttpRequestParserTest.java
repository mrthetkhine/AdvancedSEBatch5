package com.turing.tdd.advancedse5.tdd.webserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.turing.tdd.advancedse5.tdd.webserver.requestresponse.HttpRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpRequestParserTest {
	@Test
	public void testGetRequest()
	{
		HttpRequestParser parser = new HttpRequestParser();
		String httpRequestString = "GET / HTTP/1.1\r\n"
				+ "Host: localhost:8080\r\n"
				+ "Connection: keep-alive\r\n"
				+ "Cache-Control: max-age=0\r\n"
				+ "sec-ch-ua: \"Chromium\";v=\"130\", \"Google Chrome\";v=\"130\", \"Not?A_Brand\";v=\"99\"\r\n"
				+ "sec-ch-ua-mobile: ?0\r\n"
				+ "sec-ch-ua-platform: \"macOS\"\r\n"
				+ "Upgrade-Insecure-Requests: 1\r\n"
				+ "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36\r\n"
				+ "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7\r\n"
				+ "Sec-Fetch-Site: none\r\n"
				+ "Sec-Fetch-Mode: navigate\r\n"
				+ "Sec-Fetch-User: ?1\r\n"
				+ "Sec-Fetch-Dest: document\r\n"
				+ "Accept-Encoding: gzip, deflate, br, zstd\r\n"
				+ "Accept-Language: en-US,en;q=0.9\r\n"
				+ "\r\n"
				+ "";
		HttpRequest httpRequest = parser.parseRequest(httpRequestString);
		
		assertEquals("GET", httpRequest.getHttpMethod());
		assertEquals("/", httpRequest.getUrl());
		assertEquals("HTTP/1.1", httpRequest.getHttpVersion());
		
		assertTrue(httpRequest.getHeaders().size()>0);
		assertEquals("localhost:8080",httpRequest.getHeaderValue("Host"));
		assertEquals("keep-alive",httpRequest.getHeaderValue("Connection"));
		assertEquals("en-US,en;q=0.9",httpRequest.getHeaderValue("Accept-Language"));
	}
	@Test
	public void testPostRequest()
	{
		HttpRequestParser parser = new HttpRequestParser();
		String httpRequestString = "POST / HTTP/1.1\r\n"
				+ "Host: localhost:8080\r\n"
				+ "Connection: keep-alive\r\n"
				+ "Content-Length: 34\r\n"
				+ "Cache-Control: max-age=0\r\n"
				+ "sec-ch-ua: \"Chromium\";v=\"130\", \"Google Chrome\";v=\"130\", \"Not?A_Brand\";v=\"99\"\r\n"
				+ "sec-ch-ua-mobile: ?0\r\n"
				+ "sec-ch-ua-platform: \"macOS\"\r\n"
				+ "Origin: null\r\n"
				+ "Content-Type: application/x-www-form-urlencoded\r\n"
				+ "Upgrade-Insecure-Requests: 1\r\n"
				+ "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36\r\n"
				+ "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7\r\n"
				+ "Sec-Fetch-Site: cross-site\r\n"
				+ "Sec-Fetch-Mode: navigate\r\n"
				+ "Sec-Fetch-User: ?1\r\n"
				+ "Sec-Fetch-Dest: document]r\n"
				+ "Accept-Encoding: gzip, deflate, br, zstd\r\n"
				+ "Accept-Language: en-US,en;q=0.9\r\n"
				+ "\r\n"
				+ "username=Something&password=random";
		HttpRequest httpRequest = parser.parseRequest(httpRequestString);
		
		assertEquals("POST", httpRequest.getHttpMethod());
		assertEquals("/", httpRequest.getUrl());
		assertEquals("HTTP/1.1", httpRequest.getHttpVersion());
		
		assertTrue(httpRequest.getHeaders().size()>0);
		assertEquals("localhost:8080",httpRequest.getHeaderValue("Host"));
		assertEquals("keep-alive",httpRequest.getHeaderValue("Connection"));
		assertEquals("en-US,en;q=0.9",httpRequest.getHeaderValue("Accept-Language"));
		assertEquals("34",httpRequest.getHeaderValue("Content-Length"));
		assertEquals(34, httpRequest.getBody().length());
	}
}
