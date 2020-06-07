package com.example.myapplication;

import android.app.Application;

public class Globals extends Application {
    private String teamA = "Liverpool";
    private String teamB = "Manchester United";

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }
}
