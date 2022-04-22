package com.eiffage.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eiffage.model.Roles;

public interface RolesRepository extends JpaRepository<Roles, String> {
	public Roles findByRole(String role);

}
