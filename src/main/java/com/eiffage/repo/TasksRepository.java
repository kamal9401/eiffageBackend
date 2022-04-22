package com.eiffage.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.eiffage.model.Tasks;

public interface TasksRepository extends JpaRepository<Tasks, Long> {
	public Tasks findByTitle(String Title);
	public Tasks findByReporter(String Reporter);
}
