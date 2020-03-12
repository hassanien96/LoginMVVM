package com.example.ispmvvm.login;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ispmvvm.models.User;
import com.example.ispmvvm.repositories.UserRepository;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class LoginViewModel extends ViewModel {
    private static final String TAG = "LoginViewModel";

    private UserRepository userRepository = new UserRepository();
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<String> data = new MutableLiveData<>();

    AuthListener listener;

    MutableLiveData<String> getLoginResponse() {
        return data;
    }


    private void requestLogin(User user) {


        userRepository.doLogin(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                        disposable.add(d);
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        listener.onSuccess(responseBody);
                        data.setValue(responseBody.toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                        if (e instanceof IOException) {

                            listener.onFailure("Connection failure");
                        } else {
                            listener.onFailure("Invalid credentials");

                        }
                    }

                    @Override
                    public void onComplete() {


                    }
                });


    }

    public void doLogin(View view, User user) {

        requestLogin(user);

    }

    @Override
    protected void onCleared() {
        disposable.clear();
    }
}
