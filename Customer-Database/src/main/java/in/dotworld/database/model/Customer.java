package in.dotworld.database.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customer_id;

	@NotBlank
	private String name;

	private String api_key;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "customer_games", joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns = @JoinColumn(name = "game_id"))
	private Set<Game> game = new HashSet<>();

	public Customer() {

	}

	public Customer(String name) {
		super();
		this.name = name;
	}

	public Long getCustomer_id() {
		return customer_id;
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

	public Set<Game> getGame() {
		return game;
	}

	public void setGame(Set<Game> game) {
		this.game = game;
	}

}
