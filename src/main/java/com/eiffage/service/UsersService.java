package com.eiffage.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.eiffage.model.ConfirmationToken;
import com.eiffage.model.User;
import com.eiffage.model.enumeration.Status;
import com.eiffage.repo.UsersRepository;
import com.eiffage.service.UsersService;

@Service
public class UsersService implements UserDetailsService {

	@Autowired
	UsersRepository usersRepo;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	ConfirmationTokenService confirmationTokenService;
	private final static String USER_NOT_FOUND_MSG = "user with email %s not found";

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return usersRepo.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
	}

	public String signUpUser(User appUser) {
		boolean userExists = usersRepo.findByEmail(appUser.getEmail()).isPresent();

		if (userExists) {
			// TODO check of attributes are the same and
			// TODO if email not confirmed send confirmation email.

			throw new IllegalStateException("email already taken");
		}

		String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());

		appUser.setPassword(encodedPassword);

		usersRepo.save(appUser);

		String token = UUID.randomUUID().toString();

		ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(15), appUser);

		confirmationTokenService.saveConfirmationToken(confirmationToken);

//        TODO: SEND EMAIL

		return token;
	}

	public int enableAppUser(String email) {
		return usersRepo.enableUsers(email);
	}

	public Page<User> list() {
		return usersRepo.findAll(PageRequest.of(1,5));
	}

	public List<User> findAll() {
		return usersRepo.findAll();
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
