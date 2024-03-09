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

		return total;
	}

}
