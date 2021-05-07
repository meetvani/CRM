package com.example.crm.EmployeeManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.crm.R;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import net.cachapa.expandablelayout.ExpandableLayout;

public class EmployeeRegistrationActvity extends AppCompatActivity {

    Button register;
    Button job, intern;
    ExpandableLayout expandablemycontent, expandableinterncontent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_registration_actvity);

        register = findViewById(R.id.btn_register);
        job = findViewById(R.id.job);
        intern = findViewById(R.id.intern);

        register.setOnClickListener(v -> {
            Intent intent =  new Intent(EmployeeRegistrationActvity.this, EmployeeRegisterSecondActivity.class);
            startActivity(intent);
        });

    }


    public void showmyinformation(View view){
        expandablemycontent = (ExpandableLayout) findViewById(R.id.mycontent);
        expandablemycontent.toggle();
    }

    public void showjobinformation(View view){
        expandableinterncontent = findViewById(R.id.myjobcontent);
        expandableinterncontent.toggle();
    }
}