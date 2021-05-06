package com.example.crm.EmployeeManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.crm.R;

public class EmployeeRegistrationActvity extends AppCompatActivity {

    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_registration_actvity);

        register = findViewById(R.id.btn_register);

        register.setOnClickListener(v -> {
            Intent intent =  new Intent(EmployeeRegistrationActvity.this, EmployeeRegisterSecondActivity.class);
            startActivity(intent);
        });

    }
}