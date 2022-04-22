package com.eiffage.service.implementation;
 import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiffage.model.Roles;
import com.eiffage.repo.RolesRepository;
import com.eiffage.repo.UsersRepository;
import com.eiffage.service.RolesService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class RolesServiceImpl implements RolesService{

	@Autowired
	RolesRepository roleRepo;
	
	@Autowired
	UsersRepository usersRepo;
	
	@Override
	public List<Roles> list() {
		return roleRepo.findAll();
	}

}
