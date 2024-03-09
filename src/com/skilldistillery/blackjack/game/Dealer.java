package com.skilldistillery.blackjack.game;

import java.util.ArrayList;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Deck;
import com.ventura.util.ConsoleEffect;

public class Dealer extends Player implements ConsoleEffect {

	private Deck deck;

	public Dealer() {
	}

	public void grabDeck() {
		this.deck = new Deck();
	}

	public Card dealCard() {
		return deck.dealCard();
	}

	public void checkDeckCount() {
		System.out.println(deck.getSize());
	}

	public boolean checkLowDeck() {
		boolean isLow = deck.getSize() < 30;
		return isLow;
	}

	public void shuffleDeck() {
		deck.shuffle();
	}

	@Override
	public String toString() {
		return red + "Dealer" + reset;
	}

	public void returnCards() {
		deck.returnCards();
	}

	public void dealToPlayers(ArrayList<Player> players, Dealer dealer, int numOfPlayers) {
		for (int i = 0; i < 2; i++) {
			for (Player player : players) {
				Card cardDelt = dealer.dealCard();

				player.addToHand(cardDelt);

				if (player instanceof Dealer) {
					if (i == 0) {
						System.out.println(player.toString() + red + ": " + magenta + "???????" + reset);
					} else {
						System.out.println(player.toString() + red + ": " + magenta + cardDelt + reset);
					}
				} else {
					System.out.println(player.toString() + green + ": " + magenta + cardDelt + reset);
				}
			}
		}

	}
}
