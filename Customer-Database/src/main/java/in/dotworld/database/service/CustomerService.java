package in.dotworld.database.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.dotworld.database.model.Customer;
import in.dotworld.database.payload.CustomerRequest;
import in.dotworld.database.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository cRepository;

	public Customer saveCompliant(CustomerRequest request) {
		UUID uuid = UUID.randomUUID();
		Customer customer=new Customer(request.getName());
		customer.setApi_key(uuid.toString());
		Customer response=cRepository.save(customer);
		return response;
	}

	public List<Customer> getCustomer() {
		return cRepository.findAll();
	}

	public Customer update(CustomerRequest request, Long id) {
		Customer customer=cRepository.findById(id).get();
		if (customer != null) {
			if (request.getName() ==null) {
				customer.getName();
			}else {
				customer.setName(request.getName());
			}
			cRepository.saveAndFlush(customer);
		}else {
			throw new RuntimeException("customer not found");
		}
		return customer;
	}

	public String deleteCustomer(Long id) {
		Customer customer = cRepository.findById(id).get();
		cRepository.delete(customer);
		
		return "customer deleted successfully";
	}
	

}
