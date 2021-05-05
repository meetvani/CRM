package com.example.crm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EmployeeDashboardActivity extends AppCompatActivity {

    CardView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_dashboard);

        register = findViewById(R.id.employee_register);

        register.setOnClickListener(v -> {
            Intent intent = new Intent(EmployeeDashboardActivity.this, EmployeeRegistrationActvity.class);
            startActivity(intent);
        });

    }
}