package com.crushcoder.movie.rest;


public class WrappedResponse<T> {
    public T results;
    public String status_message;
    public boolean success;
}
