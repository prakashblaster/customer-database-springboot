package in.dotworld.database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.dotworld.database.model.Game;
import in.dotworld.database.payload.GameRequest;
import in.dotworld.database.service.GameService;

@RestController
@RequestMapping("/games")
public class GameController {
	@Autowired
	GameService service;

	@PostMapping("")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Game saveGame(@RequestBody GameRequest request) {
		return service.saveGame(request);
	}

	@GetMapping("")
	public List<Game> viewGame() {
		return service.getGame();
	}

}