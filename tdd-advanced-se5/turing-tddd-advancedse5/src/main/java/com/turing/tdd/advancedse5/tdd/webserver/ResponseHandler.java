package com.turing.tdd.advancedse5.tdd.webserver;

public abstract class ResponseHandler {
	abstract void handle(HttpRequest request,HttpResponse response);
}
