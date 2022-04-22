 package com.eiffage.repo;




import org.springframework.data.jpa.repository.JpaRepository;

import com.eiffage.model.Comments;



public interface CommentsRepository extends JpaRepository<Comments, Long> {
	public Comments findByMessage(String Message);
	public Comments findByReporter(String Reporter);

}
