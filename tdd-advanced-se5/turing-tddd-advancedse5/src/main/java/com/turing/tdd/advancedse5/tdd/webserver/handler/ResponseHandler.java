package com.turing.tdd.advancedse5.tdd.webserver.handler;

import com.turing.tdd.advancedse5.tdd.webserver.requestresponse.HttpRequest;
import com.turing.tdd.advancedse5.tdd.webserver.requestresponse.HttpResponse;

public abstract class ResponseHandler {
	public abstract void handle(HttpRequest request,HttpResponse response);
}
