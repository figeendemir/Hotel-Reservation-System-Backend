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

import com.example.hotelapp.entities.Card;
import com.example.hotelapp.requests.CardCreateRequest;
import com.example.hotelapp.requests.CardUpdateRequest;
import com.example.hotelapp.service.CardService;

@RestController
@RequestMapping("/cards")
public class CardController {

    private CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }
    
    @GetMapping
    public List<Card> getAllCards(@RequestParam Optional<Long> userId) {
        return cardService.getAllCards(userId);
    }
    
    @PostMapping
    public Card createOneCard(@RequestBody CardCreateRequest newCardRequest) {
        return cardService.createOneCard(newCardRequest);
    }
    
    @GetMapping("/{cardId}")
    public Card getOneCard(@PathVariable Long cardId) {
        return cardService.getOneCardById(cardId);
    }
    
    @PutMapping("/{cardId}")
    public Card updateOneCard(@PathVariable Long cardId, @RequestBody CardUpdateRequest updateCard) {
    	return cardService.updateOneCardById(cardId, updateCard);
    }
    
    @DeleteMapping("/{cardId}")
    public void deleteOnecard(@PathVariable Long cardId) {
    	cardService.deleteOneCardById(cardId);
    }
}


