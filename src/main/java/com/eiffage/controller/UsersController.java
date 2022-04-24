package com.eiffage.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eiffage.model.Users;
import com.eiffage.model.enumeration.Status;
import com.eiffage.service.UsersService;

@RestController
public class UsersController {

		UsersService service;

		public UsersController(UsersService service) {
			this.service = service;
		}
		
		@GetMapping("/users")
		public List<Users> list(){
			return service.list();
		}
		
		@PostMapping("/users")
		public Users create(@RequestBody Users users){
			return service.create(users);
		}
		
		@PutMapping("/users/{id}")
		public Users update(@PathVariable Long id, @RequestBody Users user){
			return service.update(id, user);
		}

		@PutMapping("/users/archive/{id}")
		public Users archiveUser(@PathVariable Long id){
			return service.archiveUser(id);
		}

		@PutMapping("/users/active/{id}")
		public Users activeUser(@PathVariable Long id){
			return service.activeUser(id);
		}

		@GetMapping("/users/{id}")
		public Users get(@PathVariable Long id) {
			return service.get(id);
		}

		@GetMapping("/users/{id}/{oldPassword}/{newPassword}")
		public Users changePassword(@PathVariable Long id,@PathVariable  String oldPassword,@PathVariable  String newPassword) {
			return service.changePassword(id,oldPassword,newPassword);
		}

		@GetMapping("/users/changeStatus/{id}/{status}")
		public Users changeStatus(@PathVariable Long id,@RequestBody Status status) {
			return service.changeStatus(id,status);
		}

}