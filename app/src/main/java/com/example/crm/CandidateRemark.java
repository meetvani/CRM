package com.example.crm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CandidateRemark extends AppCompatActivity {

    Button btnresume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_remark);

        btnresume = findViewById(R.id.candidate_remark_resume);

        btnresume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CandidateRemark.this, PaySlipFormActivity.class);
                startActivity(intent);
            }
        });

    }
}