package com.sp.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.repository.CardRepository;

@Service
public class CardService {
	@Autowired
	CardRepository cardRep;
	public void addCard(Card c) {
		Card createdCard=cardRep.save(c);
		System.out.println(createdCard);
	}
	
	public Card getCard(int id) {
		Optional<Card> cOpt = cardRep.findById(id);
		if (cOpt.isPresent()) {
			return cOpt.get();
		}else {
			return null;
		}
	}
	
	@PostConstruct
    public void initializeCards() {
        createStarterCards();
    }
	
	public void createStarterCards() {
		Card c1 = new Card(null, "Lee", "Too fat to be furious", "https://i.pinimg.com/550x/90/70/ba/9070baf6748b91b19d2c7a23cf6c08dd.jpg", "china town", "earth", 66, 25, 46, 79, true, 1000);
        Card c2 = new Card(null, "Bob", "He lives in a submerged Pineapple", "https://static.wikia.nocookie.net/cartoons/images/e/ed/Profile_-_SpongeBob_SquarePants.png/revision/latest?cb=20230305115632", "DBZ", "water", 45, 45, 69, 56, false, 255);
        Card c3 = new Card(null, "Buu", "????????", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQrrKDwogthLDyL6tp_KpsoZA4uEF8WMMlRe--B9ISQA8gjhA4GCPGzU8DDPyEvuxF41Uo&usqp=CAU", "china town", "dark", 66, 25, 46, 79, false, 65);
        Card c4 = new Card(null, "Jimmy", "Massive forehead", "https://static.wikia.nocookie.net/jimmyneutron/images/9/9f/3312415-jimmyhands.jpg/revision/latest?cb=20230417181258", "jetix", "light", 66, 25, 46, 79, true, 86453);
        Card c5 = new Card(null, "Perry", "Half platypus, half secret agent", "https://static.wikia.nocookie.net/milomurphyslaw/images/3/36/PerryFull.png/revision/latest?cb=20190106092031", "disney", "air", 66, 25, 46, 79, false, 876);
        addCard(c1);
        addCard(c2);
        addCard(c3);
        addCard(c4);
        addCard(c5);
	}
}
