package com.example.hotelapp.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Card")
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    private String userName;
    private String cardname;
    private String cardnumber;
    private String csv;
    private Date expdate;
    
    
    public void setId(Object id) {
		this.id = (Long) id;
	}

	public void setUserName(Object userName) {
		this.userName = (String) userName;	
	}

	public void setCardnumber(Object cardnumber) {
		this.cardnumber = (String) cardnumber;
	}
	
	public void setCsv(Object csv) {
		this.csv = (String) csv;
	}
	

	public void setExpdate(Object expdate) {
		this.expdate = (Date) expdate;
	}

	public void setUser(User user) {
		this.user = user;	
	}

	public void setCardname(Object cardname) {
		this.cardname = (String) cardname;

		
	}

    
}
    
    