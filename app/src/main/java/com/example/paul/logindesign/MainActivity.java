package com.example.paul.logindesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login;
    int  LOGIN_FLAG = 0;
    int PASSOWRD_FLAG = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.Username);
        password = findViewById(R.id.Password);
        login = findViewById(R.id.Login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String value = username.getText().toString();
                if(TextUtils.isEmpty(value)){
                    username.setError("This field cannot be empty");
                     LOGIN_FLAG = 0;
                }else
                {
                    LOGIN_FLAG = 1;
                }
                final String valuePass = password.getText().toString();
                if(!isValidPassword(valuePass)){
                    password.setError("Password length must be more than 6 characters");
                    PASSOWRD_FLAG = 0;
                }else {
                    PASSOWRD_FLAG = 1;
                }
                if(LOGIN_FLAG == 1 && PASSOWRD_FLAG == 1){
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean isValidPassword(String valuePass) {
        if(valuePass != null && valuePass.length()>6){
            return  true;
        }
    return  false;
    }

}
