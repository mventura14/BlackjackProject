package com.skilldistillery.blackjack.cards;

public enum Suit {
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");

	Suit(String n) {
		name = n;
	}

	final private String name;

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

}
