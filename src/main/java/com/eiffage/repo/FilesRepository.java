 package com.eiffage.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eiffage.model.Files;

public interface FilesRepository extends JpaRepository<Files, Long> {
	public Files findByTitle(String Title);
	public Files findByPath(String Path);
}
