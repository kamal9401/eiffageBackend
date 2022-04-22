package com.eiffage.service;

import java.util.List;
import com.eiffage.model.Roles;

public interface RolesService {
	List<Roles> list();
	Roles Create(Roles role);
	Roles Update(Roles role);
	Roles delete(Long id);
	Roles get(Long id);
	
	
}
