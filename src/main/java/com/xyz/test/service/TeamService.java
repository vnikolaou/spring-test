package com.xyz.test.service;

import java.util.List;

import com.xyz.test.model.Team;

public interface TeamService {
	public void loadAllTeams();	
	public List<Team> findTeams();
	public Team findTeamById(String id);
	public void addPlayer(String teamId, String fullName, String phone, Integer height);
}
