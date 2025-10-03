package com.example.user.exception;

public class BlogNotFoundException extends RuntimeException{
    public BlogNotFoundException(String message){
        super(message);
    }
}
