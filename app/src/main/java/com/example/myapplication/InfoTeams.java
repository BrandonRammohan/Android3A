package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoTeams extends AppCompatActivity {
    TextView name;
    TextView position;

    String data1, data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_teams);
        Intent intent = getIntent();

        name = findViewById(R.id.name);
        position = findViewById(R.id.rank);

        data1 = intent.getStringExtra("name");
        data2 = intent.getStringExtra("position");

        name.setText(data1);
        position.setText(data2);
    }

}
