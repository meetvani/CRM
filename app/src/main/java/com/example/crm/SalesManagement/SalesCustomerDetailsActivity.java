package com.example.crm.SalesManagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.crm.R;

public class SalesCustomerDetailsActivity extends AppCompatActivity {

    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_customer_details);

        cardView = findViewById(R.id.card);

        cardView.setOnClickListener(v -> startActivity(new Intent(SalesCustomerDetailsActivity.this, UpcomingSalesActivity.class)));

    }
}