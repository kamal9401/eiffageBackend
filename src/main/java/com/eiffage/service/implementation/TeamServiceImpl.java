package com.eiffage.service.implementation;
 import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiffage.model.Team;
import com.eiffage.model.User;
import com.eiffage.repo.TeamRepository;
import com.eiffage.repo.UserRepository;
import com.eiffage.service.TeamService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class TeamServiceImpl implements TeamService{

	@Autowired
	TeamRepository teamsRepo;

//	@Autowired
//	UsersRepository userRepo;

	@Override
	public List<Team> list() {
		return teamsRepo.findAll();
	}

	@Override
	public Team create(Team team) {
		return teamsRepo.save(team);
	}

	@Override
	public Team update(Long id, Team team) {
		Team myTeam = teamsRepo.findById(id).get();
		myTeam.setCurrentProject(team.getCurrentProject());
		myTeam.setName(team.getName());
		myTeam.setUsers(team.getUsers());
		
		return teamsRepo.save(myTeam);
	}

	@Override
	public Team get(Long id) {
		return teamsRepo.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		teamsRepo.deleteById(id);
	}

	@Override
	public Team assignUserToTeam(Long idUser, Long idTeam) {
		Team myTeam = teamsRepo.findById(idTeam).get();
//		User user = userRepo.findById(idUser).get();
//		myTeam.getUsers().add(user);
		return teamsRepo.save(myTeam);
	}

	@Override
	public Team removeUserFromTeam(Long idUser, Long idTeam) {
		Team myTeam = teamsRepo.findById(idTeam).get();
		myTeam.getUsers().removeIf(e->e.getId()==idUser);
		return teamsRepo.save(myTeam);
	}

}
