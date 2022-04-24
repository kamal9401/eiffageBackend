package com.eiffage.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eiffage.model.Teams;
import com.eiffage.service.TeamsService;

@RestController
public class TeamsController implements TeamsService{

	TeamsService service;

	public TeamsController(TeamsService service) {
		this.service = service;
	}
	
	@GetMapping("/teams")
	public List<Teams> list(){
		return service.list();
	}
	
	@PostMapping("/teams")
	public Teams create(@RequestBody Teams teams){
		return service.create(teams);
	}
	
	@PutMapping("/teams/{id}")
	public Teams update(@PathVariable Long id, @RequestBody Teams team){
		return service.update(id, team);
	}

	@DeleteMapping("/teams/{id}")
	public void delete(@PathVariable Long id){
		service.delete(id);
	}

	@GetMapping("/teams/{id}")
	public Teams get(@PathVariable Long id) {
		return service.get(id);
	}

	@PutMapping("/teams/addUser/{idUser}/{idTeam}")
	public Teams assignUserToTeam(Long idUser, Long idTeam) {
		return service.assignUserToTeam(idUser, idTeam);
	}

	@PutMapping("/teams/removeUser/{idUser}/{idTeam}")
	public Teams removeUserFromTeam(Long idUser, Long idTeam) {
		return service.removeUserFromTeam(idUser, idTeam);
	}


}
