package com.producter.player.registration;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.graphql.spring.boot.test.GraphQLTest;
import com.producter.player.registration.resolver.PlayerQuery;

@SpringBootTest(classes = RegistrationApplication.class)
@GraphQLTest
class PlayerQueryTests {
	
	@Autowired
	PlayerQuery playerQuery;
	
	
	@Test
	void playerQueryTests() {
		assertNotNull(playerQuery.findAllPlayers());
	}

}
