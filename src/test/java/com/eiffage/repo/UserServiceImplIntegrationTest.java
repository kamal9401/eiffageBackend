/**
 * 
 */
package com.eiffage.repo;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.eiffage.model.User;
import com.eiffage.model.enumeration.Role;
import com.eiffage.repo.UserRepository;
import com.eiffage.service.UserService;

/**
 * @author Vous
 *
 */
@RunWith(SpringRunner.class)
public class UserServiceImplIntegrationTest {

	@TestConfiguration
    static class UserServiceImplTestContextConfiguration {
        @Bean
        public UserService userService() {
            return new UserService() {
                // implement methods
            };
        }
    }
	private Role role;
	@Autowired
    private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	
	@Before
	public void setUp() {
	    User user1 = new User("Ana", "Amber", "ana.amber@gmail.com", "1245602", Role.CHEF_CHANTIER);
	    user1.setId(11l);
	    Mockito.when(userRepository.findById(user1.getId()).get()).thenReturn(user1);
	}
	
	@Test
	public void whenValidId_thenUserShouldBeFound() {
	    String name = "Ana";
	    User found = userService.get(11l);
	 
	     assertThat(found.getFirstName())
	      .isEqualTo(name);
	 }
}
