package com.lubdhok.biyeshadi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.lubdhok.biyeshadi.Domain.User;
import com.lubdhok.biyeshadi.Domain.UserInfo;

public class UserInfoActivity extends AppCompatActivity {

    private User user;

    private EditText etFullName, etAge, etAddress, etDivision, etMobile, etEmail;

    private RadioGroup rgGender;

    private char gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        initViews();
        // getting user from intent
        user = (User) getIntent().getSerializableExtra("user");
        initListeners();
    }

    private void initListeners() {
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rbGender = rgGender.findViewById(i);
                if (null != rbGender && i > -1) {
                    String sGender = rbGender.getText().toString();
                    if (sGender.startsWith("M"))
                        gender = 'M';
                    else gender = 'F';
                }
            }
        });
    }

    private void initViews() {
        etFullName = findViewById(R.id.etFullName);
        etAge = findViewById(R.id.etAge);
        etAddress = findViewById(R.id.etAddress);
        etDivision = findViewById(R.id.etDivision);
        etMobile = findViewById(R.id.etMobile);
        etEmail = findViewById(R.id.etEmail);

        rgGender = findViewById(R.id.rgGender);
        rgGender.clearCheck();
    }

    public void btnNextListener(View view) {
        String fullName, address, division, mobile, email;
        int age = 0;

        fullName = etFullName.getText().toString();
        address = etAddress.getText().toString();
        division = etDivision.getText().toString();
        mobile = etMobile.getText().toString();
        email = etEmail.getText().toString();
        try {
            age = Integer.valueOf(etAge.getText().toString());
        }
        catch (Exception e){}

        if (rgGender.getCheckedRadioButtonId() == -1){
            Toast.makeText(getApplicationContext(), "Select gender", Toast.LENGTH_LONG).show();
            return;
        }

        if (fullName.equals("") || address.equals("") || division.equals("")
                || mobile.equals("") || email.equals("") || age == 0){
            Toast.makeText(getApplicationContext(), "Empty field exists", Toast.LENGTH_LONG).show();
            return;
        }
        else {
            UserInfo userInfo = new UserInfo(etFullName.getText().toString(),
                    etAddress.getText().toString(),
                    etDivision.getText().toString(),
                    etMobile.getText().toString(),
                    etEmail.getText().toString(),
                    Integer.valueOf(etAge.getText().toString()),
                    gender);

            user.setUserInfo(userInfo);

            Intent intent = new Intent(getApplicationContext(), SaveUserActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);
        }
    }
}
