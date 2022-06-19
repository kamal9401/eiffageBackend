package com.eiffage.service;

import java.util.List;
import com.eiffage.model.Task;
import com.eiffage.model.enumeration.Status;

public interface TaskService {
	List<Task> list();
	Task create(Task task);
	Task update(Long id, Task task);
	void delete(Long id);
	Task changeStatus(Long id, Status status);
	Task get(Long id); 
	Task assignTaskToUser(Long idTask, Long idUser);
	

	
}
