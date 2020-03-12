package com.example.ispmvvm.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.ispmvvm.R;
import com.example.ispmvvm.databinding.ActivityLoginBinding;
import com.example.ispmvvm.models.User;

import okhttp3.ResponseBody;

public class LoginActivity extends AppCompatActivity implements AuthListener {

    private static final String TAG = "LoginActivity";
    ActivityLoginBinding binding;

    User user=new User();
    LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_login);
        viewModel=  ViewModelProviders.of(this).get(LoginViewModel.class);

        binding.setViewModel(viewModel);
        viewModel.listener=this;
        binding.executePendingBindings();
        binding.setUserModel(user);




        viewModel.getLoginResponse().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d(TAG, "onChanged: "+s);
            }
        });








    }


    @Override
    public void onSuccess(ResponseBody loginResponse) {

        Toast.makeText(this, loginResponse.toString(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onFailure(String message) {


        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
