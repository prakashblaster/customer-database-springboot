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
		Customer customer = new Customer(request.getName());
		customer.setApi_key(getAlphaNumericString(25));
		Customer response = cRepository.save(customer);
		return response;
	}

	public List<Customer> getCustomer() {
		return cRepository.findAll();
	}

	public Customer update(CustomerRequest request, String id) {
		Customer customer = cRepository.findById(id).get();
		if (customer != null) {
			if (request.getName() == null) {
				customer.getName();
			} else {
				customer.setName(request.getName());
			}
			cRepository.saveAndFlush(customer);
		} else {
			throw new RuntimeException("customer not found");
		}
		return customer;
	}

	public List<Customer> deleteCustomer(String id) {
		Customer customer = cRepository.findById(id).get();
		cRepository.delete(customer);

		return cRepository.findAll();
	}

	public Customer resetApiKey(String id) {
		Customer customer = cRepository.findById(id).get();
		if (customer != null) {
			customer.setApi_key(getAlphaNumericString(25));
			Customer customer2 = cRepository.saveAndFlush(customer);
			return customer2;
		} else {
			throw new RuntimeException("customer not found");
		}
	}

	public Customer getCustomerById(String id) {
		Customer customer = cRepository.findById(id).get();
		return customer;
	}

	static String getAlphaNumericString(int n) {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

}
