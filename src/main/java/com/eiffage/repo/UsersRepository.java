 package com.eiffage.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eiffage.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	public Users findByEmail(String email);
	public Users findByCin(String cin);
	public Users findByPhone(String phone);
}
