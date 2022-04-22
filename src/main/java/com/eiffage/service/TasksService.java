package com.eiffage.service;

import java.util.List;
import com.eiffage.model.Tasks;
import com.eiffage.model.enumeration.Status;

public interface TasksService {
	List<Tasks> list();
	Tasks create(Tasks task);
	Tasks update(Tasks task);
	boolean deleteTask(Long id);
	Tasks changeStatus(Long id, Status status);
	Tasks get(Long id); 
	Tasks AssignTaskToUser(Long idTask, Long idUser);
	

	
}
