package com.example.hotelapp.requests;

import java.math.BigDecimal;
import java.util.Date;

public class CardCreateRequest {
	
	Long id;
    Long userId;
	private String userName;
    private String cardname;
    private String cardnumber;
    private String csv;
    private Date expdate;

	public Long getUserId() {
		return userId;
	}

	public Object getId() {
		return id;

	}

	public Object getUserName() {
		return userName;
	}

	public Object getCardnumber() {
		return cardnumber;
	}
	
	public Object getCsv() {
		return csv;
	}
	
	public Object getExpdate() {
		return expdate;
	}

	public Object getCardname() {
		return cardname;
	}
	
	

}
