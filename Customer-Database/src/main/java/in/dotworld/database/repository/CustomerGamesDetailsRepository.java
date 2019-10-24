package in.dotworld.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.dotworld.database.model.CustomerGamesDetails;

public interface CustomerGamesDetailsRepository extends JpaRepository<CustomerGamesDetails, Long> {

}
