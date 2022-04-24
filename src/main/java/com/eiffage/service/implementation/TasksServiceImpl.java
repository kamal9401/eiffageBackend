package com.eiffage.service.implementation;
 import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiffage.model.Tasks;
import com.eiffage.model.Users;
import com.eiffage.model.enumeration.Status;
import com.eiffage.repo.TasksRepository;
import com.eiffage.repo.UsersRepository;
import com.eiffage.service.TasksService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class TasksServiceImpl implements TasksService{

	@Autowired
	TasksRepository tasksRepo;

	@Autowired
	UsersRepository userRepo;

	@Override
	public List<Tasks> list() {
		return tasksRepo.findAll();
	}

	@Override
	public Tasks create(Tasks task) {
		return tasksRepo.save(task);
	}

	@Override
	public Tasks update(Long id, Tasks task) {
		Tasks myTask = tasksRepo.findById(id).get();
		myTask.setAssignTo(task.getAssignTo());
		myTask.setAttachments(task.getAttachments());
		myTask.setComments(task.getComments());
		myTask.setDescription(task.getDescription());
		myTask.setReporter(task.getReporter());
		myTask.setStatus(task.getStatus());
		myTask.setTaskNumber(task.getTaskNumber());
		myTask.setTitle(task.getTitle());
		
		return tasksRepo.save(myTask);
	}

	@Override
	public Tasks  get(Long id) {
		return tasksRepo.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		tasksRepo.deleteById(id);
	}

	@Override
	public Tasks changeStatus(Long idTask, Status status) {
		Tasks task  = tasksRepo.findById(idTask).get();
		task.setStatus(status);
		return tasksRepo.save(task);
	}

	@Override
	public Tasks assignTaskToUser(Long idTask, Long idUser) {
		Tasks task  = tasksRepo.findById(idTask).get();
		Users user  = userRepo.findById(idUser).get();
		task.setAssignTo(user);
		return tasksRepo.save(task);
		
	}

}
