package com.xyz.test.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="teams")
public class Team implements Serializable {
	private static final long serialVersionUID = -2612450541546351851L;
	@Id
	@JsonProperty("team_id")
	@Column(name="team_id")
	private String teamId;

	private String abbreviation;
	
	@JsonProperty("first_name")
	@Column(name="first_name")
	private String firstName;
	
	@JsonProperty("last_name")
	@Column(name="last_name")	
	private String lastName;

	private String conference;
	private String division;
	
	@JsonProperty("site_name")
	@Column(name="site_name")	
	private String siteName;
	
	private String city;
	private String state;
	
	@JsonProperty("full_name")
	@Column(name="full_name")	
	private String fullName;

	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, mappedBy="team")
	private Collection<Player> players;
	
	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getConference() {
		return conference;
	}

	public void setConference(String conference) {
		this.conference = conference;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Collection<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Collection<Player> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", abbreviation=" + abbreviation + ", firstName=" + firstName + ", lastName="
				+ lastName + ", conference=" + conference + ", division=" + division + ", siteName=" + siteName
				+ ", city=" + city + ", state=" + state + ", fullName=" + fullName + "]";
	}
		
}
