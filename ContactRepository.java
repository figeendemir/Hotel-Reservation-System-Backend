package com.example.hotelapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hotelapp.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}