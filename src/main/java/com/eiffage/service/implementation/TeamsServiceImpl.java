package com.eiffage.service.implementation;
 import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiffage.model.Teams;
import com.eiffage.model.Users;
import com.eiffage.repo.TeamsRepository;
import com.eiffage.repo.UsersRepository;
import com.eiffage.service.TeamsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class TeamsServiceImpl implements TeamsService{

	@Autowired
	TeamsRepository teamsRepo;

	@Autowired
	UsersRepository userRepo;

	@Override
	public List<Teams> list() {
		return teamsRepo.findAll();
	}

	@Override
	public Teams create(Teams team) {
		return teamsRepo.save(team);
	}

	@Override
	public Teams update(Long id, Teams team) {
		Teams myTeam = teamsRepo.findById(id).get();
		myTeam.setCurrentProject(team.getCurrentProject());
		myTeam.setName(team.getName());
		myTeam.setUsers(team.getUsers());
		
		return teamsRepo.save(myTeam);
	}

	@Override
	public Teams get(Long id) {
		return teamsRepo.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		teamsRepo.deleteById(id);
	}

	@Override
	public Teams assignUserToTeam(Long idUser, Long idTeam) {
		Teams myTeam = teamsRepo.findById(idTeam).get();
		Users user = userRepo.findById(idUser).get();
		myTeam.getUsers().add(user);
		return teamsRepo.save(myTeam);
	}

	@Override
	public Teams removeUserFromTeam(Long idUser, Long idTeam) {
		Teams myTeam = teamsRepo.findById(idTeam).get();
		myTeam.getUsers().removeIf(e->e.getIdUser()==idUser);
		return teamsRepo.save(myTeam);
	}

}
