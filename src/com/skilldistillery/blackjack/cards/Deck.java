package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards;

	private List<Card> cardsRemoved = new ArrayList<>();

	public Deck() {
		cards = createDeck();
	}

	private List<Card> createDeck() {
		cards = new ArrayList<>();

		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {

				cards.add(new Card(s, r));

			}
		}
		return cards;
	}

	public int getSize() {
		return cards.size();
	}

	public void checkSize() {
		System.out.println(this.cards.size());
	}

	public Card dealCard() {
		Card delt = this.cards.remove(this.cards.size() - 1);
		cardsRemoved.add(delt);
		return delt;
	}

	public void shuffle() {
		Collections.shuffle(this.cards);

	}

	public void returnCards() {
		this.cards.addAll(cardsRemoved);
		cardsRemoved.removeAll(cardsRemoved);
	}

}
