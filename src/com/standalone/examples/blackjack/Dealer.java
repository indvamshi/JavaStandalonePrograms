package com.standalone.examples.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

    String[] card = { "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"};
    
/*	public String[] shuffleCards() {
	    for (int i = 0; i <= 0; i++) {
	        int randomGenNumber = (int) (Math.random()*13);

	        card[randomGenNumber];
	    }
	}*/
    
    public void addNewCard(List<String> player) {
    	player.add(card[getRandomCard()]);
    }
	
	public List<String> giveCards() {
		List<String> player = new ArrayList<String>();
		for(int i = 0; i <= 1; i++){
			player.add(card[getRandomCard()]);
		}
		return player;
	}
	
	private int getRandomCard() {
		return (int) (Math.random()*13);
	}
}
