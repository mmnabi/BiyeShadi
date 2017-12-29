package com.lubdhok.biyeshadi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnLogIn, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
    }

    private void initListeners() {
        btnLogIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
    }

    private void initViews() {
        btnLogIn = findViewById(R.id.btnLogIn);
        btnSignUp = findViewById(R.id.btnSignUp);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogIn:
                // Load login activity
                break;

            case R.id.btnSignUp:
                // Load sign up activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
                break;
        }
    }
}
