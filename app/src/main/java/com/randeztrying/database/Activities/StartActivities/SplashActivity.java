package com.randeztrying.database.Activities.StartActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.randeztrying.database.Activities.CustomerActivity;
import com.randeztrying.database.Activities.MasterActivity;
import com.randeztrying.database.Helpers.Prefs;
import com.randeztrying.database.Models.Customer;
import com.randeztrying.database.Models.Master;
import com.randeztrying.database.R;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    private TextView signIn;
    private TextView signUp;

    @Override
    protected void onStart() {
        super.onStart();
        Customer customer = Prefs.getCustomer(getApplicationContext());
        Master master = Prefs.getMaster(getApplicationContext());
        if (customer != null) {
            Intent intent = new Intent(SplashActivity.this, CustomerActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
            finish();
        }
        if (master != null) {
            Intent intent = new Intent(SplashActivity.this, MasterActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        signIn = findViewById(R.id.sign_in);
        signUp = findViewById(R.id.sign_up);

        signIn.setOnClickListener(view -> {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
        });
        signUp.setOnClickListener(view -> {
            startActivity(new Intent(SplashActivity.this, RegisterActivity.class));
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
        });
    }
}