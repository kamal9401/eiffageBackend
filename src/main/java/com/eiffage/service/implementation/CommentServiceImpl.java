package com.eiffage.service.implementation;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiffage.model.Comment;
import com.eiffage.repo.CommentRepository;
import com.eiffage.service.CommentService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
@Transactional

public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentRepository repo;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<Comment> list() {
		return repo.findAll();
	}

	@Override
	public Comment create(Comment comment) {
		return repo.save(comment);
	}

	@Override
	public Comment update(Long id, Comment newComment) {
		Comment comment = repo.findById(id).get();
		comment.setMessage(newComment.getMessage());
		comment.setReporter(newComment.getReporter());
		comment.setTask(newComment.getTask());
		comment.setTimeStamp(newComment.getTimeStamp());
		return repo.save(comment);
	}

	@Override
	public Comment get(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<Comment> getCommentByTask(Long idTask) {
		TypedQuery<Comment> query  = entityManager.createQuery("FROM Comments u WHERE u.task.id = :id", Comment.class)
		          .setParameter("id", idTask);
			return query.getResultList();
	}

	@Override
	public List<Comment> getCommentByUser(Long idUser) {
		TypedQuery<Comment> query  = entityManager.createQuery("FROM Comments u WHERE u.reporter.id = :id", Comment.class)
		          .setParameter("id", idUser);
			return query.getResultList();
	}
}
