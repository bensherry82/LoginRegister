package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText username, password, dob, firstname, lastname, email;
    Button register, cancel;

    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        email = findViewById(R.id.email);
        dob = findViewById(R.id.dob);
        register = findViewById(R.id.register);
        cancel = findViewById(R.id.cancel);

        preferences = getSharedPreferences("Userinfo", 0 );


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                String dobValue = dob.getText().toString();
                String firstnameValue = firstname.getText().toString();
                String lastnameValue = lastname.getText().toString();
                String emailValue = email.getText().toString();

           //     if (usernameValue.length()>1) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username", usernameValue);
                    editor.putString("password", passwordValue);
                    editor.putString("dob", dobValue);
                    editor.putString("firstname", firstnameValue);
                    editor.putString("lastname", lastnameValue);
                    editor.putString("email", emailValue);
                    editor.apply();
                    Toast.makeText(RegisterActivity.this, "User Registered!", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
             //   }
               // else {
               //     Toast.makeText(RegisterActivity.this, "Please fill out all fields!", Toast.LENGTH_LONG).show();
               // }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emptyField();
            }
        });


    }
    public void emptyField(){
        username.setText("");
        password.setText("");
        dob.setText("");
        firstname.setText("");
        lastname.setText("");
        email.setText("");
    }
}