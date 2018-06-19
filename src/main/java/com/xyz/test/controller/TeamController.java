package com.xyz.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xyz.test.model.Team;
import com.xyz.test.service.TeamService;

@Controller
public class TeamController {
	@Autowired
	private TeamService teamService;
	
    @RequestMapping(path = {"/", "/home"}, method = RequestMethod.GET)
    public String home(Model model) {
    	List<Team> teams = teamService.findTeams();
    	model.addAttribute("teams", teams);
    	
        return "home";
    }

}
