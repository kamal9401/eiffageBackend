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

import com.eiffage.model.Projects;
import com.eiffage.model.enumeration.Constante;
import com.eiffage.model.enumeration.Status;
import com.eiffage.service.ProjectsService;

@CrossOrigin(origins = Constante.ORIGIN_CROSS)
@RestController
public class ProjectsController implements ProjectsService{
	ProjectsService service;

	public ProjectsController(ProjectsService service) {
		this.service = service;
	}

	@GetMapping("/projects")	
	public List<Projects> list() {
		return service.list();
	}

	@PutMapping("/projects")
	public Projects create(@RequestBody Projects project) {
		return service.create(project);
	}

	@PostMapping("/projects")
	public Projects update(@PathVariable Long id, @RequestBody  Projects project) {
		return service.update(id, project);
	}
	
	@GetMapping("/projects/{id}")
	public Projects get(@PathVariable Long id) {
		return service.get(id);
	}

	@DeleteMapping("/projects/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

	@PostMapping("/projects/status/{id}/{status}")
	public Projects changeStatus(@PathVariable Long id, @RequestBody Status status) {
		return service.changeStatus(id, status);
	}

}
