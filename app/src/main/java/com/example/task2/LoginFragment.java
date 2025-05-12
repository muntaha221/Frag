package com.example.task2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        Button btnGoToSignup = view.findViewById(R.id.btnGoToSignup);
        Button btnGoToForgot = view.findViewById(R.id.btnGoToForgot);

        btnGoToSignup.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new SignupFragment())
                    .addToBackStack(null)
                    .commit();
        });

        btnGoToForgot.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ForgotPasswordFragment())
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }
}

//package com.example.task2;
//
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Toast;
//
//import androidx.fragment.app.Fragment;
//
//import com.google.android.material.button.MaterialButton;
//import com.google.android.material.textfield.TextInputEditText;
//
//public class ForgotPasswordFragment extends Fragment {
//
//    private TextInputEditText etOldPassword;
//    private TextInputEditText etNewPassword;
//    private MaterialButton btnResetPassword;
//    private MaterialButton btnBackToLogin;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_forgot_password, container, false);
//
//        // Initialize UI components
//        etOldPassword = view.findViewById(R.id.OldPassword);
//        etNewPassword = view.findViewById(R.id.etNewPassword);
//        btnResetPassword = view.findViewById(R.id.btnResetPassword);
//        btnBackToLogin = view.findViewById(R.id.btnBackToLogin);
//
//        // Set click listener for Reset Password button
//        btnResetPassword.setOnClickListener(v -> {
//            String oldPassword = etOldPassword.getText().toString().trim();
//            String newPassword = etNewPassword.getText().toString().trim();
//
//            if (validateInputs(oldPassword, newPassword)) {
//                // Implement password reset logic here
//                resetPassword(oldPassword, newPassword);
//            }
//        });
//
//        // Set click listener for Back to Login button
//        btnBackToLogin.setOnClickListener(v -> {
//            getParentFragmentManager().beginTransaction()
//                    .replace(R.id.fragment_container, new LoginFragment())
//                    .commit();
//        });
//
//        return view;
//    }
//
//    private boolean validateInputs(String oldPassword, String newPassword) {
//        if (TextUtils.isEmpty(oldPassword)) {
//            etOldPassword.setError("Old password is required");
//            return false;
//        }
//
//        if (TextUtils.isEmpty(newPassword)) {
//            etNewPassword.setError("New password is required");
//            return false;
//        }
//
//        if (oldPassword.equals(newPassword)) {
//            etNewPassword.setError("New password must be different from old password");
//            return false;
//        }
//
//        // You can add more password validation rules here (e.g., minimum length, special characters)
//
//        return true;
//    }
//
//    private void resetPassword(String oldPassword, String newPassword) {
//        // Implement actual password reset logic here
//        // This would typically involve API calls to your backend
//
//        // For demonstration purposes, just show a toast message
//        Toast.makeText(getContext(), "Password reset successfully!", Toast.LENGTH_SHORT).show();
//
//        // Navigate back to login screen after successful password reset
//        getParentFragmentManager().beginTransaction()
//                .replace(R.id.fragment_container, new LoginFragment())
//                .commit();
//    }
//}