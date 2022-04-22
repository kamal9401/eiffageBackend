package com.eiffage.service;

import java.util.List;

import com.eiffage.model.Roles;
import com.eiffage.model.Teams;
import com.eiffage.model.Users;

public interface TeamsService {
	List<Teams> list();
	Teams create(Teams team);
	Teams update(Teams team);
	Teams get(Long id); 
	Users AssignUserToTeam(Long IdUser, Long idTeam, Roles role);
	

	
}
