package com.eiffage.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eiffage.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	public Project findByTitle(String title);
	public Project findByDescription(String description);
}
