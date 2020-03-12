package com.example.ispmvvm.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class Interceptors {


    static OkHttpClient getOkHttpClient() {

        OkHttpClient.Builder okhttpClientBuilder = new OkHttpClient.Builder();

        okhttpClientBuilder.connectTimeout(30, TimeUnit.HOURS);
        okhttpClientBuilder.readTimeout(30, TimeUnit.HOURS);
        okhttpClientBuilder.writeTimeout(30, TimeUnit.HOURS);


        okhttpClientBuilder.addInterceptor(loggingClient());



        return okhttpClientBuilder.build();

    }


    static HttpLoggingInterceptor loggingClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.level(HttpLoggingInterceptor.Level.BODY);

        return logging;
    }


}
