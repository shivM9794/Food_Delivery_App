package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class SignUpActivity extends AppCompatActivity {

    EditText etUsername,etMobile,etEmail,etPassword,etCnfPassword;
    AwesomeValidation awesomeValidation;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

//        etUsername = findViewById(R.id.layoutUsername);
//        etMobile = findViewById(R.id.layoutPhone);
//        etEmail = findViewById(R.id.layoutEmailId);
//        etPassword =findViewById(R.id.layoutPassword);
//        etCnfPassword = findViewById(R.id.layoutCnfPassword);
//
//        //Initialize Validation
//
//        awesomeValidation =new AwesomeValidation(ValidationStyle.BASIC);
//
//        //Add Validation for username
//
//        awesomeValidation.addValidation(this,R.id.layoutUsername, RegexTemplate.NOT_EMPTY,R.string.invalid_name);
//        awesomeValidation.addValidation(this,R.id.layoutEmailId, Patterns.EMAIL_ADDRESS,R.string.invalid_email);





        findViewById(R.id.imageBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        findViewById(R.id.textSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        findViewById(R.id.btn_sign_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignInActivity.class));
                finish();
            }
        });

    }
}