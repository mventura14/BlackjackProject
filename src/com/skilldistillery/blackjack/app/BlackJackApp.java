package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.game.Dealer;
import com.skilldistillery.blackjack.game.Player;
import com.ventura.util.ConsoleEffect;
import com.ventura.util.VerifyScanner;

public class BlackJackApp implements ConsoleEffect {

	public static void main(String[] args) {

		BlackJackApp app = new BlackJackApp();
		app.run();

	}

	public void run() {

		Scanner sc = new Scanner(System.in);

		ArrayList<Player> players = new ArrayList<>();

		Dealer dealer = new Dealer();

		interactiveGameMenu(sc);

		String userSelection =
		
		
		addPlayers(1, players, dealer);

		dealer.grabDeck();

		boolean deal = true;

		while (userSelection.equals("Deal") {
//			dealer.checkDeckCount();
			dealer.shuffleDeck();

			dealer.dealToPlayers(players, dealer, players.size() - 1);

			int playerCount = 1;

			for (Player player : players) {
				System.out.println();

				boolean endTurn = false;

				if (player.getCardSum() == 21 && !(player instanceof Dealer)) {
					System.out.println(green + "Player " + playerCount + " BlackJack!" + reset);
					continue;
				}

				if (checkPlayersStatus(players)) {
					System.out.println(player.toString() + " " + green + playerCount + " " + "Turn" + reset);
				}

				while (!endTurn) {

					if (player instanceof Dealer) {

						endTurn = dealerTurn(players, player, dealer);

					} else {
						player.getStats();
						playerOptions();
						endTurn = playerGameSelection(sc, player, dealer);
						if (player.getCardSum() > 21) {
							System.out.println(green + "Player " + playerCount + ": " + red + player.getCardSum() + " "
									+ "BUST!" + reset);
							break;
						}
					}
				}

			}
			System.out.println();
			showWinner(players, dealer);
			System.out.println();
			clearAllHands(players);

			if (dealer.checkLowDeck()) {
				dealer.returnCards();
			}
		}

		sc.close();
	}

	private void addPlayers(int numOfPlayers, ArrayList<Player> players, Dealer dealer) {
		for (int i = 0; i < numOfPlayers; i++) {
			players.add(new Player());
		}

		players.add(dealer);
	}

	private void clearAllHands(ArrayList<Player> players) {
		for (Player player : players) {
			player.clearHand();
		}

	}

	public void playerOptions() {

		System.out.println("1) Hit");
		System.out.println("2) Stay");
	}

	public boolean playerGameSelection(Scanner sc, Player player, Dealer dealer) {
		boolean stay = false;
		String message = cyan + "Player Selection: ";
		int selection = VerifyScanner.inputValidation(sc, "int", message, 0, 3);
		System.out.print(reset);
		switch (selection) {
		case 1:
			Card cardDelt = dealer.dealCard();
			System.out.println();
			System.out.println(magenta + cardDelt + reset);
			System.out.println();
			player.addToHand(cardDelt);
			break;
		case 2:
			stay = true;
			break;
		}
		return stay;
	}

	public void showWinner(ArrayList<Player> players, Dealer dealer) {
		System.out.println(green + "Game Results:");
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

	public void showGameOptions() {
		System.out.println("1) Deal Again");
		System.out.println("2) Quit");
	}

	public void interactiveGameMenu(Scanner sc) {
		String message = "1) Deal \n" + "2) Change number of player \n" + "3) Quit Game";
		int userSelection = VerifyScanner.inputValidation(sc, "int", message, 0, 4);
		
		switch(userSelection) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		
		}
	};

	public boolean dealerTurn(ArrayList<Player> players, Player player, Dealer dealer) {

		boolean endTurn = false;

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
		return endTurn;

	}
}
