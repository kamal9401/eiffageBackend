package com.eiffage.service;

import java.util.List;

import com.eiffage.model.Teams;

public interface TeamsService {
	List<Teams> list();
	Teams create(Teams team);
	Teams update(Long id, Teams team);
	Teams get(Long id); 
	void delete(Long id); 
	Teams assignUserToTeam(Long idUser, Long idTeam);
	Teams removeUserFromTeam(Long idUser, Long idTeam);
}
