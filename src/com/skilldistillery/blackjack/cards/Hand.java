package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	protected List<Card> cardsInHand = new ArrayList<>();

	public void addCard(Card card) {
		cardsInHand.add(card);
	};

	public void clear() {
		cardsInHand.removeAll(cardsInHand);
	};

	abstract public int getHandValue();

	@Override
	public String toString() {

		return "" + cardsInHand;
	}

}
