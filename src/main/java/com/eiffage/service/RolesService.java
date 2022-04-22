package com.eiffage.service;


import org.springframework.data.domain.Page;

import com.eiffage.model.Roles;

public interface RolesService {
	Page<Roles> list();
	Roles Create(Roles role);
	Roles Update(Roles role);
	void delete(Long id);
	Roles get(String id);
	
	
}
