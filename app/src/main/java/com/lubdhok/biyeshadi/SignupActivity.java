package com.lubdhok.biyeshadi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.lubdhok.biyeshadi.Domain.User;

public class SignupActivity extends AppCompatActivity {

    private EditText etUsername, etPassword, etConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initViews();
    }

    private void initViews() {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
    }

    public void btnNextListener(View view) {
        String username, password, confirmPassword;

        username = etUsername.getText().toString();
        password = etPassword.getText().toString();
        confirmPassword = etConfirmPassword.getText().toString();

        // check if any of the fields are empty
        if (username.equals("") || password.equals("") || confirmPassword.equals("")) {
            Toast.makeText(getApplicationContext(), "Empty field exists", Toast.LENGTH_LONG).show();
            return;
        }

        // check if both password matches
        if (!password.equals(confirmPassword)) {
            Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
            return;
        } else {
            // Save the Data in User
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);

            Intent intent = new Intent(getApplicationContext(), UserInfoActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);
        }

    }
}
