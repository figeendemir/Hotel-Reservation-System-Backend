package com.example.hotelapp.requests;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class ReservationUpdateRequest {
	
	String email;
	String name;
	String surname;
	String userName;
	String roomType;
	Date date;
	BigDecimal adultCount; 
	BigDecimal childCount;
	
	public String getEmail() {
		return email;
	}

	public String getUserName() {
		return userName;
	}

	public String getRoomType() {
		return roomType;
	}

	public Date getDate() {
		return date;
	}

	public BigDecimal getAdultCount() {
		return adultCount;
	}

	public BigDecimal getChildCount() {
		return childCount;
	}

	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	
	
	

}
