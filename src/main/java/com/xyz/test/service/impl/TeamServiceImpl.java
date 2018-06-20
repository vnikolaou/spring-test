package com.xyz.test.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xyz.test.model.Player;
import com.xyz.test.model.Team;
import com.xyz.test.repository.PlayerRepository;
import com.xyz.test.repository.TeamRepository;
import com.xyz.test.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private PlayerRepository playerRepository;	
	
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

	@Override
	public Team findTeamById(String id) {
		Team team = teamRepository.findById(id).orElse(null);
		if(team != null) team.getPlayers();
		
		return team;
	}

	@Override
	@Transactional
	public void addPlayer(String teamId, String fullName, String phone, Integer height) {
		Team team = teamRepository.findById(teamId).get();
		
		Player player = new Player();
		player.setFullName(fullName);
		player.setPhone(phone);
		player.setHeight(height);
		player.setTeam(team);
		
		playerRepository.save(player);
		team.getPlayers().add(player);
	}

}
