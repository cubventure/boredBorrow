package com.gamerental.boredborrow.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

@Controller //handles request and returns a model map with data then selecting the view to render
public class GameController {
	
	//Inject instances of all repositories
	@Autowired
	GameRepository gameRepo;
	@Autowired
	private GenreRepository genreRepo;
	@Autowired
	private LanguageRepository langRepo;
	@Autowired
	private TypeRepository typeRepo;
	@Autowired
	private UserRepository userRepo;
	
//MVC Controllers -- Return a view
	
	//Login
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	//Show all games
	@RequestMapping("/games")
	public String games(Model model) {
		model.addAttribute("games", gameRepo.findAll());
		return "games"; //returns games.html in templates
	}
	
//Settings controllers	
	//Show settings
		@RequestMapping("/settings")
		public String settings(Model model) {
			model.addAttribute("genres", genreRepo.findAll());
			model.addAttribute("languages", langRepo.findAll());
			model.addAttribute("types", typeRepo.findAll());
			model.addAttribute("users", userRepo.findAll());
			model.addAttribute("genre", new Genre());
			model.addAttribute("language", new Language());
			model.addAttribute("type", new Type());
			model.addAttribute("user", new User());
			return "settings"; //returns settings.html in templates
		}
		
		//Save genre form data from adding a genre and reload settings page
		@RequestMapping("/savegenre")
		public String saveGenre(Genre genre) {
			genreRepo.save(genre);
			return "redirect:settings";
		}
		
		//Delete a genre
		@RequestMapping("/deletegenre/{id}")
		public String deleteGenre(@PathVariable("id") Long genreid, Model model) {
			genreRepo.delete(genreid); //delete() was replaced with deleteById() in new Spring || !CHANGE THIS!!!
			return "redirect:../settings";
		}
		
		//Save language form data from adding a language and reload settings page
		@RequestMapping("/savelanguage")
		public String saveLanguage(Language language) {
			langRepo.save(language);
			return "redirect:settings";
		}
				
		//Delete a language
		@RequestMapping("/deletelanguage/{id}")
		public String deleteLanguage(@PathVariable("id") Long languageid, Model model) {
			langRepo.delete(languageid); //delete() was replaced with deleteById() in new Spring || !CHANGE THIS!!!
			return "redirect:../settings";
		}
		
		//Save type (platform) form data from adding a language and reload settings page
		@RequestMapping("/savetype")
		public String saveType(Type type) {
			typeRepo.save(type);
			return "redirect:settings";
		}
				
		//Delete a type (platform)
		@RequestMapping("/deletetype/{id}")
		public String deleteType(@PathVariable("id") Long typeid, Model model) {
			typeRepo.delete(typeid); //delete() was replaced with deleteById() in new Spring || !CHANGE THIS!!!
			return "redirect:../settings";
		}
		
		//Save user form data from adding a user and reload settings page
		@RequestMapping("/saveuser")
		public String saveUser(User user) {
			userRepo.save(user);
			return "redirect:settings";
		}
				
		//Delete a user
		@RequestMapping("/deleteuser/{id}")
		public String deleteUser(@PathVariable("id") Long id, Model model) {
			userRepo.delete(id); //delete() was replaced with deleteById() in new Spring || !CHANGE THIS!!!
			return "redirect:../settings";
		}
	
//// Users
	//Reserve a game
		@RequestMapping("/reserve/{id}/{username}")
		public String addReservation(@PathVariable("id") Long gameid, @PathVariable("username") String username, Model model) {
			gameRepo.findOne(gameid).setReservedBy(userRepo.findByUsername(username));
			gameRepo.save(gameRepo.findOne(gameid));
			return "redirect:../../games";
		}
	//Cancel a reservation --user
		@RequestMapping("/cancel/{id}/{username}")
		public String cancelReservation(@PathVariable("id") Long gameid, @PathVariable("username") String username, Model model) {
			gameRepo.findOne(gameid).setReservedBy(null);
			gameRepo.save(gameRepo.findOne(gameid));
			model.addAttribute("games", gameRepo.findByReservedBy(userRepo.findByUsername(username)));
			return "borrowlist";
		}		
	//Cancel a reservation --admin
			@RequestMapping("/cancel/{id}")
			public String cancelReservationAdmin(@PathVariable("id") Long gameid, Model model) {
				gameRepo.findOne(gameid).setReservedBy(null);
				gameRepo.save(gameRepo.findOne(gameid));
				model.addAttribute("games", gameRepo.findAll());
				return "borrowlist";
			}
	//Loan a game ADMIN
	@RequestMapping("/loan/{id}/{username}")
	public String addLoan(@PathVariable("id") Long gameid, @PathVariable("username") String username, Model model) {
		gameRepo.findOne(gameid).setBorrowedBy(userRepo.findByUsername(username));
		gameRepo.findOne(gameid).setReservedBy(null);
		gameRepo.save(gameRepo.findOne(gameid));
		model.addAttribute("games", gameRepo.findAll());
		return "borrowlist";
	}
	//Return a loan ADMIN
	@RequestMapping("/return/{id}")
	public String returnLoan(@PathVariable("id") Long gameid, Model model) {
		gameRepo.findOne(gameid).setBorrowedBy(null);
		gameRepo.save(gameRepo.findOne(gameid));
		model.addAttribute("games", gameRepo.findAll());
		return "borrowlist";
	}
		
	//Reservations Borrow list ---user link ONLY WORKES WHEN BORROWED BY NOT USED
		@RequestMapping("/reservations/{username}")
		public String userReservations(@PathVariable("username") String username, Model model) {
			model.addAttribute("games", gameRepo.findByReservedBy(userRepo.findByUsername(username)));
			//model.addAttribute("games", gameRepo.findAll());
			return "borrowlist"; 
		}
		
	//Loans Borrow list ---user link ONLY WORKES WHEN BORROWED BY NOT USED
	@RequestMapping("/loans/{username}")
	public String userLoans(@PathVariable("username") String username, Model model) {
		model.addAttribute("games", gameRepo.findByBorrowedBy(userRepo.findByUsername(username)));
		//model.addAttribute("games", gameRepo.findAll());
		return "borrowlist"; 
	}
	
	//Borrow list ---admin list
		@RequestMapping("/borrowlist/admin")
		public String adminGames(Model model) {
			model.addAttribute("games", gameRepo.findAll());
			return "borrowlist"; //returns games.html in templates
		}
	
//Adding games
	//Add a game
	@RequestMapping("/add")
	public String addGame(Model model) {
		model.addAttribute("game", new Game());
		model.addAttribute("genres", genreRepo.findAll());
		model.addAttribute("languages", langRepo.findAll());
		model.addAttribute("types", typeRepo.findAll());
		model.addAttribute("users", userRepo.findAll());
		return "addgame";
	}
	
		//Edit a game
		@RequestMapping("/edit/{id}") //edits the tuple appropriate id
		public String editGame(@PathVariable("id") Long gameid, Model model) {
			model.addAttribute("game", gameRepo.findOne(gameid)); //findOne() was replaced with findById() in new Spring || !CHANGE THIS!!
			model.addAttribute("genres", genreRepo.findAll());
			model.addAttribute("languages", langRepo.findAll());
			model.addAttribute("types", typeRepo.findAll());
			return "editgame";
		}
		
		//Save the form data from adding a game and return to games page
		@RequestMapping("/save")
		public String saveGame(Game game) {
			gameRepo.save(game);
			return "redirect:games";
		}
		
		//Delete a game
		@RequestMapping("/delete/{id}")
		public String deleteGame(@PathVariable("id") Long gameid, Model model) {
			gameRepo.delete(gameid); //delete() was replaced with deleteById() in new Spring || !CHANGE THIS!!!
			return "redirect:../games";
		}

//REST Controllers -- Returns a HTTP response body
	
	// RESTful service to get all games
	@RequestMapping(value="/rest/games", method = RequestMethod.GET)
	public @ResponseBody List<Game> gamesRest() {
		return (List<Game>) gameRepo.findAll();
	}
	
	// RESTful service to get game by id
	@RequestMapping(value="/rest/games/{id}", method = RequestMethod.GET)
	public @ResponseBody Game findGameRest(@PathVariable("id") Long gameid) { //Game changed to Optional<Game> to work || !CHANGE THIS!!
		return gameRepo.findOne(gameid); //findOne() was replaced with findById() in new Spring || !CHANGE THIS!!
	}
	
}
