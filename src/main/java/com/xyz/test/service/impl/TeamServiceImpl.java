package com.xyz.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xyz.test.model.Team;
import com.xyz.test.repository.TeamRepository;
import com.xyz.test.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private TeamRepository teamRepository;
	
	@Value("${nba.teams.list.endpoint}")
	private String nbaTeamsListEndpoint;
	

	@Override
	public List<Team> findTeams() {
		return (List<Team>)teamRepository.findAll();
	}

	@Override
	public void loadAllTeams() {
		try {
			ResponseEntity<Team[]> response = restTemplate.getForEntity(nbaTeamsListEndpoint, Team[].class);
			Team[] teams = response.getBody();
			
			if(teams != null && teams.length > 0) {
				for(Team team : teams) {
					teamRepository.save(team);
				}
			}
		} catch(Throwable t) {
			t.printStackTrace();
		}
	}

}
