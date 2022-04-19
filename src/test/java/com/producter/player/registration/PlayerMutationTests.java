package com.producter.player.registration;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.graphql.spring.boot.test.GraphQLTest;
import com.producter.player.registration.enums.Position;
import com.producter.player.registration.exceptions.BadRequestException;
import com.producter.player.registration.model.Player;
import com.producter.player.registration.model.PlayerDto;
import com.producter.player.registration.resolver.PlayerMutation;


@GraphQLTest
@SpringBootTest(classes = RegistrationApplication.class)
class PlayerMutationTests {
	
	
	@Autowired
	private PlayerMutation playerMutation;
	
	private PlayerDto playerDto;
	
	
	@Test
	void createPlayerTests() {
		playerDto = new PlayerDto();
		playerDto.setName("erçin");
		playerDto.setSurname("koca");
		playerDto.setPosition(Position.C);
		Player player = playerMutation.createPlayer(playerDto);
		assertNotNull(player);
	}
	
	@Test
	void deletePlayerTests() {
		Long playerId = 1L;
		assertTrue(playerMutation.deletePlayer(playerId));
	}
	
	@Test
	void validateInputsTest() {
		playerDto = new PlayerDto();
		playerDto.setName(null);
		playerDto.setSurname("koca");
		playerDto.setPosition(Position.C);
		Exception exception = assertThrows(BadRequestException.class, () -> {
			playerMutation.validateInputs(playerDto);
	    });

	    String expectedMessage = "Name can not be empty!";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void validateInputsTest2() {
		playerDto = new PlayerDto();
		playerDto.setName("erçin");
		playerDto.setSurname(null);
		playerDto.setPosition(Position.C);
		Exception exception = assertThrows(BadRequestException.class, () -> {
			playerMutation.validateInputs(playerDto);
	    });

	    String expectedMessage = "Surname can not be empty!";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void validateInputsTest3() {
		playerDto = new PlayerDto();
		playerDto.setName("erçin");
		playerDto.setSurname("koca");
		playerDto.setPosition(null);
		Exception exception = assertThrows(BadRequestException.class, () -> {
			playerMutation.validateInputs(playerDto);
	    });

	    String expectedMessage = "Position can not be empty!";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void maxCapacityTest() {
		playerDto = new PlayerDto();
		playerDto.setName("erçin");
		playerDto.setSurname("koca");
		playerDto.setPosition(Position.C);
		for(int i = 0; i<=12; i++) {
			playerMutation.createPlayer(playerDto);
		}
		
		Exception exception = assertThrows(BadRequestException.class, () -> {
			playerMutation.controlMaximumCapacity();
	    });

	    String expectedMessage = "Team reached maximum capacity!";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
		
	}

}
