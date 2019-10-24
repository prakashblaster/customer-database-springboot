package in.dotworld.database.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_game_details")
public class CustomerGamesDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long details_id;
	
	private Long customer_games_id;
	
	private String customer_name;
	
	private Date viewed_at;

	public CustomerGamesDetails( Long customer_games_id, String customer_name, Date viewed_at) {
		super();
		this.customer_games_id = customer_games_id;
		this.customer_name = customer_name;
		this.viewed_at = viewed_at;
	}

	public Long getDetails_id() {
		return details_id;
	}

	public Long getCustomer_games_id() {
		return customer_games_id;
	}

	public void setCustomer_games_id(Long customer_games_id) {
		this.customer_games_id = customer_games_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public Date getViewed_at() {
		return viewed_at;
	}

	public void setViewed_at(Date viewed_at) {
		this.viewed_at = viewed_at;
	}
	
	
	
	

}
