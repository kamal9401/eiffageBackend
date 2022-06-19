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

import com.eiffage.model.Task;
import com.eiffage.model.enumeration.Constante;
import com.eiffage.model.enumeration.Status;
import com.eiffage.service.TaskService;

@CrossOrigin(origins = Constante.ORIGIN_CROSS)
@RestController
public class TaskController {
	TaskService service;

	public TaskController(TaskService service) {
		this.service = service;
	}
	
	@GetMapping("/tasks")
	public List<Task> list(){
		return service.list();
	}
	
	@PostMapping("/tasks")
	public Task create(@RequestBody Task task){
		return service.create(task);
	}
	
	@PutMapping("/tasks/{id}")
	public Task update(@PathVariable Long id, @RequestBody Task task){
		return service.update(id, task);
	}

	@DeleteMapping("/tasks/{id}")
	public void delete(@PathVariable Long id){
		service.delete(id);
	}

	@GetMapping("/tasks/{id}")
	public Task get(@PathVariable Long id) {
		return service.get(id);
	}

	@PutMapping("/tasks/status/{id}/{status}")
	public Task changeStatus(Long id, Status status) {
		return service.changeStatus(id, status);
	}

	@PutMapping("/tasks/assign/{id}/{idUser}")
	public Task assignTaskToUser(Long idTask, Long idUser) {
		return service.assignTaskToUser(idTask, idUser);
	}

}
