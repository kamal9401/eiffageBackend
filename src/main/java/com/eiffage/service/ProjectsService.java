package com.eiffage.service;

import java.util.List;

import com.eiffage.model.Projects;
import com.eiffage.model.enumeration.Status;


public interface ProjectsService {
	List<Projects> list();
	Projects create(Projects project);
	Projects update(Projects project);
	Projects get(Long id); 
	boolean delete(Long id); 
	Projects changeStatus(Long id, Status status);	
}
