package com.rohit.thymeleaf.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Team {
    @Id
    int id;
    String name;
    int totalWinnings;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public Team(int id,String name, int totalWinnings) {
        this.id=id;
        this.name = name;
        this.totalWinnings = totalWinnings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
