package com.example.hotelapp.requests;

import lombok.Data;

@Data
public class ContactCreateRequest {
    private String name;
    private String surname;
    private String email;
    private String text;
    
	public String getName() {
		return name;
	}

	public Object getSurname() {
		return surname;
	}

	public Object getEmail() {
		return email;
	}

	public Object getText() {
		return text;
	}
	

	
	
}
