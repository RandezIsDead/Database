package com.randeztrying.database.Helpers;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.randeztrying.database.Models.Customer;
import com.randeztrying.database.Models.Master;

import java.util.List;

public class Prefs {

    private static final String SHARED_PREFS = "DB_Prefs";
    private static final Gson gson = new Gson();

    public static void write(Context context, String key, String text) {
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, text);
        editor.apply();
    }

    public static String read(Context context, String key) {
        return context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE).getString(key, null);
    }

    public static void writeObject(Context context, String key, List value) {
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(value);
        prefsEditor.putString(key, json);
        prefsEditor.apply();
    }

    public static String getJson(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        return preferences.getString(key, "");
    }

    public static void saveCustomer(Context context, Customer customer) {
        write(context, "customerId", customer.getId());
        write(context, "customerType", customer.getType());
        write(context, "customerFio", customer.getFio());
        write(context, "customerName", customer.getName());
        write(context, "customerInn", customer.getInn());
        write(context, "customerChief", customer.getChief());
        write(context, "customerPhone", customer.getPhone());
        write(context, "customerAddress", customer.getAddress());
        write(context, "customerBank", customer.getBank());
        write(context, "customerDistrict", customer.getDistrict());
        write(context, "customerDiscont", customer.getDiscont());
    }

    public static void deleteCustomer(Context context) {
        write(context, "customerId", null);
        write(context, "customerType", null);
        write(context, "customerFio", null);
        write(context, "customerName", null);
        write(context, "customerInn", null);
        write(context, "customerChief", null);
        write(context, "customerPhone", null);
        write(context, "customerAddress", null);
        write(context, "customerBank", null);
        write(context, "customerDistrict", null);
        write(context, "customerDiscont", null);
    }

    public static void saveMaster(Context context, Master master) {
        write(context, "masterId", master.getId());
        write(context, "masterFio", master.getFio());
        write(context, "masterExperience", master.getExperience());
        write(context, "masterDefect", master.getDefect());
        write(context, "masterRepairAll", master.getRepairAll());
    }

    public static void deleteMaster(Context context) {
        write(context, "masterId", null);
        write(context, "masterFio", null);
        write(context, "masterExperience", null);
        write(context, "masterDefect", null);
        write(context, "masterRepairAll", null);
    }

    public static Customer getCustomer(Context context) {
        if (read(context, "customerId") == null) return null;
        return new Customer(
                read(context, "customerId"),
                read(context, "customerType"),
                read(context, "customerFio"),
                read(context, "customerName"),
                read(context, "customerInn"),
                read(context, "customerChief"),
                read(context, "customerPhone"),
                read(context, "customerAddress"),
                read(context, "customerBank"),
                read(context, "customerDistrict"),
                read(context, "customerDiscont")
        );
    }

    public static Master getMaster(Context context) {
        if (read(context, "masterId") == null) return null;
        return new Master(
                read(context, "masterId"),
                read(context, "masterFio"),
                read(context, "masterExperience"),
                read(context, "masterDefect"),
                read(context, "masterRepairAll")
        );
    }

//    public static void saveNotes(Context context, List<Note> notes) {
//        writeObject(context, "notes", notes);
//    }
//
//    public static List<Note> getNotes(Context context) {
//        String json = getJson(context, "notes");
//        if (gson.fromJson(json, new TypeToken<List<Note>>(){}.getType()) == null) return new ArrayList<>();
//        else return gson.fromJson(json, new TypeToken<List<Note>>(){}.getType());
//    }
}
