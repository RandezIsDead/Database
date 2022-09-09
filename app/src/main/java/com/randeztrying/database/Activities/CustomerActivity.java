package com.randeztrying.database.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.randeztrying.database.Helpers.Prefs;
import com.randeztrying.database.Models.Customer;
import com.randeztrying.database.R;

public class CustomerActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView logout = findViewById(R.id.logout);
        TextView text = findViewById(R.id.tex);
        Customer customer = Prefs.getCustomer(getApplicationContext());
        if (customer != null) text.setText(customer.getFio() + "\n" + customer.getPhone());

        logout.setOnClickListener(view -> {
            Prefs.deleteCustomer(getApplicationContext());
            startActivity(new Intent(CustomerActivity.this, LoginActivity.class));
            finish();
        });
    }
}