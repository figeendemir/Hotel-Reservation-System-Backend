package com.example.hotelapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Contact")
@Data
public class Contact {
    
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;

    @Lob
    @Column(columnDefinition = "Text")
    private String text;
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setName(Object name) {
        this.name = (String) name;
    }
    
    public void setSurname(Object surname) {
        this.surname = (String) surname;
    }
    
    public void setEmail(Object email) {
        this.email = (String) email;
    }
    
    public void setText(Object text) {
        this.text = (String) text;
    }
    

}
