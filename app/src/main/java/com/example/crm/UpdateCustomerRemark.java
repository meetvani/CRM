package com.example.crm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crm.CRMManagement.CustomersDetails;

public class UpdateCustomerRemark extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_customer_remark);
        button = findViewById(R.id.update_customer);

        Spinner spinner = findViewById(R.id.priority);
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, new String[]{"Priority", "Low", "High", "Critical", "Emergency"}));

        button.setOnClickListener(v -> startActivity(new Intent(UpdateCustomerRemark.this, CustomersDetails.class)));

    }
}