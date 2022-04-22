package com.eiffage.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eiffage.model.Roles;
import com.eiffage.service.RolesService;
@RestController
@RequestMapping(value="/roles")
public class RolesController {
	@Autowired
	RolesService service;
	
	@RequestMapping(value="/list")
	Page<Roles> list(){
		return service.list();
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	Roles Create(Roles role){
		return service.Create(role);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	Roles Update(Roles role){
		return service.Update(role);
	}

	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	void delete(Long id){
		service.delete(id);
	}

	@RequestMapping(value="/find/{id}")
	public Map<String, Roles> get(String id) {
		Map<String, Roles> map = new HashMap<String, Roles>();
		map.put(id, service.get(id));
		return map;
	}
}
