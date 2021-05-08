package com.example.crm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crm.CRMManagement.CustomerDetails;

import java.util.ArrayList;
import java.util.List;

public class CustomersDetails extends AppCompatActivity {
    Spinner spinner;
    RecyclerView recyclerView;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers_details);

        cardView = findViewById(R.id.card);
        spinner = findViewById(R.id.customer_spinner);
//        recyclerView=findViewById(R.id.customer_details_recycler);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cardView.setOnClickListener(v -> startActivity(new Intent(CustomersDetails.this, CustomerDetails.class)));

        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, new String[]{"Manage Customer", "View Customers"}));

        List<String> stringList=new ArrayList<>();
        stringList.add("1");
        stringList.add("1");
        stringList.add("1");

//        recyclerView.setAdapter(new CustomerAdapter(stringList));
    }
}