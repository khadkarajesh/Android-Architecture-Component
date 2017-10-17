package com.crushcoder.moviesmvvm.rest;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;


public class WrappedResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private Converter<ResponseBody, WrappedResponse<T>> converter;

    public WrappedResponseBodyConverter(Converter<ResponseBody, WrappedResponse<T>> converter) {
        this.converter = converter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        WrappedResponse<T> response = converter.convert(value);
        if (!response.success) {
            try {
                throw new WrappedError(response.status_message, response.status_code);
            } catch (WrappedError wrappedError) {
                wrappedError.printStackTrace();
            }
        }
        //check if response is success or not
        return response.results;
    }
}
