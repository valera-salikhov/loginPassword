package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    TextView success;
    EditText ed_login, ed_password;
    Button button1;

    private boolean equals(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        success = findViewById(R.id.success);
        ed_login = findViewById(R.id.EmailAdress);
        ed_password = findViewById(R.id.Password);
        button1 = findViewById(R.id.button1);
        StringBuilder login = new StringBuilder("1");
        StringBuilder password = new StringBuilder("1");
        button1.setOnClickListener(v -> {
            String emailAdress = ed_login.getText().toString();
            String password_ed = ed_password.getText().toString();
            if (equals(emailAdress, login.toString())) {
                if (equals(password_ed, password.toString())) {
                    success.setText(R.string.successful);
                } else {
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    startActivityForResult(i, 1);
                    String new_login = getIntent().getStringExtra("new_login");
                    String new_password = getIntent().getStringExtra("new_password");
                    int right_l = login.length();
                    int right_p = password.length();
                    login.delete(0, right_l);
                    login.append(new_login);
                    password.delete(0, right_p);
                    password.append(new_password);
                }
            } else {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivityForResult(i, 1);
                String new_login = getIntent().getStringExtra("new_login");
                String new_password = getIntent().getStringExtra("new_password");
                int right_l = login.length();
                int right_p = password.length();
                login.delete(0, right_l);
                login.append(new_login);
                password.delete(0, right_p);
                password.append(new_password);
            }
        });
    }
}