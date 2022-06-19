package com.eiffage.service;

import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.eiffage.model.User;
import com.eiffage.model.enumeration.Status;
import com.eiffage.repo.UserDetailsRepository;
import com.eiffage.repo.UserRepository;
import com.eiffage.service.UserService;

@Service
public class UserService {

	@Autowired
	UserDetailsRepository userDetailsRepository;

	@Autowired
	UserRepository usersRepo;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

//	public int enableAppUser(String email) {
//		return usersRepo.enableUsers(email);
//	}

	public Page<User> list() {
		return usersRepo.findAll(PageRequest.of(1,5));
	}

	public List<User> findAll() {
		return usersRepo.findAll();
	}
	
	public User findById(Long idUser) {
		return usersRepo.findById(idUser).get();
	}
	
	public User create(User user) {
		return usersRepo.save(user);
	}

	public User update(Long id, User user) {
		User myUser = usersRepo.findById(id).get();
		myUser.setActivated(user.isActivated());
		myUser.setAttachments(user.getAttachments());
		myUser.setBirthday(user.getBirthday());
		myUser.setCin(user.getCin());
		myUser.setComments(user.getComments());
		myUser.setEmail(user.getEmail());
		myUser.setFirstName(user.getFirstName());
		myUser.setLastName(user.getLastName());
		myUser.setPhone(user.getPhone());
		myUser.setPhoto(user.getPhoto());
		myUser.setRole(user.getRole());
		myUser.setStatus(user.getStatus());
		myUser.setTasksAssigned(user.getTasksAssigned());
		myUser.setTasksReported(user.getTasksReported());
		return usersRepo.save(myUser);

	}

	public User get(Long id) {
		return usersRepo.findById(id).get();
	}

	public User changePassword(Long idUser, String oldPassword, String newPassword) {
		User user = usersRepo.findById(idUser).get();
		if (user.getPassword().equals(oldPassword)) {
			user.setPassword(newPassword);
		}
		return usersRepo.save(user);
	}

	public User changeStatus(Long idUser, Status status) {
		User user = usersRepo.findById(idUser).get();
		user.setStatus(status);
		return usersRepo.save(user);
	}

	public User archiveUser(Long idUser) {
		return this.changeStatus(idUser, Status.INACTIVE);
	}

	public User activeUser(Long idUser) {
		return this.changeStatus(idUser, Status.ACTIVE);
	}
}
