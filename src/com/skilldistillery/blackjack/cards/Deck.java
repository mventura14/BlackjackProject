package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards;

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

	public void checkSize() {
		System.out.println(cards.size());
	}

	public Card dealCard() {
//		Card removed = cards.remove(0);
//		System.out.println(removed.toString());
		return cards.remove(cards.size() - 1);
	}

	public void shuffle() {
		Collections.shuffle(cards);

	}
}
