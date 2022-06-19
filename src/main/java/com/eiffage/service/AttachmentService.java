package com.eiffage.service;

import java.util.List;

import com.eiffage.model.Attachment;

public interface AttachmentService {
	List<Attachment> list();
	void download(Long id);
	Attachment updalod(Attachment file);
	void delete(Long id); 
}
