package com.example.hotelapp.requests;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class ReservationCreateRequest {
    
    Long id;
    Long userId;
    String userName;
    String email;
    String name;
    String surname;
    BigDecimal price;
    String roomType;
    Date date;
    BigDecimal adultCount;
    BigDecimal childCount;
    String phone;

    public Long getUserId() {
        return userId;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public BigDecimal getPrice() {
        return price;
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

	public Object getPhone() {
		return phone;
	}


}
