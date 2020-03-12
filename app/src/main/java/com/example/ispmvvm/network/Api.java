package com.example.ispmvvm.network;


import com.example.ispmvvm.models.User;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

import static com.example.ispmvvm.network.Interceptors.getOkHttpClient;


public interface Api {





    @POST("api/Auth/CustomerToken")
    Observable<ResponseBody> userLogin(@Body User userModel);




    static Api getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://10.10.0.174/")
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(Api.class);
    }
}
