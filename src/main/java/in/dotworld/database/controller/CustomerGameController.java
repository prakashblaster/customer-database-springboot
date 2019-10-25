package in.dotworld.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.dotworld.database.model.Customer;
import in.dotworld.database.model.CustomerGames;
import in.dotworld.database.model.CustomerGamesDetails;
import in.dotworld.database.model.Game;
import in.dotworld.database.payload.CustomerGameDetailsRequest;
import in.dotworld.database.payload.CustomerGamesRequest;
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

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/customers/games")
	public CustomerGames gameAccess(@RequestBody CustomerGamesRequest request) {
		Customer customer=cRepository.findById(request.getCustomer_id()).get();
		Game game=gRepository.findById(request.getGame_id()).get();
		if (customer == null || game == null) {
			throw new RuntimeException("customer or game not found");
		}else {
			CustomerGames customerGames= new CustomerGames(customer.getCustomer_id(), game.getGame_id());
			customer.getGame().add(game);
			cRepository.save(customer);
			cgRepository.save(customerGames);
			return customerGames;
		}

		
	}

	@PostMapping("/details")
	public CustomerGamesDetails customerAndGameDetails(@RequestBody CustomerGameDetailsRequest request) {
		
	CustomerGames customerGames=cgRepository.findById(request.getId()).get();
	if (customerGames!=null) {
		CustomerGamesDetails customerGamesDetails=new CustomerGamesDetails(request.getId(), request.getDate(), request.getCount());
		return details.save(customerGamesDetails);
	}else {
		throw new RuntimeException("id not matching");
	}
	
	}
}
