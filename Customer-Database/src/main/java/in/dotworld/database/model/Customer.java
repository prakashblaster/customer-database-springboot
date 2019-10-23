package in.dotworld.database.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String name;
	
	private String api_key;
	
	public Customer() {
		
	}
	
	public Customer(String name, String api_key) {
		super();
		this.name = name;
		this.api_key = api_key;
	}

	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getApi_key() {
		return api_key;
	}
	public void setApi_key(String api_key) {
		this.api_key = api_key;
	}
	
	
}
