package in.dotworld.database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.dotworld.database.model.Customer;
import in.dotworld.database.service.CustomerService;


@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@PostMapping("")
	@ResponseStatus(value = HttpStatus.CREATED)
	public String saveCompliant(@RequestBody Customer customer) {
		return service.saveCompliant(customer);
	}
	
	@GetMapping("")
	public List<Customer> viewCustomers(){
		return service.getCustomer();
	}

}
