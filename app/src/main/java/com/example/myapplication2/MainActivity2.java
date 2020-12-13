package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    EditText ed_new_login, ed_new_password;
    Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ed_new_login = findViewById(R.id.CreateEmailAdress);
        ed_new_password = findViewById(R.id.CreatePassword);
        create = findViewById(R.id.button2);
        create.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity2.this, MainActivity.class);
            i.putExtra("new_login", ed_new_login.toString());
            i.putExtra("new_password", ed_new_password.toString());
            setResult(1, i);
            finish();
        });
    }
}