package com.standalone.examples.blackjack;

import java.util.List;
import java.util.Scanner;

/*
 * Players can play blackjack game
 */
public class BlackJack implements Game{

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many players would like to play?");
		int totalPlayers = scanner.nextInt();
		if (totalPlayers >1 && totalPlayers <= 6){
			System.out.println("valid number of users");
			Dealer dealer = new Dealer();
			List<String> playerCards = dealer.giveCards();
			int totalValueOfCards = CardValue.getCardValue(playerCards);
			
			checkIfBlackJack(playerCards, totalValueOfCards);
			
		} else {
			System.out.println("Invalid number of users.");
			System.exit(0);
		}
	}

	private void checkIfBlackJack(List<String> playerCards, int totalValueCards) {
		System.out.println("Total value of cards is :"+ totalValueCards);
		if (totalValueCards < 17) {
			Dealer dealer = new Dealer();
			dealer.addNewCard(playerCards);
			checkIfBlackJack(playerCards, CardValue.getCardValue(playerCards));
		} else if(totalValueCards >= 17 && totalValueCards < 21) {
			
		} else {
			System.out.println("You got busted");
			System.exit(0);
		}
	}
}
