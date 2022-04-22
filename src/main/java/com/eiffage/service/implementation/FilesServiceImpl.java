package com.eiffage.service.implementation;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiffage.model.Files;
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
	public List<Files> list() {
		return filesRepo.findAll();
	}

	@Override
	public void download(Long id) {
		downloadFromServer(id);
	}

	private void downloadFromServer(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Files updalod(Files file) {
		copyFileToServer(file.getPath());
		return filesRepo.save(file);
	}

	private void copyFileToServer(String path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(Long id) {
		filesRepo.deleteById(id);
		return true;
	}

}
