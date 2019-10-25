package in.dotworld.database.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.dotworld.database.model.Customer;
import in.dotworld.database.payload.CustomerRequest;
import in.dotworld.database.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerService service;

	@PostMapping("")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Customer saveCompliant(@RequestBody CustomerRequest customer) {
		return service.saveCompliant(customer);
	}

	@GetMapping("")
	public List<Customer> viewCustomers() {
		return service.getCustomer();
	}
	
	@GetMapping("/{id}")
	public Customer viewById(@PathVariable String id) {
		return service.getCustomerById(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Customer updateAll(@Valid @RequestBody CustomerRequest customer, @PathVariable String id) {
		return service.update(customer, id);

	}

	 @PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public List<Customer> deleteCustomer(@PathVariable String id) {
		return service.deleteCustomer(id);
	}

	@PutMapping("/refresh/api/{id}")
	public Customer resetApi(@PathVariable String id) {
		return service.resetApiKey(id);
		
	}
}
