package com.example.crm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.crm.Fragments.ArchieveFragment;
import com.example.crm.Fragments.DraftFragment;
import com.example.crm.Fragments.InboxFragment;
import com.example.crm.Fragments.JunkFragment;
import com.example.crm.Fragments.TrashFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WebmailActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webmail);
        bottomNavigationView=findViewById(R.id.bottomnav);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame1, new InboxFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

    }
    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;

            switch (item.getItemId()) {

                case R.id.inbox:
                    selectedFragment = new InboxFragment();
                    break;

                case R.id.draft:
                    selectedFragment = new DraftFragment();
                    break;

                case R.id.trash:
                   selectedFragment = new TrashFragment();
                    break;
                case R.id.junk:
                    selectedFragment= new JunkFragment();
                    break;
                case R.id.archieve:
                    selectedFragment=new ArchieveFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.frame1, selectedFragment).commit();

            return true;
        }
    };

}