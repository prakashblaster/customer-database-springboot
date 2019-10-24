package in.dotworld.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.dotworld.database.model.Customer;
import in.dotworld.database.model.CustomerGames;
import in.dotworld.database.model.CustomerGamesDetails;
import in.dotworld.database.model.Game;
import in.dotworld.database.repository.CustomerGamesDetailsRepository;
import in.dotworld.database.repository.CustomerGamesRepository;
import in.dotworld.database.repository.CustomerRepository;
import in.dotworld.database.repository.GameRepository;

@RestController
public class CustomerGameController {

	@Autowired
	CustomerRepository cRepository;
	
	@Autowired
	GameRepository gRepository;
	
	@Autowired
	CustomerGamesRepository cgRepository;
	
	@Autowired
	CustomerGamesDetailsRepository details;
	
	@GetMapping("customers/{customer_id}/games/{game_id}")
	public Customer getCustomerAndGame(@PathVariable Long customer_id, @PathVariable Long game_id) {
		Customer customer=cRepository.findById(customer_id).get();
		Game game=gRepository.findById(game_id).get();
		CustomerGames customerGames=new CustomerGames(customer_id,game_id);
		if (customer==null || game==null) {
			throw new RuntimeException("customer or game not found");
		}else {
			customer.getGame().add(game);
			cRepository.save(customer);
			cgRepository.save(customerGames);
			return customer;
		}
		
	}
	
	@GetMapping("customers/games/{id}")
	public CustomerGamesDetails customerAndGameDetails(@PathVariable Long id){
		CustomerGames customerDetails=cgRepository.findById(id).get();
		Customer customer=cRepository.findById(customerDetails.getCustomer_id()).get();
		CustomerGamesDetails customerGamesDetails=new CustomerGamesDetails(customerDetails.getCustomer_id(),customer.getName(),
				customerDetails.getViewd_at());
		return details.save(customerGamesDetails);
		
		
	}
}
