package com.example.kristine.simon_lab_quiz;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.FileInputStream;

public class SecondActivity extends AppCompatActivity {

    Button loadSharedPreferences, loadInternalStorage, clear, back;
    TextView display;
    SharedPreferences preferences;
    FileInputStream fis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        loadSharedPreferences = (Button) findViewById(R.id.btn_loadSharedPreferences);
        clear = (Button) findViewById(R.id.btn_clear);
        back = (Button) findViewById(R.id.btn_back);
        display = (TextView) findViewById(R.id.display);

        preferences = getSharedPreferences("preference", Context.MODE_WORLD_READABLE);
    }

    public void LoadSharedPreferences(View view) {
        String user = preferences.getString("user", "");
        String pass = preferences.getString("pass", "");
        display.setText(user + " said " + pass);
    }

    public void Clear(View view) {
        display.setText("");
    }

    public void Back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

