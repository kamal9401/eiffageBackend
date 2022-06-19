package com.eiffage.service;

import java.util.List;

import com.eiffage.model.Project;
import com.eiffage.model.enumeration.Status;

public interface ProjectService {
	List<Project> list();
	Project create(Project project);
	Project update(Long id, Project project);
	Project get(Long id); 
	void delete(Long id); 
	Project changeStatus(Long id, Status status);	
}
