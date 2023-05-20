package com.rohit.thymeleaf.controller;

import com.rohit.thymeleaf.model.Team;
import com.rohit.thymeleaf.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    }

    @GetMapping("/teams/{name}")
    @ResponseBody
    //The @ResponseBody annotation tells a controller that the object returned is automatically
    // serialized into JSON and passed back into the HttpResponse object.
    public int getTotalWinningsByName(@PathVariable("name") String name) {
        return teamService.getTotalWins(name);
    }
}