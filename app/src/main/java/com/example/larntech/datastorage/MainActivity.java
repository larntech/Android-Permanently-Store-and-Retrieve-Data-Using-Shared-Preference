package com.example.larntech.datastorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
ArrayList<String> fruits = new ArrayList<>();

fruits.add("Apple");
fruits.add("Lemon");


SharedPreferences sharedPreferences = this.getSharedPreferences("Fruit_names",Context.MODE_PRIVATE);

//store data
        try {
            sharedPreferences.edit().putString("fruits",ObjectSerializer.serialize(fruits)).apply();
        } catch (IOException e) {
            e.printStackTrace();
        }

// retrieve data
        ArrayList<String> storeData = new ArrayList<>();

        try {
            storeData = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("fruits",ObjectSerializer.serialize(new ArrayList<>())));
        } catch (IOException e) {
            e.printStackTrace();
        }
 Toast.makeText(getApplicationContext(),storeData.toString(),Toast.LENGTH_LONG).show();
    }
}