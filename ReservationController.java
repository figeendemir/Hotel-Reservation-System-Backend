package com.example.hotelapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotelapp.entities.Reservation;
import com.example.hotelapp.requests.ReservationCreateRequest;
import com.example.hotelapp.requests.ReservationUpdateRequest;
import com.example.hotelapp.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    
    @GetMapping
    public List<Reservation> getAllReservations(@RequestParam Optional<Long> userId) {
        return reservationService.getAllReservations(userId);
    }
    
    @PostMapping
    public Reservation createOneReservation(@RequestBody ReservationCreateRequest newReservationRequest) {
        return reservationService.createOneReservation(newReservationRequest);
    }
    
    @GetMapping("/{reservationId}")
    public Reservation getOneReservation(@PathVariable Long reservationId) {
        return reservationService.getOneReservationById(reservationId);
    }
    
    @PutMapping("/{reservationId}")
    public Reservation updateOneReservation(@PathVariable Long reservationId, @RequestBody ReservationUpdateRequest updateReservation) {
    	return reservationService.updateOneReservationById(reservationId, updateReservation);
    }
    
    @DeleteMapping("/{reservationId}")
    public void deleteOneReservation(@PathVariable Long reservationId) {
    	reservationService.deleteOneReservationById(reservationId);
    }
}


