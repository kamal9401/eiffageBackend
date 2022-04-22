package com.eiffage.service.implementation;
 import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiffage.model.Users;
import com.eiffage.model.enumeration.Status;
import com.eiffage.repo.UsersRepository;
import com.eiffage.service.UsersService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UsersServiceImpl implements UsersService{

	@Autowired
	UsersRepository usersRepo;

	@Override
	public List<Users> list() {
		return usersRepo.findAll();
	}

	@Override
	public Users create(Users user) {
		return usersRepo.save(user);
	}

	@Override
	public Users update(Users user) {
		return usersRepo.save(null);
	}

	@Override
	public Users get(Long id) {
		return usersRepo.findById(id).get();
	}

	@Override
	public Users changePassword(Long idUser, String oldPassword, String newPassword) {
		Users user = usersRepo.findById(idUser).get();
		if(user.getPassword().equals(oldPassword)) {
			user.setPassword(newPassword);
		}
		return usersRepo.save(user);
	}

	@Override
	public Users changeStatus(Long idUser, Status status) {
		Users user = usersRepo.findById(idUser).get();
		user.setStatus(status);
		return usersRepo.save(user);
	}

	@Override
	public Users archiveUser(Long idUser) {
		return this.changeStatus(idUser, Status.INACTIVE);
	}

	@Override
	public Users activeUser(Long idUser) {
		return this.changeStatus(idUser, Status.ACTIVE);
	}

}
