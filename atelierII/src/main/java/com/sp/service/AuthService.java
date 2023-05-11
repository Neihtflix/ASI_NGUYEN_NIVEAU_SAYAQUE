package com.sp.service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.User;
import com.sp.model.Card;
import com.sp.repository.CardRepository;
import com.sp.repository.UserRepository;

@Service
public class AuthService {
	@Autowired
	UserService uService;
	@Autowired
	CardService cService;
	@Autowired
	UserRepository uRep;

	
	public void login(String username, String passwd) {
		uService.login(username, passwd);
	}
	
	public int signup(User u) {
		int userId = uService.addUser(u);
		return userId;
	}
	
	public void assignStarterCards(User user) {
	    List<Integer> cardIds = new ArrayList<>();
	    
		int Id1 = 1 + (int)(Math.random() * ((5 - 1) + 1));
		int Id2 = 1 + (int)(Math.random() * ((5 - 1) + 1));
		int Id3 = 1 + (int)(Math.random() * ((5 - 1) + 1));
		
		Card starterc1 = cService.getCard(Id1);
		Card starterc2 = cService.getCard(Id2);
		Card starterc3 = cService.getCard(Id3);
		
		cardIds.add(starterc1.getId());
		cardIds.add(starterc2.getId());
		cardIds.add(starterc3.getId());
		
		cService.addCard(starterc1);
		cService.addCard(starterc2);
		cService.addCard(starterc3);
		
	    user.setCardList(cardIds);
	    uRep.save(user);
	}


}
