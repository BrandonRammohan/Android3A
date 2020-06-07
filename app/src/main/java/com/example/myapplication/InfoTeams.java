package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoTeams extends AppCompatActivity {
    TextView name, position, points, won, draw, lost;
    public Button teamA;
    public Button teamB;

    private String dName, dPosition, dPoints, dWon, dDraw, dLost;
    private String teamSelected;

    TeamBuilder teamBuilder;

    public InfoTeams() {
        teamSelected = "null";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_teams);
        Intent intent = getIntent();

        name = findViewById(R.id.name);
        position = findViewById(R.id.rank);
        points = findViewById(R.id.points);
        won = findViewById(R.id.win);
        draw = findViewById(R.id.draw);
        lost = findViewById(R.id.lost);
        teamA = findViewById(R.id.teamA);
        teamB = findViewById(R.id.teamB);



        dName = intent.getStringExtra("name");
        dPosition = String.valueOf(intent.getIntExtra("position", 0));
        dPoints = String.valueOf(intent.getIntExtra("points", 0));
        dWon = String.valueOf(intent.getIntExtra("won", 0));
        dDraw = String.valueOf(intent.getIntExtra("draw", 0));
        dLost = String.valueOf(intent.getIntExtra("lost", 0));

        name.setText(dName);
        position.setText(dPosition);
        points.setText(dPoints);
        won.setText(dWon);
        draw.setText(dDraw);
        lost.setText(dLost);

        teamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBuilder.setTeamSelectedA(dName);
            }
        });
        teamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBuilder.setTeamSelectedB(dName);
            }
        });

    }

    public String getTeamSelected() {
        return teamSelected;
    }

    public void setTeamSelected(String newTeam) {
        teamSelected = newTeam;
    }

    public TextView getName() {
        return name;
    }

    public String getdName() {
        return dName;
    }
}
