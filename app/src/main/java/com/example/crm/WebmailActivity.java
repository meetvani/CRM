package com.example.crm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.crm.Fragments.ArchieveFragment;
import com.example.crm.Fragments.CalendarFragment;
import com.example.crm.Fragments.ContactFragment;
import com.example.crm.Fragments.DraftFragment;
import com.example.crm.Fragments.InboxFragment;
import com.example.crm.Fragments.JunkFragment;
import com.example.crm.Fragments.SettingsFragment;
import com.example.crm.Fragments.TrashFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class WebmailActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
FloatingActionButton floatingActionButton;
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webmail);
        toolbar=findViewById(R.id.tool);
        floatingActionButton=findViewById(R.id.composebutton);
        floatingActionButton.setOnClickListener(view -> {
            startActivity(new Intent(WebmailActivity.this,WebmailCompose.class));
        });
        setSupportActionBar(toolbar);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.contact:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame1, new ContactFragment()).commit();
                break;
            case R.id.calendar:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame1, new CalendarFragment()).commit();
                break;
            case R.id.settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame1, new SettingsFragment()).commit();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}