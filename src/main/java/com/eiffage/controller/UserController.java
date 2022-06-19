package com.eiffage.controller;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eiffage.model.User;
import com.eiffage.model.enumeration.Constante;
import com.eiffage.model.enumeration.Status;
import com.eiffage.service.UserService;

@CrossOrigin(origins = Constante.ORIGIN_CROSS)
@RestController
public class UserController {

		UserService service;

		public UserController(UserService service) {
			this.service = service;
		}
		
//		@GetMapping("/users")
//		public Page<Users> list(){
//			return service.list();
//		}

		@GetMapping("/users")
		public List<User> findAll(){
			return service.findAll();
		}

		@PostMapping("/users")
		public User create(@RequestBody User user){
			return service.create(user);
		}
		
		@PutMapping("/users/{id}")
		public User update(@PathVariable Long id, @RequestBody User user){
			return service.update(id, user);
		}

		@PutMapping("/users/archive/{id}")
		public User archiveUser(@PathVariable Long id){
			return service.archiveUser(id);
		}

		@PutMapping("/users/active/{id}")
		public User activeUser(@PathVariable Long id){
			return service.activeUser(id);
		}

		@GetMapping("/users/{id}")
		public User get(@PathVariable Long id) {
			return service.get(id);
		}

		@GetMapping("/users/{id}/{oldPassword}/{newPassword}")
		public User changePassword(@PathVariable Long id,@PathVariable  String oldPassword,@PathVariable  String newPassword) {
			return service.changePassword(id,oldPassword,newPassword);
		}

		@GetMapping("/users/changeStatus/{id}/{status}")
		public User changeStatus(@PathVariable Long id,@RequestBody Status status) {
			return service.changeStatus(id,status);
		}

}
