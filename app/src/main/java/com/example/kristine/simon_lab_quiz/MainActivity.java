package com.example.kristine.simon_lab_quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button sharedPreferences, internalStorage, next;
    SharedPreferences preferences;
    FileOutputStream fos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.et_username);
        password = (EditText)findViewById(R.id.et_password);
        sharedPreferences = (Button)findViewById(R.id.btn_SharedPreferences);
        preferences = getSharedPreferences("preference", Context.MODE_WORLD_READABLE);
    }

    public void Next(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        finish();

    }

    public void SharedPreferences(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user", username.getText().toString());
        editor.putString("pass", password.getText().toString());
        editor.commit();

        Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
    }
}
