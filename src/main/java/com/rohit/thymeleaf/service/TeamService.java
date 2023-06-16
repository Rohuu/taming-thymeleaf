package com.rohit.thymeleaf.service;

import com.rohit.thymeleaf.model.Team;
import com.rohit.thymeleaf.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams(){
        List<Team> allTeams =new ArrayList<>();
        allTeams.add(new Team(100,"MI",2));
        allTeams.add(new Team(101,"CSK",3));
        allTeams.add(new Team(102,"RCB",0));
        allTeams.add(new Team(103,"LG",0));
        allTeams.add(new Team(104,"GT",1));
        allTeams.add(new Team(105,"SRH",0));
        allTeams.add(new Team(106,"DD",1));
        allTeams.add(new Team(107,"RR",1));
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

    public void addTeam(Team team){
        teamRepository.save(team);
    }

    public void deleteTeam(Team team){
        teamRepository.delete(team);
    }

    public void updateTeam(Team team){
        teamRepository.save(team);
    }

    public void findAllTeams(){
        teamRepository.findAll();
    }

}
