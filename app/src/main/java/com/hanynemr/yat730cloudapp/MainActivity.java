package com.hanynemr.yat730cloudapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class MainActivity extends AppCompatActivity implements AsyncCallback<BackendlessUser> {
    EditText mailText, nameText, passText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mailText = findViewById(R.id.mailText);
        nameText = findViewById(R.id.nameText);
        passText = findViewById(R.id.passText);


    }

    public void register(View view) {
        BackendlessUser user = new BackendlessUser();
        user.setEmail(mailText.getText().toString());
        user.setPassword(passText.getText().toString());
        user.setProperty("name", nameText.getText().toString());

        Backendless.UserService.register(user, this);

    }

    @Override
    public void handleResponse(BackendlessUser response) {
        Toast.makeText(this, "user saved", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void handleFault(BackendlessFault fault) {
        if (fault.getCode().equals("3033"))
            Toast.makeText(this, "user exists", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "error in reg", Toast.LENGTH_SHORT).show();

    }
}