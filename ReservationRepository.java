package com.example.hotelapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hotelapp.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	List<Reservation> findByUserId(Long userId);

}
