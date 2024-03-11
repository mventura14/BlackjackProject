package com.skilldistillery.blackjack.game;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Hand;

public class BlackJackHand extends Hand {

	@Override
	public int getHandValue() {
		int total = 0;
		for (Card card : cardsInHand) {
			total += card.getValue();
		}

		for (Card card : cardsInHand) {
			if (total > 21 && (card.getValue() == 11)) {
				total -= 10;
			}

		}

		return total;
	}

	@Override
	public String toString() {
		String hand = "";
		int count = 0;
		for (Card card : cardsInHand) {
			if (count == 0) {
				hand += card.toString();
				count++;
			} else {
				hand += ", " + card.toString();
			}

		}

		return hand;
	}
}
