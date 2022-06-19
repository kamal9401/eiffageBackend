package com.eiffage.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eiffage.model.Team;
import com.eiffage.model.enumeration.Constante;
import com.eiffage.service.TeamService;

@CrossOrigin(origins = Constante.ORIGIN_CROSS)
@RestController
public class TeamController implements TeamService{

	TeamService service;

	public TeamController(TeamService service) {
		this.service = service;
	}
	
	@GetMapping("/teams")
	public List<Team> list(){
		return service.list();
	}
	
	@PostMapping("/teams")
	public Team create(@RequestBody Team team){
		return service.create(team);
	}
	
	@PutMapping("/teams/{id}")
	public Team update(@PathVariable Long id, @RequestBody Team team){
		return service.update(id, team);
	}

	@DeleteMapping("/teams/{id}")
	public void delete(@PathVariable Long id){
		service.delete(id);
	}

	@GetMapping("/teams/{id}")
	public Team get(@PathVariable Long id) {
		return service.get(id);
	}

	@PutMapping("/teams/addUser/{idUser}/{idTeam}")
	public Team assignUserToTeam(Long idUser, Long idTeam) {
		return service.assignUserToTeam(idUser, idTeam);
	}

	@PutMapping("/teams/removeUser/{idUser}/{idTeam}")
	public Team removeUserFromTeam(Long idUser, Long idTeam) {
		return service.removeUserFromTeam(idUser, idTeam);
	}


}
