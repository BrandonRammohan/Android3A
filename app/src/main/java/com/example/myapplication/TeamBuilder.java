package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class TeamBuilder extends AppCompatActivity {
    private Button switchActivity;
    private Button teamAwin;
    private Button draw;
    private Button teamBwin;
    private Button launch;
    private ImageView iconTeamSelectedA;
    private ImageView iconTeamSelectedB;

    public TextView teamA;
    public TextView teamB;
    public TextView score;


    public String teamSelectedA;
    public String teamSelectedB;

    public Integer teamWin;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_builder);

        switchActivity = (Button) findViewById(R.id.goToActivity1);
        teamAwin = (Button) findViewById(R.id.teamAwin);
        teamBwin = (Button) findViewById(R.id.teamBwin);
        draw = (Button) findViewById(R.id.draw);
        launch = (Button) findViewById(R.id.launch);
        teamA = (TextView) findViewById(R.id.teamA);
        teamB = (TextView) findViewById(R.id.teamB);
        score = (TextView) findViewById(R.id.score);

        switchActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

        Intent intent = getIntent();

        if (intent.hasExtra("teamA")){
            Globals g = (Globals)getApplication();
            teamSelectedA = intent.getStringExtra("teamA");
            teamSelectedB=g.getTeamB();

            g.setTeamA(teamSelectedA);
            g.setTeamB(teamSelectedB);

            teamA.setText(teamSelectedA);
            teamB.setText(teamSelectedB);
        }
        else if (intent.hasExtra("teamB")){
            Globals g = (Globals)getApplication();
            teamSelectedA=g.getTeamA();
            teamSelectedB = intent.getStringExtra("teamB");

            g.setTeamA(teamSelectedA);
            g.setTeamB(teamSelectedB);

            teamA.setText(teamSelectedA);
            teamB.setText(teamSelectedB);
        }
        else{
            Globals g = (Globals)getApplication();
            teamSelectedA=g.getTeamA();
            teamSelectedB=g.getTeamB();

            g.setTeamA(teamSelectedA);
            g.setTeamB(teamSelectedB);


            teamA.setText(teamSelectedA);
            teamB.setText(teamSelectedB);
        }

        teamAwin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamWin = 1;
            }
        });
        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamWin = 2;
            }
        });
        teamBwin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamWin = 3;
            }
        });

        launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int random1 = new Random().nextInt(4);
                final int random2 = new Random().nextInt(4);

                String scoreString = String.valueOf(random1) + " - " + String.valueOf(random2);
                score.setText(scoreString);

                if(random1>random2 && teamWin == 1){
                    Toast.makeText(getApplicationContext(), "Vous avez gagné !", Toast.LENGTH_SHORT).show();
                }
                else if (random1==random2 && teamWin == 2){
                    Toast.makeText(getApplicationContext(), "Vous avez gagné !", Toast.LENGTH_SHORT).show();
                }
                else if (random1<random2 && teamWin == 3){
                    Toast.makeText(getApplicationContext(), "Vous avez gagné !", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Vous avez perdu...", Toast.LENGTH_SHORT).show();
                }


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
