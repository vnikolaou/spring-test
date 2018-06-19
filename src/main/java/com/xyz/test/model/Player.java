package com.xyz.test.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="players")
public class Player implements Serializable {
	private static final long serialVersionUID = 5659699941925975400L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="player_id")
	private Long playerId;
	
	@Column(name="full_name")
	private String fullName;
	
	private String phone;
	private int height;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="team_id", nullable=false)	
	private Team team;
	
	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", fullName=" + fullName + ", phone=" + phone + ", height=" + height
				+ "]";
	}
		
}
