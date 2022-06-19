package com.eiffage.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.eiffage.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	public Task findByTitle(String Title);
	public Task findByReporter(String Reporter);
}
