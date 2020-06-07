package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class TeamBuilder extends AppCompatActivity {
    private Button switchActivity;
    private ImageView iconTeamSelectedA;
    private ImageView iconTeamSelectedB;


    private String teamSelectedA;
    private String teamSelectedB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_builder);

        switchActivity = (Button) findViewById(R.id.goToActivity1);

        switchActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });



    }

    public String getTeamSelectedA() {
        return teamSelectedA;
    }

    public String getTeamSelectedB() {
        return teamSelectedB;
    }

    public void setTeamSelectedA(String teamSelectedA) {
        this.teamSelectedA = teamSelectedA;
    }

    public void setTeamSelectedB(String teamSelectedB) {
        this.teamSelectedB = teamSelectedB;
    }
}
