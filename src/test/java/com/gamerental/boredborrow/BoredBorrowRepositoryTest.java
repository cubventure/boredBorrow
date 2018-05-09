package com.gamerental.boredborrow;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gamerental.boredborrow.domain.Game;
import com.gamerental.boredborrow.domain.GameRepository;
import com.gamerental.boredborrow.domain.Genre;
import com.gamerental.boredborrow.domain.Language;
import com.gamerental.boredborrow.domain.Type;

@RunWith(SpringRunner.class) //JUnit is told to run using Spring's testing support
@DataJpaTest // configures an in-memory database, SPA and Spring Data. SQL logging is turned on
public class BoredBorrowRepositoryTest {
	
	@Autowired
	private GameRepository gameRepo;
	
	@Test //Tests that getters and setters work for games, as well as entities being created correctly with command line runner for H2 in-mem database
	public void findByName() {
		List<Game> games = gameRepo.findByName("Boss Monster");
		assertThat(games).hasSize(1);
		assertThat(games.get(0).getImg()).isEqualTo("https://cdn.shopify.com/s/files/1/1911/5793/products/boss-monster-game-dungeon-building-card-game_1024x1024_clipped_rev_1_500x.png");
	}
	
	@Test //Tests that entity can be created without prior repositories created
	public void createNewGame() {
		Game game = new Game("Taru Sormusten Herrasta", "https://lautapeliopas.fi/wp-content/uploads/2008/12/tarusormustenherrasta.jpg", new Genre("Teamwork"), new Language("Suomea"), 2, 4, new Type("Lautapeli"));
		gameRepo.save(game);
		assertThat(game.getId()).isNotNull();
	}
	

}
