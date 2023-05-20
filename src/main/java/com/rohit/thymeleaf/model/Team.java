package com.rohit.thymeleaf.model;

public class Team {
    String name;
    int totalWinnings;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public Team(String name, int totalWinnings) {
        this.name = name;
        this.totalWinnings = totalWinnings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalWinnings() {
        return totalWinnings;
    }

    public void setTotalWinnings(int totalWinnings) {
        this.totalWinnings = totalWinnings;
    }
}
