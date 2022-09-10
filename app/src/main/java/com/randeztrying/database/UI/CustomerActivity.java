package com.randeztrying.database.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.randeztrying.database.UI.StartActivities.SplashActivity;
import com.randeztrying.database.Helpers.Prefs;
import com.randeztrying.database.Models.Customer;
import com.randeztrying.database.R;

public class CustomerActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        ImageView logout = findViewById(R.id.logout);
        ImageView addDevice = findViewById(R.id.addDevice);
        TextView text = findViewById(R.id.tex);
        Customer customer = Prefs.getCustomer(getApplicationContext());
        if (customer != null) text.setText(customer.getFio() + "\n" + customer.getPhone());

        addDevice.setOnClickListener(view -> {

        });
        logout.setOnClickListener(view -> {
            Prefs.deleteCustomer(getApplicationContext());
            startActivity(new Intent(CustomerActivity.this, SplashActivity.class));
            overridePendingTransition(R.anim.left_in, R.anim.right_out);
            finish();
        });
    }
}