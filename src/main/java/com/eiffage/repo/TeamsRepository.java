package com.eiffage.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eiffage.model.Teams;

public interface TeamsRepository extends JpaRepository<Teams, Long> {
	public Teams findByName(String name);
}
