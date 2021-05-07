package com.example.crm.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.crm.AttendanceActivity;
import com.example.crm.EmployeeManagement.EmployeeDashboardActivity;
import com.example.crm.R;
import com.example.crm.WebmailActivity;

public class DashboardFragment extends Fragment {
CardView webmailcard;

    CardView cardView,attendancecard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);

        cardView = v.findViewById(R.id.employee);
        attendancecard=v.findViewById(R.id.attendance);
        webmailcard=v.findViewById(R.id.webmail);
        attendancecard.setOnClickListener(view -> {
            startActivity(new Intent(getContext(), AttendanceActivity.class));
        });
        webmailcard.setOnClickListener(view -> {
            startActivity(new Intent(getContext(), WebmailActivity.class));
        });
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getContext(), EmployeeDashboardActivity.class);
                startActivity(intent);
            }
        });

        return v;

    }
}