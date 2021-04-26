package com.example.crm;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crm.citystate.Cities;
import com.example.crm.citystate.Rinterface;
import com.example.crm.citystate.object;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EmployeeRegistration extends AppCompatActivity {
    Spinner stateSpin, citySpin, categoryspin, departmentspin, genderspin, statusspin;
    List<String> stateList = new ArrayList<>();
    List<String> cityList = new ArrayList<>();
    List<String> categoryList = new ArrayList<>();
    List<String> departmentList = new ArrayList<>();
    List<String> genderList = new ArrayList<>();
    List<String> statusList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_registration);
        stateSpin = findViewById(R.id.state);
        citySpin = findViewById(R.id.city);
        categoryspin = findViewById(R.id.empcategory);
        departmentspin = findViewById(R.id.empdept);
        genderspin = findViewById(R.id.gender);
        statusspin = findViewById(R.id.status);
        categoryList.add("Internship");
        categoryList.add(0, "Select Category");
        categoryList.add("Job");
        departmentList.add("Support");
        departmentList.add(0, "Select Department");
        departmentList.add("Documentation");
        departmentList.add("HR");
        departmentList.add("Development");
        departmentList.add("Sales");
        departmentList.add("Marketing");
        genderList.add("Male");
        genderList.add(0, "Select Gender");
        genderList.add("Female");
        genderList.add("Other");
        statusList.add("Active");
        statusList.add(0, "Select Status");
        statusList.add("Inactive");
        categoryspin.setAdapter(new ArrayAdapter<>(EmployeeRegistration.this, android.R.layout.simple_spinner_dropdown_item, categoryList));
        departmentspin.setAdapter(new ArrayAdapter<>(EmployeeRegistration.this, android.R.layout.simple_spinner_dropdown_item, departmentList));
        genderspin.setAdapter(new ArrayAdapter<>(EmployeeRegistration.this, android.R.layout.simple_spinner_dropdown_item, genderList));
        statusspin.setAdapter(new ArrayAdapter<>(EmployeeRegistration.this, android.R.layout.simple_spinner_dropdown_item, statusList));
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
                filteredStateList.add(0, "Select State");
                stateSpin.setAdapter(new ArrayAdapter<>(EmployeeRegistration.this, android.R.layout.simple_spinner_dropdown_item, filteredStateList));
                stateSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String state = stateSpin.getSelectedItem().toString();
                        cityList.clear();
                        for (Cities cities1 : cities) {
                            if (cities1.getState().equals(state)) {
                                cityList.add(cities1.getCity());
                            }
                        }
                        List<String> filteredCityList = removeDuplicates(cityList);
                        Collections.sort(filteredCityList);
                        filteredCityList.add(0, "Select City");
                        citySpin.setAdapter(new ArrayAdapter<>(EmployeeRegistration.this, android.R.layout.simple_spinner_dropdown_item, filteredCityList));

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