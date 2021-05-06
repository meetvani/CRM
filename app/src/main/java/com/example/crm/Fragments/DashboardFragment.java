package com.example.crm.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.crm.R;
import com.example.crm.WebmailActivity;

public class DashboardFragment extends Fragment {
CardView webmailcard;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_dashboard, container, false);
        webmailcard=v.findViewById(R.id.webmail);
        webmailcard.setOnClickListener(view -> {
            startActivity(new Intent(getContext(), WebmailActivity.class));
        });
        return v;
    }
}