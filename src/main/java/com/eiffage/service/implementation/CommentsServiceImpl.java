package com.eiffage.service.implementation;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiffage.model.Comments;
import com.eiffage.repo.CommentsRepository;
import com.eiffage.service.CommentsService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
@Transactional

public class CommentsServiceImpl implements CommentsService{

	@Autowired
	CommentsRepository repo;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<Comments> list() {
		return repo.findAll();
	}

	@Override
	public Comments create(Comments comment) {
		return repo.save(comment);
	}

	@Override
	public Comments update(Long id, Comments newComment) {
		Comments comments = repo.findById(id).get();
		comments.setMessage(newComment.getMessage());
		comments.setReporter(newComment.getReporter());
		comments.setTask(newComment.getTask());
		comments.setTimeStamp(newComment.getTimeStamp());
		return repo.save(comments);
	}

	@Override
	public Comments get(Long id) {
		return repo.getById(id);
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<Comments> getCommentByTask(Long idTask) {
		TypedQuery<Comments> query  = entityManager.createQuery("FROM Comments u WHERE u.task.id = :id", Comments.class)
		          .setParameter("id", idTask);
			return query.getResultList();
	}

	@Override
	public List<Comments> getCommentByUser(Long idUser) {
		TypedQuery<Comments> query  = entityManager.createQuery("FROM Comments u WHERE u.reporter.id = :id", Comments.class)
		          .setParameter("id", idUser);
			return query.getResultList();
	}
}
