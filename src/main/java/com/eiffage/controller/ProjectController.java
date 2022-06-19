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

import com.eiffage.model.Project;
import com.eiffage.model.enumeration.Constante;
import com.eiffage.model.enumeration.Status;
import com.eiffage.service.ProjectService;

@CrossOrigin(origins = Constante.ORIGIN_CROSS)
@RestController
public class ProjectController implements ProjectService{
	ProjectService service;

	public ProjectController(ProjectService service) {
		this.service = service;
	}

	@GetMapping("/projects")	
	public List<Project> list() {
		return service.list();
	}

	@PutMapping("/projects")
	public Project create(@RequestBody Project project) {
		return service.create(project);
	}

	@PostMapping("/projects")
	public Project update(@PathVariable Long id, @RequestBody  Project project) {
		return service.update(id, project);
	}
	
	@GetMapping("/projects/{id}")
	public Project get(@PathVariable Long id) {
		return service.get(id);
	}

	@DeleteMapping("/projects/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

	@PostMapping("/projects/status/{id}/{status}")
	public Project changeStatus(@PathVariable Long id, @RequestBody Status status) {
		return service.changeStatus(id, status);
	}

}
