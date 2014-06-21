package com.standalone.examples.blackjack;

import java.util.List;

public class CardValue {

	public static int getCardValue(List<String> cards) {
		int usersValue = 0;
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).equals("2")) {
				usersValue += 2;
			} else if (cards.get(i).equals("3")) {
				usersValue += 3;
			} else if (cards.get(i).equals("4")) {
				usersValue += 4;
			} else if (cards.get(i).equals("5")) {
				usersValue += 5;
			} else if (cards.get(i).equals("6")) {
				usersValue += 6;
			} else if (cards.get(i).equals("7")) {
				usersValue += 7;
			} else if (cards.get(i).equals("8")) {
				usersValue += 8;
			} else if (cards.get(i).equals("9")) {
				usersValue += 9;
			} else if (cards.get(i).equals("10")) {
				usersValue += 10;
			} else if (cards.get(i).equals("Jack")) {
				usersValue += 10;
			} else if (cards.get(i).equals("Queen")) {
				usersValue += 10;
			} else if (cards.get(i).equals("King")) {
				usersValue += 10;
			} else if (cards.get(i).equals("Ace")) {
				usersValue += 11;
			}
		}
		return usersValue;
	}
}
