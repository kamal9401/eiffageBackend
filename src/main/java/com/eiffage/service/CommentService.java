package com.eiffage.service;

import java.util.List;

import com.eiffage.model.Comment;

public interface CommentService {
	List<Comment> list();
	Comment create(Comment comment);
	Comment update(Long id, Comment comment);
	Comment get(Long id); 
	void delete(Long id);
	List<Comment> getCommentByTask(Long idTask);
	List<Comment> getCommentByUser(Long idUser);
}
