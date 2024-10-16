package com.example.hotelapp.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.hotelapp.entities.Reservation;
import com.example.hotelapp.entities.User;
import com.example.hotelapp.repos.ReservationRepository;
import com.example.hotelapp.requests.ReservationCreateRequest;
import com.example.hotelapp.requests.ReservationUpdateRequest;

@Service
public class ReservationService {

	private ReservationRepository reservationRepository;
	private UserService userService;

	public ReservationService(ReservationRepository reservationRepository, UserService userService) {
		this.reservationRepository = reservationRepository;
		this.userService = userService;
	}

	public List<Reservation> getAllReservations(Optional<Long> userId) {
		if (userId.isPresent()) 
			return reservationRepository.findByUserId(userId.get());
		return reservationRepository.findAll();
	}

	public Reservation getOneReservationById(Long reservationId) {
		return reservationRepository.findById(reservationId).orElse(null);
	}

	public Reservation createOneReservation(ReservationCreateRequest newReservationRequest) {
	    Long userId = newReservationRequest.getUserId();
	    if (userId == null) {
	        throw new IllegalArgumentException("User ID must not be null");
	    }

	    User user = userService.getOneUser(userId);
	    if (user == null) {
	        return null;
	    }

	    Reservation toSave = new Reservation();
	    toSave.setId(newReservationRequest.getId());
	    toSave.setUserName(newReservationRequest.getUserName());
	    toSave.setEmail(newReservationRequest.getEmail());
	    toSave.setName(newReservationRequest.getName());
	    toSave.setSurname(newReservationRequest.getSurname());
	    toSave.setPrice(newReservationRequest.getPrice());
	    toSave.setRoomType(newReservationRequest.getRoomType());
	    toSave.setDate(newReservationRequest.getDate());
	    toSave.setAdultCount(newReservationRequest.getAdultCount());
	    toSave.setChildCount(newReservationRequest.getChildCount());
	    toSave.setPhone(newReservationRequest.getPhone());
	    toSave.setUser(user);
	    return reservationRepository.save(toSave);
	}


	public void deleteOneReservationById(Long reservationId) {
		reservationRepository.deleteById(reservationId);
		
	}

	public Reservation updateOneReservationById(Long reservationId, ReservationUpdateRequest updateReservation) {
		Optional<Reservation> reservation = reservationRepository.findById(reservationId);
		if (reservation.isPresent()) {
			Reservation toUpdate = reservation.get();
			toUpdate.setEmail(updateReservation.getEmail());
			toUpdate.setName(updateReservation.getName());
			toUpdate.setSurname(updateReservation.getSurname());
			toUpdate.setUserName(updateReservation.getUserName());
			toUpdate.setRoomType(updateReservation.getRoomType());
			toUpdate.setDate(updateReservation.getDate());
			toUpdate.setAdultCount(updateReservation.getAdultCount());
			toUpdate.setChildCount(updateReservation.getChildCount());
			reservationRepository.save(toUpdate);
			return toUpdate;
		}
		
		return null;
	}
}
