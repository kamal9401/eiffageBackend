package com.eiffage.repo;
import com.eiffage.model.Comment;
import com.eiffage.model.Task;
import com.eiffage.model.User;
import com.eiffage.service.implementation.CommentServiceImpl;
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
public class CommentServiceTest {
	 	@Mock
	    private CommentRepository repository;
	 	
	 	User user = new User();
	 	Task task = new Task();
	 	@InjectMocks
	    private CommentServiceImpl service;

	    @Before
	    public void setup() {
	        MockitoAnnotations.initMocks(this);
	    }

	    @Test
	    public void testGetAllToDo() {
	        List<Comment> list = new ArrayList<Comment>();
	        list.add(new Comment("msg1",user,LocalDateTime.now(),task));
	        list.add(new Comment("msg2",user,LocalDateTime.now(),task));
	        list.add(new Comment("msg3",user,LocalDateTime.now(),task));
	        when(repository.findAll()).thenReturn(list);

	        List<Comment> result = service.list();
	        assertEquals(3, result.size());
	    }

	    @Test
	    public void testGetToDoById() {
	        Comment comment = new Comment("msg1",user,LocalDateTime.now(),task);
	        comment.setId(1L);
	        when(repository.findById(1L)).thenReturn(Optional.of(comment));
	        Comment result = service.get(1L);
	        assertEquals(1, result.getId().longValue());
	        assertEquals("msg1", result.getMessage());
	    }

	    @Test
	    public void saveToDo() {
	        Comment comment = new Comment("msg1",user,LocalDateTime.now(),task);
	        comment.setId(1L);
	        when(repository.save(comment)).thenReturn(comment);
	        Comment result = service.create(comment);
	        assertEquals(1, result.getId().longValue());
	        assertEquals("msg1", result.getMessage());
	    }

	    @Test
	    public void removeToDo() {
	        Comment comment = new Comment("msg1",user,LocalDateTime.now(),task);
	        comment.setId(1L);
	        service.delete(1L);
	        verify(repository, times(1)).delete(comment);
	    }
}
