package com.example.crm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=findViewById(R.id.login_button);

        login.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this,HomeActivity.class)));
    }
}