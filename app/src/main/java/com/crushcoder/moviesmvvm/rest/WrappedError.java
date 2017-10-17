package com.crushcoder.moviesmvvm.rest;


public class WrappedError extends Throwable {
    private String mErrorMessage;
    private int mStatusCode;

    public WrappedError(String errorMessage, int statusCode) {
        this.mErrorMessage = errorMessage;
        this.mStatusCode = statusCode;
    }

    public String getmErrorMessage() {
        return mErrorMessage;
    }

    public void setmErrorMessage(String mErrorMessage) {
        this.mErrorMessage = mErrorMessage;
    }

    public int getmStatusCode() {
        return mStatusCode;
    }

    public void setmStatusCode(int mStatusCode) {
        this.mStatusCode = mStatusCode;
    }
}
