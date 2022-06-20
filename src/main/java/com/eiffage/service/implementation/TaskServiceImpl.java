package com.eiffage.service.implementation;
 import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiffage.model.Task;
import com.eiffage.model.enumeration.Status;
import com.eiffage.repo.TaskRepository;
import com.eiffage.service.TaskService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class TaskServiceImpl implements TaskService{

	@Autowired
	TaskRepository tasksRepo;

	@Override
	public List<Task> list() {
		return tasksRepo.findAll();
	}

	@Override
	public Task create(Task task) {
		return tasksRepo.save(task);
	}

	@Override
	public Task update(Long id, Task task) {
		Task myTask = tasksRepo.findById(id).get();
		myTask.setAssignTo(task.getAssignTo());
		myTask.setDescription(task.getDescription());
		myTask.setReporter(task.getReporter());
		myTask.setStatus(task.getStatus());
		myTask.setTaskNumber(task.getTaskNumber());
		myTask.setTitle(task.getTitle());
		
		return tasksRepo.save(myTask);
	}

	@Override
	public Task  get(Long id) {
		return tasksRepo.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		tasksRepo.deleteById(id);
	}

	@Override
	public Task changeStatus(Long idTask, Status status) {
		Task task  = tasksRepo.findById(idTask).get();
		task.setStatus(status);
		return tasksRepo.save(task);
	}

	@Override
	public Task assignTaskToUser(Long idTask, Long idUser) {
		Task task  = tasksRepo.findById(idTask).get();
		return tasksRepo.save(task);
		
	}

}
