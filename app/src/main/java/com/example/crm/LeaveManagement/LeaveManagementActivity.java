package com.example.crm.LeaveManagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.crm.R;

public class LeaveManagementActivity extends AppCompatActivity {

    CardView btn_accept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_management);

        btn_accept = findViewById(R.id.accept);

        btn_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LeaveManagementActivity.this, LeaveDetailsActivity.class));
            }
        });
    }
}