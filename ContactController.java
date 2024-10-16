package com.example.hotelapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.hotelapp.entities.Contact;
import com.example.hotelapp.requests.ContactCreateRequest;
import com.example.hotelapp.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody ContactCreateRequest request) {
        Contact contact = contactService.createContact(request);
        return ResponseEntity.ok(contact);
    }
}

