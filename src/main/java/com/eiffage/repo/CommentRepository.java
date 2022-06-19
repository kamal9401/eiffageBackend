 package com.eiffage.repo;




import org.springframework.data.jpa.repository.JpaRepository;

import com.eiffage.model.Comment;



public interface CommentRepository extends JpaRepository<Comment, Long> {
	public Comment findByMessage(String Message);
	public Comment findByReporter(String Reporter);

}
