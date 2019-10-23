package in.dotworld.database.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.dotworld.database.model.Customer;
import in.dotworld.database.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository cRepository;

	public String saveCompliant(Customer customer) {
		UUID uuid = UUID.randomUUID();
		customer.setApi_key(uuid.toString());
		cRepository.save(customer);
		return "saved successfully";
	}

	public List<Customer> getCustomer() {

		return cRepository.findAll();
	}
	
}
