package com.lubdhok.biyeshadi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lubdhok.biyeshadi.Concrete.DatabaseHelper;
import com.lubdhok.biyeshadi.Domain.User;

public class SaveUserActivity extends AppCompatActivity {

    private TextView tvFullName, tvGender, tvAge, tvAddress,
            tvDivision, tvMobile, tvEmail;

    private User user;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_user);

        initViews();
        initObjects();
    }

    private void initObjects() {
        // getting user from intent
        user = (User) getIntent().getSerializableExtra("user");
        setValuesToView();
        databaseHelper = new DatabaseHelper(SaveUserActivity.this);
    }

    private void initViews() {
        tvFullName = findViewById(R.id.tvFullName);
        tvGender = findViewById(R.id.tvGender);
        tvAge = findViewById(R.id.tvAge);
        tvAddress = findViewById(R.id.tvAddress);
        tvDivision = findViewById(R.id.tvDivision);
        tvMobile = findViewById(R.id.tvMobile);
        tvEmail = findViewById(R.id.tvEmail);
    }

    private void setValuesToView() {
        tvFullName.setText("Name: " + user.getUserInfo().getFullName());

        char gender = user.getUserInfo().getGender();
        if (gender == 'M')
            tvGender.setText("Gender: Male");
        else tvGender.setText("Gender: Female");

        tvAge.setText("Age: " + user.getUserInfo().getAge());
        tvAddress.setText("Address: " + user.getUserInfo().getAddress());
        tvDivision.setText("Division: " + user.getUserInfo().getDivision());
        tvMobile.setText("Mobile: " + user.getUserInfo().getMobile());
        tvEmail.setText("E-mail: " + user.getUserInfo().getEmail());
    }

    public void btnFinishListener(View view) {
        databaseHelper.addUser(user);
        Intent intent =new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
    }
}
