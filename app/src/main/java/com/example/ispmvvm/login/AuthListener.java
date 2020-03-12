package com.example.ispmvvm.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import okhttp3.ResponseBody;

public interface AuthListener {


    public void onSuccess(ResponseBody loginResponse);


    public void onFailure(String message);

}
