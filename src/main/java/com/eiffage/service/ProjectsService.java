package com.eiffage.service;

import java.util.List;

import com.eiffage.model.Projects;
import com.eiffage.model.enumeration.Status;

public interface ProjectsService {
	List<Projects> list();
	Projects create(Projects project);
	Projects update(Long id, Projects project);
	Projects get(Long id); 
	void delete(Long id); 
	Projects changeStatus(Long id, Status status);	
}
