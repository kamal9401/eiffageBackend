package com.eiffage.service;

import java.util.List;
import com.eiffage.model.Users;
import com.eiffage.model.enumeration.Status;

public interface UsersService {
	List<Users> list();
	Users create(Users user);
	Users update(Long id, Users user);
	Users get(Long id); 
	Users changePassword(Long id, String oldPassword,String newPassword);
	Users archiveUser(Long id);
	Users activeUser(Long id);
	Users changeStatus(Long id, Status status);
}
