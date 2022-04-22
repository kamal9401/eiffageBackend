package com.eiffage.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eiffage.model.Projects;

public interface ProjectsRepository extends JpaRepository<Projects, Long> {
	public Projects findByTitle(String title);
	public Projects findByDescription(String description);
}
