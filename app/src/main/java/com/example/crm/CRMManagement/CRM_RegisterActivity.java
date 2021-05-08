package com.example.crm.CRMManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.crm.CustomerRegisteration;
import com.example.crm.CustomersDetails;
import com.example.crm.EmployeeRegistration;
import com.example.crm.R;
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

public class CRM_RegisterActivity extends AppCompatActivity {

    Spinner stateSpin, citySpin, domainSpin, subDomainSpin, taskSpin, genderSpin;
    List<String> stateList = new ArrayList<>();
    List<String> cityList = new ArrayList<>();
    String[] cit;
    String[] adword;
    String[] lead_management;
    String[] selected_subDomain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_r_m__register);

        stateSpin = findViewById(R.id.state);
        citySpin = findViewById(R.id.city);
        domainSpin = findViewById(R.id.domain);
        subDomainSpin = findViewById(R.id.sub_domain);
        taskSpin = findViewById(R.id.tasks);
        genderSpin = findViewById(R.id.gender);
        Button button = findViewById(R.id.cust_reg);

        String[] domain = {"Choose Domain", "COMPLETE IT SOLUTION", "ADWORD", "LEAD MANAGEMENT"};
        cit = new String[]{"Choose Sub Domain", "Domain", "Hosting", "Static Web Development", "Dynamic Web Development", "Web Portals", "E-Commerce Solution", "Graphic Design", "App Solution Android/IOS/Windows", "SEO", "SMO"};
        adword = new String[]{"Choose Sub Domain", "Television", "Airline/Airport", "Cinema", "Digital", "Magazine", "Newspaper", "Outdoor", "Radio", "Non-Traditional"};
        lead_management = new String[]{"Choose Sub Domain", "Interactive Voice Response (IVR)", "Toll Free Service", "Missed Call Service", "Bulk SMS", "Bulk Emails", "Call Conferencing", "Bulk Voice Call", "Call Center Solution", "Whatsapp Marketing"};

        button.setOnClickListener(view -> {
            startActivity(new Intent(CRM_RegisterActivity.this, CustomersDetails.class));
        });

        domainSpin.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, domain));
        domainSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_subDomain = new String[]{"Select SubDomain"};
                if (position == 1)
                    selected_subDomain = cit;
                if (position == 2)
                    selected_subDomain = adword;
                if (position == 3)
                    selected_subDomain = lead_management;
                subDomainSpin.setAdapter(new ArrayAdapter<>(CRM_RegisterActivity.this, android.R.layout.simple_spinner_dropdown_item, selected_subDomain));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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
                stateSpin.setAdapter(new ArrayAdapter<>(CRM_RegisterActivity.this, android.R.layout.simple_spinner_dropdown_item, filteredStateList));
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
                        citySpin.setAdapter(new ArrayAdapter<>(CRM_RegisterActivity.this, android.R.layout.simple_spinner_dropdown_item, filteredCityList));

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
//        List<String> tasks = Arrays.asList(getResources().getStringArray(R.array.tasks));
//        taskSpin.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tasks));
        genderSpin.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, new String[]{"Male", "Female", "Other"}));
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