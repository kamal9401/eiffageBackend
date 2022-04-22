package com.eiffage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eiffage.model.Comments;
import com.eiffage.service.CommentsService;

@RequestMapping(value="/comments")
public class CommentsController {
	@Autowired
	CommentsService service;

	
	@RequestMapping(value="/list")
	List<Comments> list() {
		return service.list();
	}

	@RequestMapping(value="/create", method=RequestMethod.POST)
	Comments create(Comments comment) {
		return service.create(comment);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	Comments update(Comments comment) {
		return service.update(comment);
	}

	@RequestMapping(value="/find/{id}")
	Comments get(Long id) {
		return service.get(id);
	}

	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	boolean delete(Long id) {
		return service.delete(id);
	}

	@RequestMapping(value="/tasks/{id}")
	List<Comments> getCommentByTask(Long idTask) {
		return service.getCommentByTask(idTask);
	}

	@RequestMapping(value="/user/{id}")
	List<Comments> getCommentByUser(Long idUser) {
		return service.getCommentByUser(idUser);
	}
}
