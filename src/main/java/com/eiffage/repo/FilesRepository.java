 package com.eiffage.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eiffage.model.Attachments;

public interface FilesRepository extends JpaRepository<Attachments, Long> {
	public Attachments findByTitle(String Title);
	public Attachments findByPath(String Path);
}
