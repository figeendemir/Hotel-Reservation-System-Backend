package com.example.hotelapp.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.hotelapp.entities.Card;
import com.example.hotelapp.entities.User;
import com.example.hotelapp.repos.CardRepository;
import com.example.hotelapp.requests.CardCreateRequest;
import com.example.hotelapp.requests.CardUpdateRequest;

@Service
public class CardService {

	private CardRepository cardRepository;
	private UserService userService;

	public CardService(CardRepository cardRepository, UserService userService) {
		this.cardRepository = cardRepository;
		this.userService = userService;
	}

	public List<Card> getAllCards(Optional<Long> userId) {
		if (userId.isPresent()) 
			return cardRepository.findByUserId(userId.get());
		return cardRepository.findAll();
	}

	public Card getOneCardById(Long cardId) {
		return cardRepository.findById(cardId).orElse(null);
	}

	public Card createOneCard(CardCreateRequest newCardRequest) {
	    Long userId = newCardRequest.getUserId();
	    if (userId == null) {
	        throw new IllegalArgumentException("User ID must not be null");
	    }

	    User user = userService.getOneUser(userId);
	    if (user == null) {
	        return null;
	    }

	    Card toSave = new Card();
	    toSave.setId(newCardRequest.getId());
	    toSave.setUserName(newCardRequest.getUserName());
	    toSave.setCardname(newCardRequest.getCardname());
	    toSave.setCardnumber(newCardRequest.getCardnumber());
	    toSave.setCsv(newCardRequest.getCsv());
	    toSave.setExpdate(newCardRequest.getExpdate());
	    toSave.setUser(user);
	    return cardRepository.save(toSave);
	}

	public Card updateOneCardById(Long cardId, CardUpdateRequest updateCard) {
		Optional<Card> card = cardRepository.findById(cardId);
		if (card.isPresent()) {
			Card toUpdate = card.get();
			toUpdate.setUserName(updateCard.getUserName());
		    toUpdate.setCardname(updateCard.getCardname());
		    toUpdate.setCardnumber(updateCard.getCardnumber());
		    toUpdate.setCsv(updateCard.getCsv());
		    toUpdate.setExpdate(updateCard.getExpdate());
			cardRepository.save(toUpdate);
			return toUpdate;
		}
		
		return null;
	}

	public void deleteOneCardById(Long cardId) {
		cardRepository.deleteById(cardId);
		
	}
}

