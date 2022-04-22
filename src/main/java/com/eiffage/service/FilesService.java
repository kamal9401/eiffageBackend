package com.eiffage.service;

import java.util.List;

import com.eiffage.model.Files;

public interface FilesService {
	List<Files> list();
	void download(Long id);
	Files updalod(Files file);
	boolean delete(Long id); 
}
