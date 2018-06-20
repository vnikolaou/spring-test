package com.xyz.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xyz.test.model.Team;
import com.xyz.test.service.TeamService;

@Controller
public class TeamController {
	@Autowired
	private TeamService teamService;
	
    @RequestMapping(path={"/", "/teams"}, method = RequestMethod.GET)
    public String home(Model model) {
    	List<Team> teams = teamService.findTeams();
    	model.addAttribute("teams", teams);
    	
        return "team-list";
    }

    @RequestMapping(path="/edit-team", method = RequestMethod.GET)
    public String edit(@RequestParam("id") String teamId, Model model) {
    	Team team = teamService.findTeamById(teamId);
    	model.addAttribute("team", team);
    	
        return "edit-team";
    }
    
    @RequestMapping(path="/new-player", method = RequestMethod.GET)
    public String newPlayer(@RequestParam("id") String teamId, Model model) {
    	model.addAttribute("teamId", teamId);
    	
        return "new-player";
    }
    
    @RequestMapping(path="/add-player", method = RequestMethod.POST)
    public String addPlayer(@RequestParam("id") String teamId,
    		@RequestParam("fullname") String fullName, 
    		@RequestParam("phone") String phone, 
    		@RequestParam("height") Integer height, 
    		Model model) {
    	teamService.addPlayer(teamId, fullName, phone, height);
    	
    	model.addAttribute("teamId", teamId);
    	
        return "redirect:/edit-team?id=" + teamId;
    }   
}
