package com.randeztrying.database.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.randeztrying.database.Activities.StartActivities.SplashActivity;
import com.randeztrying.database.Helpers.Prefs;
import com.randeztrying.database.Models.Master;
import com.randeztrying.database.R;

public class MasterActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        ImageView logout = findViewById(R.id.logout);
        TextView text = findViewById(R.id.tex);
        Master master = Prefs.getMaster(getApplicationContext());
        if (master != null) {
            float defect = Integer.parseInt(master.getDefect());
            float repairAll = Integer.parseInt(master.getRepairAll());
            text.setText(master.getFio() + "\nРейтинг: " + (Math.round(100 - ((defect / repairAll) * 100))) + "%");
        }

        logout.setOnClickListener(view -> {
            Prefs.deleteMaster(getApplicationContext());
            startActivity(new Intent(MasterActivity.this, SplashActivity.class));
            overridePendingTransition(R.anim.left_in, R.anim.right_out);
            finish();
        });
    }
}