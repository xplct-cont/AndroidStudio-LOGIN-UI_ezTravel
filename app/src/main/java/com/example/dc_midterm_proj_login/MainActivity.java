package com.example.dc_midterm_proj_login;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    public EditText email, password;
    public MaterialButton loginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginBtn = (MaterialButton) findViewById(R.id.loginBtn);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText email = (EditText) findViewById(R.id.email);
                EditText password = (EditText) findViewById(R.id.password);

                checkDataEntered();
            }
        });
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        if (isEmpty(email)) {
            Toast t = Toast.makeText(this, "You must enter email to login!", Toast.LENGTH_SHORT);
            t.show();

        }else if (isEmpty(password)){
            Toast t = Toast.makeText(this, "You must enter password to login!", Toast.LENGTH_SHORT);
            t.show();

        }else
           openLogIn();

    }

    public void openLogIn() {
        Intent intent = new Intent(this, LogIn.class);
        startActivity(intent);

    }

}
  





