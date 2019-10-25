package in.dotworld.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.dotworld.database.model.CustomerGames;

public interface CustomerGamesRepository extends JpaRepository<CustomerGames, String>{

}
