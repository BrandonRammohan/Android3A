package com.example.myapplication;

import java.util.List;

public class RestTeamsResponse {
    private int count;
    private List<Team> results;

    public int getCount() {
        return count;
    }

    public List<Team> getResults() {
        return results;
    }

}
