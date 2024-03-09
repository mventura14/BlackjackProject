package com.skilldistillery.blackjack.game;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Hand;
import com.ventura.util.ConsoleEffect;

public class Player implements ConsoleEffect {

	protected Hand hand = new BlackJackHand();
	
	public Player() {
	};
	
	@Override
	public String toString() {
		return green + "Player: " + reset;
	}

	public void addToHand(Card card) {
		this.hand.addCard(card);
	}

	public int getCardSum() {
		return hand.getHandValue();

	}

	public void getStats() {
		String stats = this.hand.toString() + " Total: " + hand.getHandValue();

		System.out.println(stats);
	}
}
