 package com.eiffage.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eiffage.model.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
	public Attachment findByTitle(String Title);
	public Attachment findByPath(String Path);
}
