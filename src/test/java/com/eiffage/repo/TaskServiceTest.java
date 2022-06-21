package com.eiffage.repo;
import com.eiffage.model.Project;
import com.eiffage.model.Task;
import com.eiffage.model.User;
import com.eiffage.model.enumeration.Role;
import com.eiffage.model.enumeration.Status;
import com.eiffage.service.implementation.CommentServiceImpl;
import com.eiffage.service.implementation.ProjectServiceImpl;
import com.eiffage.service.implementation.TaskServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class TaskServiceTest {
	 	@Mock
	    private TaskRepository repository;
	 	
	 	User user1 = new User();
	 	User user2 = new User();
	 	Project project1 = new Project();
	 	
	 	@InjectMocks
	    private TaskServiceImpl taskService;

	    @Before
	    public void setup() {
	        MockitoAnnotations.initMocks(this);
	        user1 = new User("Ana", "Amber", "ana.amber@gmail.com", "1245602",Role.CHEF_CHANTIER);
	        user1 = new User("Alice", "Teixira", "alice.teixira@gmail.com", "1245602",Role.ADMIN);
	        project1 = new Project("Project desc 1", "NNT", LocalDateTime.now(), Status.ACTIVE, user1);
	    }

	    @Test
	    public void testGetAllToDo() {
	        List<Task> list = new ArrayList<Task>();
	        list.add(new Task("task1", "LCR1", "desc task1", Status.IN_PROGRESS, user2, user1, project1));
	        list.add(new Task("task1", "DAN1", "desc task1", Status.IN_PROGRESS, user2, user1, project1));
	        list.add(new Task("task1", "SFS1", "desc task1", Status.IN_PROGRESS, user2, user1, project1));
	        when(repository.findAll()).thenReturn(list);

	        List<Task> result = taskService.list();
	        assertEquals(3, result.size());
	    }

	    @Test
	    public void testGetToDoById() {
	        Task task = new Task("task1", "LCR1", "desc task1", Status.IN_PROGRESS, user2, user1, project1);
	        task.setId(111L);
	        when(repository.findById(111L)).thenReturn(Optional.of(task));
	        Task result = taskService.get(111l);
	        assertEquals(111L, result.getId().longValue());
	        assertEquals("LCR1", result.getTaskNumber());
	    }

	    @Test
	    public void saveToDo() {
	    	Task task = new Task("task1", "DAN1", "desc task1", Status.IN_PROGRESS, user2, user1, project1);
	    	task.setId(1L);
	        when(repository.save(task)).thenReturn(task);
	        Task result = taskService.create(task);
	        assertEquals(1, result.getId().longValue());
	        assertEquals("task1", result.getTitle());
	    }

	    @Test
	    public void updateToDo() {
	    	Task task = new Task("task1", "LCR1", "desc task1", Status.IN_PROGRESS, user2, user1, project1);
	    	task.setId(1L);
	        when(repository.save(task)).thenReturn(task);
	        Task result = taskService.create(task);
	        when(repository.findById(1L)).thenReturn(Optional.of(task));
	        task.setTaskNumber("BNV3");
	        task.setStatus(Status.PENDING);
	        assertEquals(1, result.getId().longValue());
	        assertEquals(Status.PENDING, result.getStatus());
	    }
	    
	    @Test
	    public void removeToDo() {
	        Task task = new Task("task1", "SFS1", "desc task1", Status.IN_PROGRESS, user2, user1, project1);
	        task.setId(1L);
	        taskService.create(task);
	        taskService.delete(1L);
	        assertEquals(false, repository.existsById(task.getId()));
	        //verify(repository, times(1)).delete(comment);
	    }
}
