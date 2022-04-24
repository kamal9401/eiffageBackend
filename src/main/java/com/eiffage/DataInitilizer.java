package com.eiffage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.eiffage.service.*;
import com.eiffage.model.*;
import com.eiffage.model.enumeration.*;
import com.eiffage.repo.*;

public class DataInitilizer {
	ApplicationContext ctx;
	AttachmentsRepository attachmentsRepository;
	TasksRepository tasksRepository;
	CommentsRepository commentsRepository;
	ProjectsRepository projectsRepository;
	TeamsRepository teamsRepository;
	UsersRepository usersRepository;
	
	DataInitilizer(ApplicationContext ctx){
		this.ctx = ctx;
		attachmentsRepository = ctx.getBean(AttachmentsRepository.class);;
		tasksRepository = ctx.getBean(TasksRepository.class);;
		commentsRepository = ctx.getBean(CommentsRepository.class);;
		projectsRepository = ctx.getBean(ProjectsRepository.class);;
		teamsRepository = ctx.getBean(TeamsRepository.class);;
		usersRepository = ctx.getBean(UsersRepository.class);;
	}


	List<Users> users = new ArrayList<Users>();
	List<Projects> projects = new ArrayList<Projects>();
	List<Teams> teams = new ArrayList<Teams>();
	List<Tasks> tasks = new ArrayList<Tasks>();
	List<Comments> comments= new ArrayList<Comments>();
	List<Attachments> attchments = new ArrayList<Attachments>();
	Roles [] roles = new Roles[4];
	
	public void fillDataBase() {
		roles[0] = Roles.ADMIN;
		roles[1] = Roles.CHEF_CHANTIER;
		roles[2] = Roles.CHEF_EQUIPE;
		roles[3] = Roles.OUVRIER;
		this.UsersInitilizer();
		this.ProjectsInitilizer();
		this.TeamsInitilizer();
		this.TasksInitilizer();
		this.CommentsInitilizer();
		this.AttachmentsInitilizer();
	}
	
	private void UsersInitilizer() {
		users = usersRepository.findAll();
		if(users.isEmpty()) {
		for(int i=0;i<10;i++) {
			Users user = new Users("user"+i+"@email.com","firstName "+i,
					"lastName "+i,"2020-02-"+(i<10?"0"+i:i), "CIN "+i,"123456"+i, "Photo "+i,
							"Phone "+i, true, Status.ONLINE,roles[i%4]);
			users.add(user);
			usersRepository.save(user);
		}}
	}

	private void TeamsInitilizer() {
		teams = teamsRepository.findAll();
		if(teams.isEmpty()) {
		for(int i=0;i<10;i++) {
			Teams team = new Teams("Team "+i, projects.get(i));
			teams.add(team);
			teamsRepository.save(team);
		}}
	}

	private void TasksInitilizer() {
		tasks = tasksRepository.findAll();
		if(tasks.isEmpty()) {
		for(int i=0;i<10;i++) {
			Tasks task = new Tasks();
			tasks.add(task);
			tasksRepository.save(task);
		}		
		}
	}

	private void ProjectsInitilizer() {
		projects = projectsRepository.findAll();
		if(projects.isEmpty()) {
		for(int i=0;i<10;i++) {
			Projects project = new Projects("description "+i, "Title "+i, LocalDateTime.of(2022, 4,(i+1),2,0,0), 
						Status.ACTIVE, users.get(i));
			projects.add(project);
			projectsRepository.save(project);
		}		
		}
	}

	private void CommentsInitilizer() {
		// TODO Auto-generated method stub
		
	}

	private void AttachmentsInitilizer() {
		// TODO Auto-generated method stub
		
	}

}
