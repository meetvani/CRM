package com.example.crm;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CustomerRegisteration extends AppCompatActivity {

    Spinner stateSpin, citySpin;
    List<String> stateList = new ArrayList<>();
    List<String> cityList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_registeration);

        stateSpin = findViewById(R.id.state);
        citySpin = findViewById(R.id.city);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/fayazara/Indian-Cities-API/master/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Rinterface rinterface = retrofit.create(Rinterface.class);
        Call<object> call = rinterface.getObject();
        call.enqueue(new Callback<object>() {
            @Override
            public void onResponse(Call<object> call, Response<object> response) {
                if (!response.isSuccessful()) {
                    System.out.println("response.code() = " + response.code());
                }

                List<Cities> cities = response.body().getCities();
                for (Cities cities1 : cities) {
                    stateList.add(cities1.getState());
                }
                List<String> filteredStateList = removeDuplicates(stateList);
                Collections.sort(filteredStateList);
                filteredStateList.add(0,"Select State");
                stateSpin.setAdapter(new ArrayAdapter<>(CustomerRegisteration.this, android.R.layout.simple_spinner_dropdown_item, filteredStateList));
                stateSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String state = stateSpin.getSelectedItem().toString();
                        cityList.clear();
                        for (Cities cities1 : cities) {
                            if (cities1.getState().equals(state)) {
                                cityList.add(cities1.getDistrict());
                            }
                        }
                        List<String> filteredCityList = removeDuplicates(cityList);
                        Collections.sort(filteredCityList);
                        filteredCityList.add(0,"Select City");
                        citySpin.setAdapter(new ArrayAdapter<>(CustomerRegisteration.this, android.R.layout.simple_spinner_dropdown_item, filteredCityList));

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

            @Override
            public void onFailure(Call<object> call, Throwable t) {
                System.out.println("t.getMessage() = " + t.getMessage());
            }
        });
    }

    private List<String> removeDuplicates(List<String> stateList) {
        List<String> statesList = new ArrayList<>();
        for (String state : stateList) {
            if (!statesList.contains(state)) {
                statesList.add(state);
            }
        }
        return statesList;
    }
}