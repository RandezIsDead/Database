package com.randeztrying.database.Activities.StartActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.randeztrying.database.Activities.CustomerActivity;
import com.randeztrying.database.Database.Constants;
import com.randeztrying.database.Database.RequestHandler;
import com.randeztrying.database.Helpers.Prefs;
import com.randeztrying.database.Models.Customer;
import com.randeztrying.database.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText editText = findViewById(R.id.enter_phone);
        Button confirm = findViewById(R.id.confirm);

        confirm.setOnClickListener(view -> {
            String phone = editText.getText().toString();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.GET_CUSTOMER_BY_PHONE,
                    response -> {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject object = array.getJSONObject(i);

                                Customer customer = new Customer(
                                        object.getString("id"),
                                        object.getString("type"),
                                        object.getString("fio"),
                                        object.getString("name"),
                                        object.getString("inn"),
                                        object.getString("chief"),
                                        object.getString("phone"),
                                        object.getString("address"),
                                        object.getString("bank"),
                                        object.getString("district"),
                                        object.getString("discont")
                                );
                                Prefs.saveCustomer(getApplicationContext(), customer);

                                Intent intent = new Intent(LoginActivity.this, CustomerActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                overridePendingTransition(R.anim.right_in, R.anim.left_out);
                                finish();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    },
                    System.out::println)
            {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();
                    params.put("phone", phone);
                    return params;
                }
            };
            RequestHandler.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
        });
    }
}