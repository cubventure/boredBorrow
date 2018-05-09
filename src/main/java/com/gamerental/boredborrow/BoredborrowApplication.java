package com.gamerental.boredborrow;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gamerental.boredborrow.domain.Game;
import com.gamerental.boredborrow.domain.GameRepository;
import com.gamerental.boredborrow.domain.Genre;
import com.gamerental.boredborrow.domain.GenreRepository;
import com.gamerental.boredborrow.domain.Language;
import com.gamerental.boredborrow.domain.LanguageRepository;
import com.gamerental.boredborrow.domain.Type;
import com.gamerental.boredborrow.domain.TypeRepository;
import com.gamerental.boredborrow.domain.User;
import com.gamerental.boredborrow.domain.UserRepository;

@SpringBootApplication
public class BoredborrowApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoredborrowApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(GameRepository gameRepo, GenreRepository genreRepo, LanguageRepository langRepo, TypeRepository typeRepo, UserRepository userRepo) {
		return (args) -> {
//			
//			//Create new repositories
//			genreRepo.save(new Genre("Adventure"));
//			genreRepo.save(new Genre("Strategy"));
//			genreRepo.save(new Genre("Racing"));
//			genreRepo.save(new Genre("Party"));
//			langRepo.save(new Language("English"));
//			langRepo.save(new Language("Finnish"));
//			langRepo.save(new Language("Swedish"));
//			langRepo.save(new Language("Multi-language"));
//			typeRepo.save(new Type("Boardgame"));
//			typeRepo.save(new Type("Cardgame"));
//			typeRepo.save(new Type("Xbox360"));
//			typeRepo.save(new Type("WiiU"));
//			
//			//Create games
//			Game g1 = new Game("Mario Kart 8", "https://upload.wikimedia.org/wikipedia/en/thumb/b/b5/MarioKart8Boxart.jpg/220px-MarioKart8Boxart.jpg", genreRepo.findByName("Racing").get(0), langRepo.findByName("English").get(0), 1, 4, typeRepo.findByName("WiiU").get(0));
//			Game g2 = new Game("Uno", "https://cf.geekdo-images.com/itemrep/img/NvECHeCH0GfmLdh5onMpMPH03Hc=/fit-in/246x300/pic981505.jpg", genreRepo.findByName("Party").get(0), langRepo.findByName("Multi-language").get(0), 1, 4, typeRepo.findByName("Cardgame").get(0));
//			Game g3 = new Game("Boss Monster", "https://cdn.shopify.com/s/files/1/1911/5793/products/boss-monster-game-dungeon-building-card-game_1024x1024_clipped_rev_1_500x.png", genreRepo.findByName("Strategy").get(0), langRepo.findByName("English").get(0), 1, 4, typeRepo.findByName("Cardgame").get(0));
//			Game g4 = new Game("Lego: Lord of the Rings", "https://upload.wikimedia.org/wikipedia/en/thumb/a/a0/Lego_Lord_of_the_Rings_cover.jpg/220px-Lego_Lord_of_the_Rings_cover.jpg", genreRepo.findByName("Party").get(0), langRepo.findByName("English").get(0), 1, 4, typeRepo.findByName("Xbox360").get(0));
//			
//			gameRepo.save(g1);
//			gameRepo.save(g2);
//			gameRepo.save(g3);
//			gameRepo.save(g4);
//			
//			//Create users: user/user admin/admin s1/s1
//			User user1 = new User("user", "$2a$04$hpzD62XOuhNG3.owtMmxWexr40vTjFjP0pbCHt4MOFajyMntjBQGu", "user@boredborrow.com", "USER");
//			User user2 = new User("admin", "$2a$04$BeQgipK6QK327OvvYsUUSOmWqfST20EgR8Gpurt0y6ukyGPJKKpga", "admin@boredborrow.com", "ADMIN");
//			userRepo.save(user1);
//			userRepo.save(user2);
//			User user3 = new User("s1", "$2a$10$3sBybjMrOU2q.mBmsJMJU.3cb7waDnb4mJn7YdUFDlKZ4Pqm9MEgK", "s1@boredborrow.com", "USER");
//			userRepo.save(user3);
		};
	}
}
