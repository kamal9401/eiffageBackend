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

import com.eiffage.model.Tasks;
import com.eiffage.model.enumeration.Constante;
import com.eiffage.model.enumeration.Status;
import com.eiffage.service.TasksService;

@CrossOrigin(origins = Constante.ORIGIN_CROSS)
@RestController
public class TasksController {
	TasksService service;

	public TasksController(TasksService service) {
		this.service = service;
	}
	
	@GetMapping("/tasks")
	public List<Tasks> list(){
		return service.list();
	}
	
	@PostMapping("/tasks")
	public Tasks create(@RequestBody Tasks task){
		return service.create(task);
	}
	
	@PutMapping("/tasks/{id}")
	public Tasks update(@PathVariable Long id, @RequestBody Tasks task){
		return service.update(id, task);
	}

	@DeleteMapping("/tasks/{id}")
	public void delete(@PathVariable Long id){
		service.delete(id);
	}

	@GetMapping("/tasks/{id}")
	public Tasks get(@PathVariable Long id) {
		return service.get(id);
	}

	@PutMapping("/tasks/status/{id}/{status}")
	public Tasks changeStatus(Long id, Status status) {
		return service.changeStatus(id, status);
	}

	@PutMapping("/tasks/assign/{id}/{idUser}")
	public Tasks assignTaskToUser(Long idTask, Long idUser) {
		return service.assignTaskToUser(idTask, idUser);
	}

}
