package com.skilldistillery.blackjack.game;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Hand;

public class BlackJackHand extends Hand {

	@Override
	public int getHandValue() {
		int total = 0;
		boolean hasAce = false;
		for (Card card : cardsInHand) {
			if (card.getValue() == 11) {
				hasAce = true;
			}

			total += card.getValue();

			if (total > 21 && hasAce) {
				total -= 10;
			}

		}

		return total;
	}

}
