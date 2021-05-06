package com.example.crm.EmployeeManagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

import com.example.crm.R;

public class EmployeeDepartmentActivity extends AppCompatActivity {

    CardView hrm_card, development_card, sales_card, digital_marketing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_department);

        hrm_card = findViewById(R.id.hrm);
        development_card = findViewById(R.id.development);
        sales_card = findViewById(R.id.sales);
        digital_marketing = findViewById(R.id.digital_marketing);

        hrm_card.setOnClickListener(v -> {
            Intent intent = new Intent(EmployeeDepartmentActivity.this, HRMEmployeeDetailsActivity.class);
            startActivity(intent);
        });

        development_card.setOnClickListener(v -> {
            Intent intent = new Intent(EmployeeDepartmentActivity.this, DevelopmentEmployeeDetailsActivity.class);
            startActivity(intent);
        });

        digital_marketing.setOnClickListener(v -> {
            Intent intent = new Intent(EmployeeDepartmentActivity.this, DigitalMarketingEmployeeDetailsActivity.class);
            startActivity(intent);
        });

        sales_card.setOnClickListener(v -> {
            Intent intent = new Intent(EmployeeDepartmentActivity.this, SalesEmployeeDetailsActivity.class);
            startActivity(intent);
        });
    }
}