package com.eiffage.service.implementation;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiffage.model.Attachments;
import com.eiffage.repo.FilesRepository;
import com.eiffage.service.FilesService;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class FilesServiceImpl implements FilesService{

	@Autowired
	FilesRepository filesRepo;

	@Override
	public List<Attachments> list() {
		return filesRepo.findAll();
	}

	@Override
	public void download(Long id) {
		downloadFromServer(id);
	}

	private void downloadFromServer(Long id) {
		
	}

	@Override
	public Attachments updalod(Attachments file) {
		copyFileToServer(file.getPath());
		return filesRepo.save(file);
	}

	private void copyFileToServer(String path) {
		
	}

	@Override
	public boolean delete(Long id) {
		filesRepo.deleteById(id);
		return true;
	}

}
