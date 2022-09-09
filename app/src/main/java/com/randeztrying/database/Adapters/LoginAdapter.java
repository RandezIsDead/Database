package com.randeztrying.database.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.randeztrying.database.Activities.CustomerActivity;
import com.randeztrying.database.Activities.MasterActivity;
import com.randeztrying.database.Database.Constants;
import com.randeztrying.database.Database.RequestHandler;
import com.randeztrying.database.Helpers.Prefs;
import com.randeztrying.database.Models.Customer;
import com.randeztrying.database.Models.Master;
import com.randeztrying.database.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginAdapter extends RecyclerView.Adapter<LoginAdapter.ViewHolder> {

    private final Context context;
    private final int enterId;
    private final List<String> fields;
    private final List<ViewHolder> viewHolders;

    public LoginAdapter(Context context, int enterId) {
        this.context = context;
        this.enterId = enterId;
        this.fields = new ArrayList<>();
        this.viewHolders = new ArrayList<>();

        if (enterId == 0) {
            fields.add("ФИО *");
            fields.add("Номер телефона *");
            fields.add("Адрес *");
            fields.add("Район проживания *");
            fields.add("Номер дисконтной карты");
            fields.add("conf");
        } else if (enterId == 1) {
            fields.add("Название компании *");
            fields.add("ИНН *");
            fields.add("ФИО Руководителя *");
            fields.add("Номер телефона *");
            fields.add("Адрес *");
            fields.add("Банк *");
            fields.add("Район нахождения компании *");
            fields.add("Номер дисконтной карты");
            fields.add("conf");
        } else {
            fields.add("ФИО *");
            fields.add("Опыт работы *");
            fields.add("Число некачественных ремонтов *");
            fields.add("Число отремонтированных изделий *");
            fields.add("conf");
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder holder;
        if (viewType == 0) holder = new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_enter_field, parent, false));
        else holder = new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_confirm_button, parent, false));
        viewHolders.add(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position != fields.size() - 1) holder.text.setText(fields.get(position));
        else {
            if (enterId != 2) {
                holder.confirm.setOnClickListener(view -> {
                    Customer customer = new Customer();
                    customer.setId(String.valueOf(System.currentTimeMillis()));
                    if (enterId == 0) {
                        customer.setType("fiz");
                        customer.setFio(viewHolders.get(0).enter.getText().toString());
                        customer.setPhone(viewHolders.get(1).enter.getText().toString());
                        customer.setAddress(viewHolders.get(2).enter.getText().toString());
                        customer.setDistrict(viewHolders.get(3).enter.getText().toString());
                        customer.setDiscont(viewHolders.get(4).enter.getText().toString());
                    } else {
                        customer.setType("ur");
                        customer.setName(viewHolders.get(0).enter.getText().toString());
                        customer.setInn(viewHolders.get(1).enter.getText().toString());
                        customer.setChief(viewHolders.get(2).enter.getText().toString());
                        customer.setPhone(viewHolders.get(3).enter.getText().toString());
                        customer.setAddress(viewHolders.get(4).enter.getText().toString());
                        customer.setBank(viewHolders.get(5).enter.getText().toString());
                        customer.setDistrict(viewHolders.get(6).enter.getText().toString());
                        customer.setDiscont(viewHolders.get(7).enter.getText().toString());
                    }
                    Prefs.saveCustomer(context, customer);

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.ADD_CUSTOMER,
                            response -> {
                                Intent intent = new Intent(context, CustomerActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                context.startActivity(intent);
//                                ((Activity) context).overridePendingTransition(R.anim.right_in, R.anim.left_out);
//                                ((Activity) context).finish();
                            },
                            System.out::println)
                    {
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<>();
                            params.put("id", customer.getId());
                            params.put("type", customer.getType());
                            params.put("fio", customer.getFio());
                            params.put("name", customer.getName());
                            params.put("inn", customer.getInn());
                            params.put("chief", customer.getChief());
                            params.put("phone", customer.getPhone());
                            params.put("address", customer.getAddress());
                            params.put("bank", customer.getBank());
                            params.put("district", customer.getDistrict());
                            params.put("discont", customer.getDiscont());
                            return params;
                        }
                    };
                    RequestHandler.getInstance(context).addToRequestQueue(stringRequest);
                });
            } else {
                holder.confirm.setOnClickListener(view -> {
                    Master master = new Master();
                    master.setId(String.valueOf(System.currentTimeMillis()));
                    master.setFio(viewHolders.get(0).enter.getText().toString());
                    master.setExperience(viewHolders.get(1).enter.getText().toString());
                    master.setDefect(viewHolders.get(2).enter.getText().toString());
                    master.setRepairAll(viewHolders.get(3).enter.getText().toString());
                    Prefs.saveMaster(context, master);

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.ADD_MASTER,
                            response -> {
                                Intent intent = new Intent(context, MasterActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                context.startActivity(intent);
//                                ((Activity) context).overridePendingTransition(R.anim.right_in, R.anim.left_out);
//                                ((Activity) context).finish();
                            },
                            System.out::println)
                    {
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<>();
                            params.put("id", master.getId());
                            params.put("fio", master.getFio());
                            params.put("experience", master.getExperience());
                            params.put("defect", master.getDefect());
                            params.put("repairAll", master.getRepairAll());
                            return params;
                        }
                    };
                    RequestHandler.getInstance(context).addToRequestQueue(stringRequest);
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return fields.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == fields.size() - 1) return 1;
        else return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView text;
        public EditText enter;
        public Button confirm;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.textI);
            enter = itemView.findViewById(R.id.enterI);
            confirm = itemView.findViewById(R.id.confirm);
        }
    }
}
