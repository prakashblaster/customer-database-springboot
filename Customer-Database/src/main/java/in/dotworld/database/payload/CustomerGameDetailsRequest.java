package in.dotworld.database.payload;

import java.util.Date;

public class CustomerGameDetailsRequest {

	private Long id;
	
	private Date date;
	
	private int count;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
