package in.dotworld.database.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "customer_games1")
public class CustomerGames {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long customer_id;
	
	private Long game_id;
	
	@CreatedDate
	private Date viewd_at;
	
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

	public Date getViewd_at() {
		return viewd_at;
	}

	public void setViewd_at(Date viewd_at) {
		this.viewd_at = viewd_at;
	}

	

}
