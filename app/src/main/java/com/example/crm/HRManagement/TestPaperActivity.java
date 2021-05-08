package com.example.crm.HRManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.crm.R;

public class TestPaperActivity extends AppCompatActivity {

    Button btn_done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_paper);

        btn_done = findViewById(R.id.test_done_btn);

        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestPaperActivity.this, TestPaperRespondActivity.class);
                startActivity(intent);
            }
        });

    }
}