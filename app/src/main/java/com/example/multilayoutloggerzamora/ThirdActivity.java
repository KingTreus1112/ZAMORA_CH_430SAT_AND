package com.example.multilayoutloggerzamora;


import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Get the submitted data from the Intent
        String name = getIntent().getStringExtra("NAME");
        String address = getIntent().getStringExtra("ADDRESS");
        String birthdate = getIntent().getStringExtra("BIRTHDATE");
        String momsName = getIntent().getStringExtra("MOM_NAME");
        String dadsName = getIntent().getStringExtra("DAD_NAME");

        // Set the values in the respective TextViews
        ((TextView) findViewById(R.id.tvNameValue)).setText(name);
        ((TextView) findViewById(R.id.tvAddressValue)).setText(address);
        ((TextView) findViewById(R.id.tvBirthdateValue)).setText(birthdate);
        ((TextView) findViewById(R.id.tvMomsNameValue)).setText(momsName);
        ((TextView) findViewById(R.id.tvDadsNameValue)).setText(dadsName);
    }
}

