package com.eiffage.service.implementation;
 import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiffage.model.Projects;
import com.eiffage.model.enumeration.Status;
import com.eiffage.repo.ProjectsRepository;

import com.eiffage.service.ProjectsService;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class ProjectsServiceImpl implements ProjectsService{

	@Autowired
	ProjectsRepository projectsRepo;

	@Override
	public List<Projects> list() {
		return projectsRepo.findAll();
	}

	@Override
	public Projects create(Projects project) {
		return projectsRepo.save(project);
	}

	@Override
	public Projects update(Long id, Projects project) {
		Projects myProject = projectsRepo.findById(id).get();
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
	public Projects get(Long id) {
		return projectsRepo.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		projectsRepo.deleteById(id);
	}

	@Override
	public Projects changeStatus(Long idProject,Status status) {
		Projects projects = projectsRepo.findById(idProject).get();
		projects.setStatus(status);
		return projectsRepo.save(projects);
	}

}
