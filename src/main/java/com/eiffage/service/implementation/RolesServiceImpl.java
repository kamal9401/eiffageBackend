package com.eiffage.service.implementation;
 import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	public Page<Roles> list() {
		return roleRepo.findAll(PageRequest.ofSize(0));
	}

	@Override
	public Roles Create(Roles role) {
		return roleRepo.save(role);
	}

	@Override
	public Roles Update(Roles role) {
		return roleRepo.save(role);
	}

	@Override
	public void delete(Long id) {
		roleRepo.deleteById(id+"");
	}

	@Override
	public Roles get(String id) {
		return roleRepo.getById(id+"");
	}

}
