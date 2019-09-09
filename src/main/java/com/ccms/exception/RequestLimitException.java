package com.ccms.exception;

public class RequestLimitException extends Exception {
    private static final long serialVersionUID = 1364225358754654702L;

    public RequestLimitException(){
        super("请求太频繁，请稍后再试");
    }

    public RequestLimitException(String message){
        super(message);
    }
}