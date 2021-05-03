package com.example.crm;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomerDetails extends AppCompatActivity {
    Spinner spinner;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);
        spinner = findViewById(R.id.customer_spinner);
        recyclerView=findViewById(R.id.customer_details_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, new String[]{"Manage Customer", "View Customers"}));

        List<String> stringList=new ArrayList<>();
        stringList.add("1");
        stringList.add("1");
        stringList.add("1");

        recyclerView.setAdapter(new CustomerAdapter(stringList));
    }
}