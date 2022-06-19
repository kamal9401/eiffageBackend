package com.eiffage.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eiffage.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
	public Team findByName(String name);
}
