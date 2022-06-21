package com.eiffage.repo;
import com.eiffage.model.Project;
import com.eiffage.model.User;
import com.eiffage.model.enumeration.Role;
import com.eiffage.model.enumeration.Status;
import com.eiffage.service.implementation.CommentServiceImpl;
import com.eiffage.service.implementation.ProjectServiceImpl;

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
public class ProjectServiceTest {
	 	@Mock
	    private ProjectRepository repository;
	 	
	 	User user = new User();

	 	@InjectMocks
	    private ProjectServiceImpl projectService;

	    @Before
	    public void setup() {
	        MockitoAnnotations.initMocks(this);
	        user = new User("Ana", "Amber", "ana.amber@gmail.com", "1245602",Role.CHEF_CHANTIER);
	    }

	    @Test
	    public void testGetAllToDo() {
	        List<Project> list = new ArrayList<Project>();
	        list.add(new Project("Project desc 1", "NNT", LocalDateTime.now(), Status.ACTIVE, user));
	        list.add(new Project("Project desc 2", "BBD", LocalDateTime.now(), Status.ACTIVE, user));
	        list.add(new Project("Project desc 3", "CCT", LocalDateTime.now(), Status.ACTIVE, user));
	        when(repository.findAll()).thenReturn(list);

	        List<Project> result = projectService.list();
	        assertEquals(3, result.size());
	    }

	    @Test
	    public void testGetToDoById() {
	        Project project = new Project("Project desc 1", "NNT", LocalDateTime.now(), Status.ACTIVE, user);
	        project.setId(256L);
	        when(repository.findById(256L)).thenReturn(Optional.of(project));
	        Project result = projectService.get(256L);
	        assertEquals(256L, result.getId().longValue());
	        assertEquals("NNT", result.getTitle());
	    }

	    @Test
	    public void saveToDo() {
	    	Project project = new Project("Project desc 2", "BBD", LocalDateTime.now(), Status.ACTIVE, user);
	    	project.setId(1L);
	        when(repository.save(project)).thenReturn(project);
	        Project result = projectService.create(project);
	        assertEquals(1, result.getId().longValue());
	        assertEquals("BBD", result.getTitle());
	    }

	    @Test
	    public void updateToDo() {
	    	Project project = new Project("Project desc 2", "BBD", LocalDateTime.now(), Status.IN_PROGRESS, user);
	    	project.setId(1L);
	        when(repository.save(project)).thenReturn(project);
	        Project result = projectService.create(project);
	        when(repository.findById(1L)).thenReturn(Optional.of(project));
	        project.setDescription("update desc prg1");
	        project.setStatus(Status.PENDING);
	        assertEquals(1, result.getId().longValue());
	        assertEquals(Status.PENDING, result.getStatus());
	    }
	    
	    @Test
	    public void removeToDo() {
	        Project project = new Project("Project desc 3", "CCT", LocalDateTime.now(), Status.ACTIVE, user);
	        project.setId(1L);
	        projectService.create(project);
	        projectService.delete(1L);
	        assertEquals(false, repository.existsById(project.getId()));
	        //verify(repository, times(1)).delete(comment);
	    }
}
