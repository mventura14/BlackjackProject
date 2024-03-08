package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	protected List<Card> cardsInHand = new ArrayList<>();

	public void addCard() {
	};

	public void clear() {
	};

	abstract public int getHandValue();

	@Override
	public String toString() {
		return "Hand [cardsInHand = " + cardsInHand + "]";
	}

}
