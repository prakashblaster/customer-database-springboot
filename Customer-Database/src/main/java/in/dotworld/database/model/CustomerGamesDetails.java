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
	private Long customer_games_id;

	private Date date;

	private int count;
	
	public CustomerGamesDetails() {
		
	}

	public CustomerGamesDetails(Long customer_games_id, Date date, int count) {
		super();
		this.customer_games_id = customer_games_id;
		this.date = date;
		this.count = count;
	}

	public Long getCustomer_games_id() {
		return customer_games_id;
	}

	public void setCustomer_games_id(Long customer_games_id) {
		this.customer_games_id = customer_games_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	

}
