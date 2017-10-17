package com.crushcoder.moviesmvvm;


public class WrappedResponse<T> {
    public int page;
    public T results;
    public int status_code;
    public String status_message;
    public boolean success;
}
