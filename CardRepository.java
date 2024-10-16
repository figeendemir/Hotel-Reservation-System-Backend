package com.example.hotelapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hotelapp.entities.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByUserId(Long userId);
}
