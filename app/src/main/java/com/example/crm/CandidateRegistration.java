package com.example.crm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CandidateRegistration extends AppCompatActivity  {

    EditText name, phone, alt_phone, personal_email, official_email, source, address;
    Spinner city, state;
    Button btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_registration);

        name = findViewById(R.id.candidate_name);
        phone = findViewById(R.id.candidate_phone);
        alt_phone = findViewById(R.id.candidate_alt_phone);
        personal_email = findViewById(R.id.candidate_personal_email);
        official_email = findViewById(R.id.candidate_official_email);
        source = findViewById(R.id.candidate_source);
        address = findViewById(R.id.candidate_address);
        btn_update = findViewById(R.id.candidate_resume);

        city = findViewById(R.id.candidate_city);
        state = findViewById(R.id.candidate_state);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Spinner_items_city, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        city.setAdapter(adapter);

        ArrayAdapter<CharSequence> stateadapter = ArrayAdapter.createFromResource(this, R.array.Spinner_items_state, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state.setAdapter(stateadapter);

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CandidateRegistration.this, CandidateRemark.class);
                startActivity(intent);
            }
        });

    }

}