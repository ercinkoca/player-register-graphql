package com.producter.player.registration.resolver;

import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.producter.player.registration.exceptions.InternalServerException;
import com.producter.player.registration.model.Player;
import com.producter.player.registration.repository.PlayerRepository;

@Service
public class PlayerQuery implements GraphQLQueryResolver {
	
	private final PlayerRepository playerRepository;

	public PlayerQuery(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}
	
	public Iterable<Player> findAllPlayers() {
		try {
			return playerRepository.findAll();
		} catch (Exception e) {
			throw new InternalServerException("find all players error " + e.getMessage());
		}
	}
	

}
