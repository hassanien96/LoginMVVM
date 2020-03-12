package com.example.ispmvvm.models;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.ispmvvm.BR;

public class User extends BaseObservable {

    String password, login;


    public User() {
    }

    @Bindable
    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    @Bindable
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
        notifyPropertyChanged(BR.login);
    }
}
