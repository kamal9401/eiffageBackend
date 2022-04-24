package com.eiffage;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.eiffage.model.Users;
import com.eiffage.model.enumeration.Roles;
import com.eiffage.repo.UsersRepository;

@SpringBootApplication
public class EiffageAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(EiffageAppApplication.class, args);
		DataInitilizer data = new DataInitilizer(ctx);
		data.fillDataBase();
		
	/*	RolesRepository roleRepo = ctx.getBean(RolesRepository.class);
		UsersRepository userRepo = ctx.getBean(UsersRepository.class);
	
		Roles r1 = roleRepo.save(new Roles(Roles.CHEF_CHANTIER+"", "admin de l'app"));
		Roles r2 = roleRepo.save(new Roles(Roles.CHEF_EQUIPE+"", "admin de l'app"));
		Roles r3 = roleRepo.save(new Roles(Roles.OUVRIER+"", "admin de l'app"));
		Roles r4 = roleRepo.save(new Roles("ADMIN", "admin de l'app"));
		
		userRepo.save(new Users("a@gmail.com","CIN1",r1));
		userRepo.save(new Users("b@gmail.com","CIN2",r2));
		userRepo.save(new Users("c@gmail.com","CIN3",r3));
		userRepo.save(new Users("d@gmail.com","CIN4",r4));
	
		List<Roles> roles = roleRepo.findAll();
		List<Users> users = userRepo.findAll();
		
		roles.forEach(e->System.out.println(e));
		users.forEach(e->System.out.println(e));
	*/
	}

}
