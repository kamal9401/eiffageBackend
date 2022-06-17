package com.eiffage.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eiffage.model.User;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, Long> {

	com.eiffage.model.User findByUserName(String userName);
	
}
