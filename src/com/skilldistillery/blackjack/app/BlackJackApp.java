package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.game.Dealer;
import com.skilldistillery.blackjack.game.Player;
import com.ventura.util.ConsoleEffect;

public class BlackJackApp implements ConsoleEffect {

	public static void main(String[] args) {

		BlackJackApp app = new BlackJackApp();
		app.run();

	}

	public void run() {

		Scanner sc = new Scanner(System.in);

		ArrayList<Player> players = new ArrayList<>();

		int numOfPlayers = 2;
		for (int i = 0; i < numOfPlayers; i++) {
			players.add(new Player());
		}

		Dealer dealer = new Dealer();
		players.add(dealer);



		dealer.grabDeck();


		dealer.shuffleDeck();

		dealer.dealToPlayers(players, dealer, numOfPlayers);

		for (Player player : players) {
			boolean endTurn = false;

			if (player.getCardSum() == 21 && !(player instanceof Dealer)) {
				System.out.println("BlackJack");
				continue;
			}
			if (checkPlayersStatus(players)) {
				System.out.println(player.toString() + "Turn");
			}

			while (!endTurn) {

				if (player instanceof Dealer) {
					if (checkPlayersStatus(players)) {
						player.getStats();

						if (player.getCardSum() > 17) {
							endTurn = true;
						} else {
							Card cardDelt = dealer.dealCard();
							System.out.println(magenta + cardDelt + reset);
							player.addToHand(cardDelt);
						}
					} else {
						endTurn = true;
					}

				} else {
					player.getStats();
					playerOptions();
					endTurn = playerGameSelection(sc, player, dealer);
					if (player.getCardSum() > 21) {
						System.out.println(red + player.getCardSum() + " " + "BUST!" + reset);
						endTurn = true;
					}
				}
			}

		}
		showWinner(players, dealer);
		sc.close();
	}

	public void playerOptions() {

		System.out.println("1) Hit");
		System.out.println("2) Stay");
	}

	public boolean playerGameSelection(Scanner sc, Player player, Dealer dealer) {
		boolean stay = false;
		int selection = sc.nextInt();
		switch (selection) {
		case 1:
			Card cardDelt = dealer.dealCard();
			System.out.println(magenta + cardDelt + reset);
			player.addToHand(cardDelt);
			break;
		case 2:
			stay = true;
			break;
		}
		return stay;
	}

	public void showWinner(ArrayList<Player> players, Dealer dealer) {
		for (int i = 0; i < players.size() - 1; i++) {
			int playerSum = players.get(i).getCardSum();
			int dealerSum = dealer.getCardSum();

			System.out.println("Player: " + playerSum + " Dealer: " + dealerSum);

			System.out.print(cyan);
			if (playerSum <= 21) {
				if (dealerSum <= 21) {
					if (playerSum == dealerSum) {
						System.out.println("DRAW");
					} else if (playerSum > dealerSum) {
						System.out.println("PLAYER WINS!");
					} else {
						System.out.println("DEALER WINS");
					}
				} else {
					System.out.println("PLAYER WINS!");
				}
			} else {
				System.out.println("DEALER WINS!");
			}
			System.out.print(reset);
		}

	}

	public boolean checkPlayersStatus(ArrayList<Player> players) {

		boolean playersStillInGame = false;

		for (int i = 0; i < players.size() - 1; i++) {
			if (players.get(i).getCardSum() <= 21) {
				playersStillInGame = true;
			}
		}

		return playersStillInGame;
	}
}
