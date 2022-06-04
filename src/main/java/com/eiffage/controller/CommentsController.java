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

import com.eiffage.model.Comments;
import com.eiffage.model.enumeration.Constante;
import com.eiffage.service.CommentsService;

@CrossOrigin(origins = Constante.ORIGIN_CROSS)
@RestController
public class CommentsController {

	CommentsService service;

	public CommentsController(CommentsService service) {
		this.service = service;
	}
	
	@GetMapping("/comments")
	public List<Comments> list(){
		return service.list();
	}
	
	@PostMapping("/comments")
	public Comments create(@RequestBody Comments comments){
		return service.create(comments);
	}
	
	@PutMapping("/comments/{id}")
	public Comments update(@PathVariable Long id, @RequestBody Comments comment){
		return service.update(id, comment);
	}

	@DeleteMapping("/comments/{id}")
	public void delete(@PathVariable Long id){
		service.delete(id);
	}

	@GetMapping("/comments/{id}")
	public Comments get(@PathVariable Long id) {
		return service.get(id);
	}

	@GetMapping("/comments/tasks/{idTasks}")
	public List<Comments> getCommentByTask(@PathVariable Long idTask) {
		return service.getCommentByTask(idTask);
	}

	@GetMapping("/comments/user/{idUser}")
	public List<Comments> getCommentByUser(@PathVariable Long idUser) {
		return service.getCommentByUser(idUser);
	}

}
