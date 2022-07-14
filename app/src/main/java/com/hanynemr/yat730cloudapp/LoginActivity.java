package com.hanynemr.yat730cloudapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class LoginActivity extends AppCompatActivity {

    EditText loginMail, loginPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginMail = findViewById(R.id.loginMail);
        loginPass = findViewById(R.id.loginPass);

        Backendless.initApp(this, "850B5092-75E8-B993-FFFC-E4380B1C9900", "F09796D9-05F3-4C8B-BA3F-14A162602BA0");
    }

    public void login(View view) {
        String mail = loginMail.getText().toString();
        String pass = loginPass.getText().toString();

        Backendless.UserService.login(mail, pass, new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser response) {

                Intent in = new Intent(LoginActivity.this, MovieActivity.class);
                startActivity(in);
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                if (fault.getCode().equals("3003"))
                    Toast.makeText(LoginActivity.this, "invalid data", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(LoginActivity.this, "error in login", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void newUser(View view) {
        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
    }
}