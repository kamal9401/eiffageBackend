package com.eiffage.service;

import java.util.List;

import com.eiffage.model.Team;

public interface TeamService {
	List<Team> list();
	Team create(Team team);
	Team update(Long id, Team team);
	Team get(Long id); 
	void delete(Long id); 
	Team assignUserToTeam(Long idUser, Long idTeam);
	Team removeUserFromTeam(Long idUser, Long idTeam);
}
