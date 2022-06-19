package com.eiffage.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eiffage.model.Attachment;
import com.eiffage.model.enumeration.Constante;
import com.eiffage.service.AttachmentService;

@CrossOrigin(origins = Constante.ORIGIN_CROSS)
@RestController
public class AttachmentController implements AttachmentService {

	AttachmentService service;

	public AttachmentController(AttachmentService service) {
		this.service = service;
	}

	@GetMapping("/attachments")
	public List<Attachment> list() {
		return service.list();
	}

	@GetMapping("/attachments/{id}")
	public void download(Long id) {
		service.download(id);
	}

	@PostMapping("/attachments")
	public Attachment updalod(Attachment file) {
		return service.updalod(file);
	}
	
	@DeleteMapping("/attachments/{id}")
	public void delete(Long id) {
		service.delete(id);
	}

}
