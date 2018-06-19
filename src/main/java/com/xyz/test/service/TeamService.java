package com.xyz.test.service;

import java.util.List;

import com.xyz.test.model.Team;

public interface TeamService {
	public void loadAllTeams();	
	public List<Team> findTeams();
}
