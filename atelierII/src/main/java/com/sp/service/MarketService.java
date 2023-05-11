package com.sp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.model.User;

import com.sp.repository.CardRepository;
import com.sp.repository.UserRepository;

@Service
public class MarketService {
	@Autowired
	CardRepository cRepository;
	UserRepository uRepository;
	
	public boolean sellCard(int card_id,int user_id) {
		Optional<User> optUser = uRepository.findById(user_id);
		Optional<Card> optCard = isCardOwned(card_id,optUser);
		if (optCard != null) {
			optCard.get().setSelling(true);
		}
		return false;
	}
	
	public boolean buyCard(int card_id,int user_id) {
		Optional<Card> optCard = cRepository.findById(card_id);
		Optional<User> optUser= uRepository.findById(user_id);
		if (optCard != null) {
			if (optUser != null) {
				if (optCard.get().isSelling()) {
					if (optUser.get().getWallet() > optCard.get().getPrice()) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public List<Card> getCards() {
		int user_id = 1;
		Optional<User> optUser= uRepository.findById(user_id);
		List<Card> lstOwnedCard = new ArrayList();
		
		if (optUser != null) {
			for (int cardId : optUser.get().getCardList()) {
				Optional<Card> card = cRepository.findById(cardId);
				if (card != null) {
					lstOwnedCard.add(card.get());
				}
			}
		}
		return lstOwnedCard;
	}
	
	public List<Card> getCardsToSell() {
		List<Card> lstCard = (List<Card>) cRepository.findAll();
		List<Card> lstSellingCard = new ArrayList();;
		
		for (Card card : lstCard) {
			if (card.isSelling()) {
				lstSellingCard.add(card);
			}
		}
		
		return lstSellingCard;
	}
	
	private Optional<Card> isCardOwned(int card_id,Optional<User> optUser) {
		if (optUser != null) {
			if (optUser.get().getCardList().indexOf(card_id) != -1) {
				return cRepository.findById(card_id);
			}
			
		}
		
		return null;
		
	}
	
	
}