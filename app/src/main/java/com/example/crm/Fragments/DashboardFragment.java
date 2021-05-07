package com.example.crm.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.crm.EmployeeManagement.EmployeeDashboardActivity;
import com.example.crm.LeaveManagementActivity;
import com.example.crm.R;
import com.example.crm.WebmailActivity;

public class DashboardFragment extends Fragment {
CardView webmailcard;

    CardView employee_cardView, leave_card;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);

        employee_cardView = v.findViewById(R.id.employee);
        webmailcard=v.findViewById(R.id.webmail);
        leave_card = v.findViewById(R.id.leavemanagement);

        leave_card.setOnClickListener(v1 -> {
            Intent intent = new Intent(getContext(), LeaveManagementActivity.class);
            startActivity(intent);
        });

        webmailcard.setOnClickListener(view -> {
            startActivity(new Intent(getContext(), WebmailActivity.class));
        });

        employee_cardView.setOnClickListener(v12 -> {
            Intent intent  = new Intent(getContext(), EmployeeDashboardActivity.class);
            startActivity(intent);
        });

        return v;

    }
}