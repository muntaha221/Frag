package com.example.task2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

public class ForgotPasswordFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forgot_password, container, false);

        Button btnBackToLogin = view.findViewById(R.id.btnBackToLogin);
        btnBackToLogin.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new LoginFragment())
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }
}