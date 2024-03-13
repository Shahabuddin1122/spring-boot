package com.dsi.spring.exceptions;

public class notFound extends RuntimeException{
    private static final long serialVersionUID = 1;

    public notFound(String message){
        super(message);
    }
}
