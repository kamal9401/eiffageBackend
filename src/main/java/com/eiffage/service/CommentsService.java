package com.eiffage.service;

import java.util.List;

import com.eiffage.model.Comments;

public interface CommentsService {
	List<Comments> list();
	Comments create(Comments comment);
	Comments update(Long id, Comments comment);
	Comments get(Long id); 
	void delete(Long id);
	List<Comments> getCommentByTask(Long idTask);
	List<Comments> getCommentByUser(Long idUser);
}
