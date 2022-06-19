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

import com.eiffage.model.Comment;
import com.eiffage.model.enumeration.Constante;
import com.eiffage.service.CommentService;

@CrossOrigin(origins = Constante.ORIGIN_CROSS)
@RestController
public class CommentController {

	CommentService service;

	public CommentController(CommentService service) {
		this.service = service;
	}
	
	@GetMapping("/comments")
	public List<Comment> list(){
		return service.list();
	}
	
	@PostMapping("/comments")
	public Comment create(@RequestBody Comment comment){
		return service.create(comment);
	}
	
	@PutMapping("/comments/{id}")
	public Comment update(@PathVariable Long id, @RequestBody Comment comment){
		return service.update(id, comment);
	}

	@DeleteMapping("/comments/{id}")
	public void delete(@PathVariable Long id){
		service.delete(id);
	}

	@GetMapping("/comments/{id}")
	public Comment get(@PathVariable Long id) {
		return service.get(id);
	}

	@GetMapping("/comments/tasks/{idTasks}")
	public List<Comment> getCommentByTask(@PathVariable Long idTask) {
		return service.getCommentByTask(idTask);
	}

	@GetMapping("/comments/user/{idUser}")
	public List<Comment> getCommentByUser(@PathVariable Long idUser) {
		return service.getCommentByUser(idUser);
	}

}
