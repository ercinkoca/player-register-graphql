package com.producter.player.registration.resolver;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.producter.player.registration.exceptions.BadRequestException;
import com.producter.player.registration.exceptions.InternalServerException;
import com.producter.player.registration.model.Player;
import com.producter.player.registration.model.PlayerDto;
import com.producter.player.registration.repository.PlayerRepository;


@Service
public class PlayerMutation implements GraphQLMutationResolver {
	
	private static final Integer MAX_CAPACITY = 12;
	
	private final PlayerRepository playerRepository;
	
	public PlayerMutation(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}
	
	public Player createPlayer(PlayerDto playerDto) {
		try {
			validateInputs(playerDto);
			controlMaximumCapacity();
			Player player = new Player();
			player.setName(playerDto.getName());
			player.setSurname(playerDto.getSurname());
			player.setPosition(playerDto.getPosition().getValue());
			return playerRepository.save(player);
		} catch (Exception e) {
			throw new InternalServerException("create player error " + e.getMessage());
		}
	}
	
	public boolean deletePlayer(Long id) {
		try {
			Optional<Player> player = playerRepository.findById(id);
			if (!player.isPresent()) {
				throw new BadRequestException("Player can not found.");
			}
			playerRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			throw new InternalServerException("delete player error " + e.getMessage());
		}
	}
	
	public void validateInputs(PlayerDto playerDto) {
		if (StringUtils.isEmpty(playerDto.getName())) {
			throw new BadRequestException("Name can not be empty!");
		}
		if (StringUtils.isEmpty(playerDto.getSurname())) {
			throw new BadRequestException("Surname can not be empty!");
		}
		if (StringUtils.isEmpty(playerDto.getPosition().value)) {
			throw new BadRequestException("Position can not be empty!");
		}
	}
	
	public void controlMaximumCapacity() {
		List<Player> playerList = playerRepository.findAll();
		if (playerList.size() >= MAX_CAPACITY) {
			throw new BadRequestException("Team reached maximum capacity!");
		}
	}
}
