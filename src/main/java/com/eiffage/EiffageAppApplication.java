package com.eiffage;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.eiffage.repo.UserDetailsRepository;
import com.eiffage.model.Authority;
import com.eiffage.model.User;

@SpringBootApplication
public class EiffageAppApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	public static void main(String[] args) {
		//ApplicationContext ctx= SpringApplication.run(EiffageAppApplication.class, args);
		SpringApplication.run(EiffageAppApplication.class, args);
	//	DataInitilizer data = new DataInitilizer(ctx);
		//data.fillDataBase();
	}
	
	@PostConstruct
	protected void init() {
		
		Authority  authority = createAuthority("ADMIN","Admin role");  
		
		User user=new User();
		
		user.setUserName("KNINA");
		user.setFirstName("Kamal");
		user.setLastName("Knina");
		user.setEmail("kms@eiffage.com");
		user.setCin("CIN0");
		user.setLastName("K");
		
		user.setPassword(passwordEncoder.encode("1234560"));
		user.setEnabled(true);
		user.setAuthority(authority);
		userDetailsRepository.save(user);
	}
	
	
	private Authority createAuthority(String roleCode,String roleDescription) {
		Authority authority=new Authority();
		authority.setRoleCode(roleCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}
	

}
