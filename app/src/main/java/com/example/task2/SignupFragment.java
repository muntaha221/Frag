package com.example.task2;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.fragment.app.Fragment;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Pattern;

public class SignupFragment extends Fragment {

    EditText etName, etUsername, etEmail, etDob, etPassword;
    Button btnSignup, btnGoToLogin;
    Calendar calendar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        etName = view.findViewById(R.id.etName);
        etUsername = view.findViewById(R.id.etUsername);
        etEmail = view.findViewById(R.id.etEmail);
        etDob = view.findViewById(R.id.etDob);
        etPassword = view.findViewById(R.id.etPassword);
        btnSignup = view.findViewById(R.id.btnSignup);
        btnGoToLogin = view.findViewById(R.id.btnGoToLogin);

        calendar = Calendar.getInstance();

        // Show DatePickerDialog
        etDob.setOnClickListener(v -> {
            DatePickerDialog datePicker = new DatePickerDialog(getContext(),
                    (view1, year, month, dayOfMonth) -> {
                        calendar.set(year, month, dayOfMonth);
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
                        etDob.setText(sdf.format(calendar.getTime()));
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH));
            datePicker.show();
        });

        btnSignup.setOnClickListener(v -> validateInputs());

        btnGoToLogin.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new LoginFragment())
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }

    private void validateInputs() {
        String name = etName.getText().toString().trim();
        String username = etUsername.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String dob = etDob.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (TextUtils.isEmpty(name) || !name.matches("^[a-zA-Z ]+$")) {
            etName.setError("Name must not contain numbers.");
            return;
        }

        if (TextUtils.isEmpty(username)) {
            etUsername.setError("Username required.");
            return;
        }

        if (TextUtils.isEmpty(email) || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Enter a valid email address.");
            return;
        }

        if (TextUtils.isEmpty(dob)) {
            etDob.setError("Date of Birth required.");
            return;
        }

        if (!isValidPassword(password)) {
            etPassword.setError("Password must be at least 8 characters and include uppercase, lowercase, number, and special character.");
            return;
        }

        Toast.makeText(getContext(), "Signup successful (UI only)", Toast.LENGTH_SHORT).show();
    }

    private boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
        return pattern.matcher(password).matches();
    }
}