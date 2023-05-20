package com.rohit.thymeleaf.controller;

import com.rohit.thymeleaf.model.Team;
import com.rohit.thymeleaf.service.TeamService;
import jakarta.persistence.PostRemove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.SortedSet;

@Controller
@RequestMapping("/")
public class RootController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/footer")
    public String footerDesign(Model model) {
        return "footer";
    }

    @GetMapping("/service")
    public String fragmentService(Model model) {
        return "service";
    }

    @GetMapping({"/teams", "/teams/"})
    public String allTeams(Model model) {
        List<Team> iplTeams = teamService.getAllTeams();
        model.addAttribute("teams", iplTeams);
        return "index";
//        By using redirect: in the returned String, we instruct Spring to redirect to another page after the
//        POST. This is a pattern called Post/Redirect/Get that is used a lot in web development. By
//        redirecting, you avoid that the POST could be submitted twice if the user would refresh
    }

    @GetMapping("/teams/{name}")
    @ResponseBody
    //The @ResponseBody annotation tells a controller that the object returned is automatically
    // serialized into JSON and passed back into the HttpResponse object.
    public int getTotalWinningsByName(@PathVariable("name") String name) {
        return teamService.getTotalWins(name);
    }

    @PostMapping("/add")
    public void addTeam(Team team){
        teamService.addTeam(team);
    }

    @PostMapping("/delete")
    public void deleteTeam(Team team){
        teamService.deleteTeam(team);
    }

    @PostMapping("/findAll")
    public void findAllTeams(){
        teamService.findAllTeams();
    }

    @PostMapping("/update")
    public void updateTeam(Team team){
        teamService.updateTeam(team);
    }
}