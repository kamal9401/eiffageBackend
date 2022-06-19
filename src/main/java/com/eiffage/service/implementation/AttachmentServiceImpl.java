package com.eiffage.service.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiffage.model.Attachment;
import com.eiffage.repo.AttachmentRepository;
import com.eiffage.service.AttachmentService;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
@Transactional
public class AttachmentServiceImpl implements AttachmentService {

	@Autowired
	AttachmentRepository filesRepo;

	@Override
	public List<Attachment> list() {
		return filesRepo.findAll();
	}

	@Override
	public void download(Long id) {
		downloadFromServer(id);
	}

	private void downloadFromServer(Long id) {

	}

	@Override
	public Attachment updalod(Attachment file) {
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
