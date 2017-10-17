package com.crushcoder.moviesmvvm.rest;

import android.support.annotation.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class UnwrapConverterFactory extends Converter.Factory {
    private GsonConverterFactory mGsonConverterFactory;

    public UnwrapConverterFactory(GsonConverterFactory gsonConverterFactory) {
        this.mGsonConverterFactory = gsonConverterFactory;
    }

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        Type wrappedType = new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                // -> WrappedResponse<type>
                return new Type[]{type};
            }

            @Override
            public Type getOwnerType() {
                return null;
            }

            @Override
            public Type getRawType() {
                return WrappedResponse.class;
            }
        };
        Converter<ResponseBody, ?> gsonConverter = mGsonConverterFactory
                .responseBodyConverter(wrappedType, annotations, retrofit);
        return new WrappedResponseBodyConverter(gsonConverter);
    }
}
