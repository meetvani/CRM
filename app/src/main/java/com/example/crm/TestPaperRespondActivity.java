package com.example.crm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TestPaperRespondActivity extends AppCompatActivity {

    TextView summery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_paper_respond);

        summery = findViewById(R.id.summery);

        summery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestPaperRespondActivity.this, TestPaperSummerActivity.class);
                startActivity(intent);
            }
        });

    }
}