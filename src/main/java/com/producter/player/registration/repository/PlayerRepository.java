package com.producter.player.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.producter.player.registration.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
