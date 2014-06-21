package com.standalone.examples.blackjack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Deck {

	private Card[] deck;

	private int numCards;
	
	private ArrayList stack = new ArrayList();

	public Deck(int numDecks) {
		this.numCards = numDecks * 52;
		this.deck = new Card[this.numCards];

		/*
		 * int c = 0; for (int d = 0; d < numDecks; d++) { for (int s = 0; s < 4
		 * ; s++){ for (int n = 1; n <= 13 ; n++) { this.cards[c] = new
		 * Card(Suit.SUITS.get(s), ) } } }
		 */

		@SuppressWarnings("rawtypes")
		Iterator suits = Suit.SUITS.iterator();

		int counter = 0;
		while (suits.hasNext()) {
			Suit suit = (Suit) suits.next();
			@SuppressWarnings("rawtypes")
			Iterator ranks = Rank.RANKS.iterator();
			while (ranks.hasNext()) {
				Rank rank = (Rank) ranks.next();
				deck[counter] = new Card(suit, rank);
				counter++;
			}
		}
	}
	
    private void randomize() {
        Random rand = new Random();
        int num_cards = this.numCards; 
        for( int i = 0; i < num_cards; i ++ ) {
            int index = rand.nextInt( num_cards );
            Card card_i = (Card) stack.get( i );
            Card card_index = (Card) stack.get( index );
            stack.set( i, card_index );
            stack.set( index, card_i );
        }
    }
}
