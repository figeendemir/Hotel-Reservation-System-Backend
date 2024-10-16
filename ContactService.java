package com.example.hotelapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hotelapp.entities.Contact;
import com.example.hotelapp.repos.ContactRepository;
import com.example.hotelapp.requests.ContactCreateRequest;

import java.util.UUID;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact createContact(ContactCreateRequest request) {
        Contact contact = new Contact();
        contact.setId(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE); // Generate a unique ID
        contact.setName(request.getName());
        contact.setSurname(request.getSurname());
        contact.setEmail(request.getEmail());
        contact.setText(request.getText());
        return contactRepository.save(contact);
    }
}
