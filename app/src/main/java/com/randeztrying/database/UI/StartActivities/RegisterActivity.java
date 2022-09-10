package com.randeztrying.database.UI.StartActivities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.randeztrying.database.UI.Adapters.RegisterAdapter;
import com.randeztrying.database.R;

public class RegisterActivity extends AppCompatActivity {

    private Button fiz, ur, mas;
    private RelativeLayout asFiz, asUr, asMaster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fiz = findViewById(R.id.fiz);
        ur = findViewById(R.id.ur);
        mas = findViewById(R.id.master);
        asUr = findViewById(R.id.as_ur);
        asFiz = findViewById(R.id.as_fiz);
        asMaster = findViewById(R.id.as_master);
        asFiz.setVisibility(View.VISIBLE);

        RecyclerView recyclerViewFiz = findViewById(R.id.rec_view_fiz);
        recyclerViewFiz.setHasFixedSize(true);
        recyclerViewFiz.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        RegisterAdapter adapter = new RegisterAdapter(getApplicationContext(), 0);
        recyclerViewFiz.setAdapter(adapter);

        fiz.setOnClickListener(view -> loginAsFizFace());
        ur.setOnClickListener(view -> loginAsUrFace());
        mas.setOnClickListener(view -> loginAsMaster());
    }

    private void loginAsMaster() {
        mas.setBackgroundResource(R.drawable.top_button_bg);
        fiz.setBackgroundResource(0);
        ur.setBackgroundResource(0);

        asFiz.setVisibility(View.GONE);
        asUr.setVisibility(View.GONE);
        asMaster.setVisibility(View.VISIBLE);

        RecyclerView recyclerView = findViewById(R.id.rec_view_master);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        RegisterAdapter adapter = new RegisterAdapter(getApplicationContext(), 2);
        recyclerView.setAdapter(adapter);
    }

    private void loginAsUrFace() {
        ur.setBackgroundResource(R.drawable.top_button_bg);
        fiz.setBackgroundResource(0);
        mas.setBackgroundResource(0);

        asMaster.setVisibility(View.GONE);
        asFiz.setVisibility(View.GONE);
        asUr.setVisibility(View.VISIBLE);

        RecyclerView recyclerView = findViewById(R.id.rec_view_ur);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        RegisterAdapter adapter = new RegisterAdapter(getApplicationContext(), 1);
        recyclerView.setAdapter(adapter);
    }

    private void loginAsFizFace() {
        fiz.setBackgroundResource(R.drawable.top_button_bg);
        ur.setBackgroundResource(0);
        mas.setBackgroundResource(0);

        asMaster.setVisibility(View.GONE);
        asUr.setVisibility(View.GONE);
        asFiz.setVisibility(View.VISIBLE);

        RecyclerView recyclerView = findViewById(R.id.rec_view_fiz);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        RegisterAdapter adapter = new RegisterAdapter(getApplicationContext(), 0);
        recyclerView.setAdapter(adapter);
    }
}