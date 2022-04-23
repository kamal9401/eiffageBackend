package com.eiffage.service;

import java.util.List;

import com.eiffage.model.Attachments;

public interface FilesService {
	List<Attachments> list();
	void download(Long id);
	Attachments updalod(Attachments file);
	boolean delete(Long id); 
}
