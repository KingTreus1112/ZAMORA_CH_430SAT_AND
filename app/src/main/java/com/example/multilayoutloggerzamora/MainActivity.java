package com.example.multilayoutloggerzamora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityLog";
    private EditText etEmail, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(TAG, "Verbose: App started");
        Log.d(TAG, "Debug: Debugging MainActivity");
        Log.i(TAG, "Info: MainActivity Loaded");
        Log.w(TAG, "Warning: Potential issue detected");
        Log.e(TAG, "Error: Example error message");



        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, getString(R.string.error_empty_fields), Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("EMAIL", email);
                    startActivity(intent);
                }
            }
        });
    }
}
