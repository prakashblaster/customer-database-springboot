package in.dotworld.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.dotworld.database.model.Game;
import in.dotworld.database.repository.GameRepository;

@Service
public class GameService {

	@Autowired
	GameRepository gRepository;

	public String saveGame(Game game) {
		gRepository.save(game);
		return "game saved";
	}

	public List<Game> getGame() {
		
		return gRepository.findAll();
	}
	
}
