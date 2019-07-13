package com.example.responsimvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.responsimvp.Interface.ILoginPresenter;
import com.example.responsimvp.presenter.LoginPresenter;

import java.util.logging.ErrorManager;

public class MainActivity extends AppCompatActivity {
    EditText edtEmail;
    EditText edtPassword;
    Button btnLogin;

    ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        loginPresenter = new LoginPresenter(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                loginPresenter.onLogin(email, password);

            }
        });
    }

    @Override
    public void onLoginSucces(String message) {
        Object Toasty;
        Toasty.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onLoginError (String message){
        ErrorManager Toasty;
        Toasty.error(this, message, Toast.LENGTH_SHORT).show();
    }
}
