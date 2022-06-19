package com.eiffage.service.implementation;
 import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiffage.model.Project;
import com.eiffage.model.enumeration.Status;
import com.eiffage.repo.ProjectRepository;

import com.eiffage.service.ProjectService;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	ProjectRepository projectsRepo;

	@Override
	public List<Project> list() {
		return projectsRepo.findAll();
	}

	@Override
	public Project create(Project project) {
		return projectsRepo.save(project);
	}

	@Override
	public Project update(Long id, Project project) {
		Project myProject = projectsRepo.findById(id).get();
		myProject.setChefChantier(project.getChefChantier());
		myProject.setDescription(project.getDescription());
		myProject.setStatus(project.getStatus());
		myProject.setTasks(project.getTasks());
		myProject.setTeams(project.getTeams());
		myProject.setTeams(project.getTeams());
		myProject.setTimeStamp(project.getTimeStamp());
		myProject.setTitle(project.getTitle());
		
		return projectsRepo.save(myProject);
	}

	@Override
	public Project get(Long id) {
		return projectsRepo.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		projectsRepo.deleteById(id);
	}

	@Override
	public Project changeStatus(Long idProject,Status status) {
		Project project = projectsRepo.findById(idProject).get();
		project.setStatus(status);
		return projectsRepo.save(project);
	}

}
