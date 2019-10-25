package in.dotworld.database.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "customer_game_details")
public class CustomerGamesDetails {


	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	private String customer_games_id;

	private Date date;

	private int count;
	
	public CustomerGamesDetails() {
		
	}

	public CustomerGamesDetails(String customer_games_id, Date date, int count) {
		super();
		this.customer_games_id = customer_games_id;
		this.date = date;
		this.count = count;
	}

	public String getCustomer_games_id() {
		return customer_games_id;
	}

	public void setCustomer_games_id(String customer_games_id) {
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
