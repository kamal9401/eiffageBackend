package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.eiffage.controller.TasksController;
import com.eiffage.service.implementation.TasksServiceImpl;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {TasksController.class, TasksServiceImpl.class})

public class TasksInfoControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void testList() {
		
	}
}
