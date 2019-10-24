package in.dotworld.database.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_games1")
public class CustomerGames {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long customer_id;

	private Long game_id;

	public CustomerGames() {

	}

	public CustomerGames(Long customer_id, Long game_id) {
		super();
		this.customer_id = customer_id;
		this.game_id = game_id;
	}

	public Long getId() {
		return id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public Long getGame_id() {
		return game_id;
	}

	public void setGame_id(Long game_id) {
		this.game_id = game_id;
	}

}
