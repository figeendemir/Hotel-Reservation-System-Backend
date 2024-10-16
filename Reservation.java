package com.example.hotelapp.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Reservation")
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    private String userName;
    private String email;
    private String name;
    private String surname;
    private BigDecimal price;
    private String roomType;
    private Date date;
    private BigDecimal adultCount;
    private BigDecimal childCount;
    private String phone;

    // Ensure no-args constructor is available
    public Reservation() {
    }
    
	public void setId(Object id) {
		this.id = (Long) id;
	}

	public void setUserName(Object userName) {
		this.userName = (String) userName;	
	}

	public void setEmail(Object email) {
		this.email = (String) email;
	}
	
	public void setName(Object name) {
		this.name = (String) name;
	}
	
	public void setSurname(Object surname) {
		this.surname = (String) surname;
	}

	public void setPrice(Object price) {
		this.price = (BigDecimal) price;
	}

	public void setRoomType(Object roomType) {
		this.roomType = (String) roomType;
	}

	public void setDate(Object date) {
		this.date = (Date) date;
	}

	public void setAdultCount(Object adultCount) {
		this.adultCount = (BigDecimal) adultCount;
	}

	public void setChildCount(Object childCount) {
		this.childCount = (BigDecimal) childCount;
	}

	public void setUser(User user) {
		this.user = user;	
	}
	
	public void setPhone(Object phone) {
		this.phone = (String) phone;	
	}
	
	
	
	
	
	
	
    
}
