package com.example.crm.SalesManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.crm.R;

public class SalesLoginActivity extends AppCompatActivity {

    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_login);

        login = findViewById(R.id.login);

        login.setOnClickListener(v -> startActivity(new Intent(SalesLoginActivity.this, SalesMainActivity.class)));
    }
}