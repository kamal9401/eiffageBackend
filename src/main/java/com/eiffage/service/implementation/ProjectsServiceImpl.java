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
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
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
	public Projects update(Projects project) {
		return projectsRepo.save(null);
	}

	@Override
	public Projects get(Long id) {
		return projectsRepo.findById(id).get();
	}

	@Override
	public boolean delete(Long id) {
		projectsRepo.deleteById(id);
		return true;
	}

	@Override
	public Projects changeStatus(Long idProject,Status status) {
		Projects projects = projectsRepo.findById(idProject).get();
		projects.setStatus(status);
		return projectsRepo.save(projects);
	}

}
