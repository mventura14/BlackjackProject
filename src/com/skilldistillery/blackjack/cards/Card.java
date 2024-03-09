package com.skilldistillery.blackjack.cards;

public class Card {

	private Suit suit;
	private Rank rank;

	public Card(Suit suit, Rank rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return this.rank + " of " + this.suit;
	}

	public int getValue() {
		return this.rank.getValue();

	}

}
