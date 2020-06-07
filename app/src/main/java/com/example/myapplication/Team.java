package com.example.myapplication;

public class Team {
    private String name;
    private Integer position;
    private Integer points;
    private Integer won;
    private Integer drawn;
    private Integer lost;
    private String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public Integer getPoints() {
        return points;
    }

    public Integer getWon() {
        return won;
    }

    public Integer getDrawn() {
        return drawn;
    }

    public Integer getLost() {
        return lost;
    }

}
