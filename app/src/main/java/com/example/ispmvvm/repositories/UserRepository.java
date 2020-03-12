package com.example.ispmvvm.repositories;

import com.example.ispmvvm.models.User;
import com.example.ispmvvm.network.Api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

public class UserRepository {



    public Observable<ResponseBody>doLogin(User user)

    {


       return Api.getRetrofit().userLogin(user);

    }





}
