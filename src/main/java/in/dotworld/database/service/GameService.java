package in.dotworld.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.dotworld.database.model.Game;
import in.dotworld.database.payload.GameRequest;
import in.dotworld.database.repository.GameRepository;

@Service
public class GameService {

	@Autowired
	GameRepository gRepository;

	public Game saveGame(GameRequest request) {
		Game game = new Game(request.getGameName());
		gRepository.save(game);
		return gRepository.save(game);
	}

	public List<Game> getGame() {
		return gRepository.findAll();
	}

	public Game gameById(String game_id) {
		Game game=gRepository.findById(game_id).get();
		return game;
	}
	
	public List<Game> deleteGame(String id) {
		Game game=gRepository.findById(id).get();
		gRepository.delete(game);
		return gRepository.findAll();
	}

	public Game update(String id) {
		Game game = gRepository.findById(id).get();
		return gRepository.saveAndFlush(game);
	}

}
