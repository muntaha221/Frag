package com.example.task2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Load Signup Fragment as default
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new SignupFragment())
                .commit();
    }
}