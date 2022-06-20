package com.eiffage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.eiffage.model.*;
import com.eiffage.model.enumeration.*;
import com.eiffage.repo.*;

public class DataInitilizer {
	
	BCryptPasswordEncoder bCryptPasswordEncoder;
	ApplicationContext ctx;
	AttachmentRepository attachmentRepository;
	TaskRepository taskRepository;
	CommentRepository commentRepository; 
	ProjectRepository projectRepository;
	TeamRepository teamRepository;
	UserRepository userRepository;
	
	DataInitilizer(ApplicationContext ctx){
		this.ctx = ctx;
		bCryptPasswordEncoder = new BCryptPasswordEncoder();
		attachmentRepository = ctx.getBean(AttachmentRepository.class);;
		taskRepository = ctx.getBean(TaskRepository.class);;
		commentRepository = ctx.getBean(CommentRepository.class);;
		projectRepository = ctx.getBean(ProjectRepository.class);;
		teamRepository = ctx.getBean(TeamRepository.class);;
		userRepository = ctx.getBean(UserRepository.class);;
	}

	List<User> users = new ArrayList<User>();
	List<Project> projects = new ArrayList<Project>();
	List<Team> teams = new ArrayList<Team>();
	List<Task> tasks = new ArrayList<Task>();
	List<Comment> comments= new ArrayList<Comment>();
	List<Attachment> attachments = new ArrayList<Attachment>();
	Role [] role = new Role[4];
	
	public void fillDataBase() {
		role[0] = Role.ADMIN;
		role[1] = Role.CHEF_CHANTIER;
		role[2] = Role.CHEF_EQUIPE;
		role[3] = Role.OUVRIER;
		this.UsersInitilizer();
		this.ProjectsInitilizer();
		this.TeamsInitilizer();
		this.TasksInitilizer();
		this.CommentsInitilizer();
		this.AttachmentsInitilizer();
	}
	
	private void UsersInitilizer() {
		String [] roles = new String[] {"ADMIN","OUVRIER","CHEF_CHANTIER","CHEF_EQUIPE", "CONDUCTEUR_TRAVAUX"};
		users = userRepository.findAll();
		if(users.isEmpty()) {
		for(int i=0;i<10;i++) {
			 String encodedPassword = bCryptPasswordEncoder
		                .encode("123456"+i);
			User user = new User("user"+i+"@email.com","firstName "+i,
					"lastName "+i,"2020-02-"+(i<10?"0"+i:i), "CIN "+i,encodedPassword, "Photo "+i,
							"Phone "+i, true, Status.ONLINE,true);
			user.setAuthority(createAuthority(roles[i%4],roles[i%4]+ " roles"));
			users.add(user);
			userRepository.save(user);
		}}
	}
	private Authority createAuthority(String roleCode,String roleDescription) {
		Authority authority=new Authority();
		authority.setRoleCode(roleCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}

	private void TeamsInitilizer() {
		teams = teamRepository.findAll();
		if(teams.isEmpty()) {
		for(int i=0;i<10;i++) {
			Team team = new Team("Team "+i, projects.get(i));
			teams.add(team);
			teamRepository.save(team);
			//users.get(i).setTeam(team);
			userRepository.save(users.get(i));
		}}
	}

	private void TasksInitilizer() {
		tasks = taskRepository.findAll();
		if(tasks.isEmpty()) {
			for(int i=0;i<10;i++) {
				Task task = new Task("title "+i, "TaskNumber "+i, "Description "+i, 
						Status.BACKLOG, users.get(i), users.get(i),projects.get(i));
				
				tasks.add(task);
				taskRepository.save(task);
			}		
			
		}
	}

	private void ProjectsInitilizer() {
		projects = projectRepository.findAll();
		if(projects.isEmpty()) {
		for(int i=0;i<10;i++) {
			Project project = new Project("description "+i, "Title "+i, LocalDateTime.of(2022, 4,(i+1),2,0,0), 
						Status.ACTIVE, users.get(i));
			projects.add(project);
			projectRepository.save(project);
		}		
		}
	}

	private void CommentsInitilizer() {
		comments = commentRepository.findAll();
		if(comments.isEmpty()) {
			for(int i=0;i<10;i++) {
				Comment comment = new Comment("message "+i, users.get(i), LocalDateTime.of(2022, 4, (i+1),10,10), tasks.get(i));
				comments.add(comment);
				commentRepository.save(comment);
			}		
		}
	}

	private void AttachmentsInitilizer() {
		attachments = attachmentRepository.findAll();
		if(attachments.isEmpty()) {
			for(int i=0;i<10;i++) {
				Attachment attachment = new Attachment(tasks.get(i),users.get(i),"Title "+i, "Path "+i, "Icon "+i);
				attachments.add(attachment);
				attachmentRepository.save(attachment);
			}		
		}
	}

}
