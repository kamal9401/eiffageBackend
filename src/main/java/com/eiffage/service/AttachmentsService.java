package com.eiffage.service;

import java.util.List;

import com.eiffage.model.Attachments;

public interface AttachmentsService {
	List<Attachments> list();
	void download(Long id);
	Attachments updalod(Attachments file);
	void delete(Long id); 
}
