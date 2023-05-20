package com.rohit.thymeleaf.service;

import com.rohit.thymeleaf.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    public List<Team> getAllTeams(){
        List<Team> allTeams =new ArrayList<>();
        allTeams.add(new Team("MI",2));
        allTeams.add(new Team("CSK",3));
        allTeams.add(new Team("RCB",0));
        allTeams.add(new Team("LG",0));
        allTeams.add(new Team("GT",1));
        allTeams.add(new Team("SRH",0));
        allTeams.add(new Team("DD",1));
        allTeams.add(new Team("RR",1));
        return allTeams;
    }

    public int getTotalWins(String name){
        List<Team> teamList=getAllTeams();
        for (var team:teamList) {
            if(team.getName().equals(name)){
                return team.getTotalWinnings();
            }
        }
        return -1;
    }
}
