package com.eiffage.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eiffage.model.Attachments;
import com.eiffage.service.AttachmentsService;

@RestController
public class AttachmentsController implements AttachmentsService {

	AttachmentsService service;

	public AttachmentsController(AttachmentsService service) {
		this.service = service;
	}

	@GetMapping("/attachments")
	public List<Attachments> list() {
		return service.list();
	}

	@GetMapping("/attachments/{id}")
	public void download(Long id) {
		service.download(id);
	}

	@PostMapping("/attachments")
	public Attachments updalod(Attachments file) {
		return service.updalod(file);
	}
	
	@DeleteMapping("/attachments/{id}")
	public void delete(Long id) {
		service.delete(id);
	}

}
