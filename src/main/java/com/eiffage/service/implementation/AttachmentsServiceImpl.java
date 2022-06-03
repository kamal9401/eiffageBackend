package com.eiffage.service.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiffage.model.Attachments;
import com.eiffage.repo.AttachmentsRepository;
import com.eiffage.service.AttachmentsService;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
@Transactional
public class AttachmentsServiceImpl implements AttachmentsService {

	@Autowired
	AttachmentsRepository filesRepo;

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
	public void delete(Long id) {
		filesRepo.deleteById(id);
	}

}
