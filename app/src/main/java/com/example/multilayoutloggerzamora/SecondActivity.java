package com.example.multilayoutloggerzamora;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityLog";
    private EditText etName, etAddress, etBirthdate, etMomsName, etDadsName;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.v(TAG, "Verbose: App started");
        Log.d(TAG, "Debug: Debugging MainActivity");
        Log.i(TAG, "Info: MainActivity Loaded");
        Log.w(TAG, "Warning: Potential issue detected");
        Log.e(TAG, "Error: Example error message");

        String email = getIntent().getStringExtra("EMAIL");

        TextView tvWelcome = findViewById(R.id.tvWelcomeMessage);
        String welcomeMessage = String.format(getString(R.string.welcome_user), email);
        tvWelcome.setText(welcomeMessage);



        // Initialize input fields
        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etBirthdate = findViewById(R.id.etBirthdate);
        etMomsName = findViewById(R.id.etMomsName);
        etDadsName = findViewById(R.id.etDadsName);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Submit Button Click Listener
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String address = etAddress.getText().toString().trim();
                String birthdate = etBirthdate.getText().toString().trim();
                String momsName = etMomsName.getText().toString().trim();
                String dadsName = etDadsName.getText().toString().trim();

                if (name.isEmpty() || address.isEmpty() || birthdate.isEmpty() || momsName.isEmpty() || dadsName.isEmpty()) {
                    Toast.makeText(SecondActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Navigate to ThirdActivity and pass all data
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    intent.putExtra("NAME", name);
                    intent.putExtra("ADDRESS", address);
                    intent.putExtra("BIRTHDATE", birthdate);
                    intent.putExtra("MOM_NAME", momsName);
                    intent.putExtra("DAD_NAME", dadsName);
                    startActivity(intent);
                }
            }
        });


    }
}
