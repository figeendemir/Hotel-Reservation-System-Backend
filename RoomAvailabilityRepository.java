package com.example.hotelapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.hotelapp.entities.RoomAvailability;

@Repository
public interface RoomAvailabilityRepository extends JpaRepository<RoomAvailability, Long> {
    // Additional query methods, if needed
}
