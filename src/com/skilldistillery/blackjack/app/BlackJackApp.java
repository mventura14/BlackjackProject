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

		ArrayList<Player> players;

		Dealer dealer = new Dealer();

		boolean gameRunning = true;

		int numOfPlayers = 1;

		while (gameRunning) {

			String userSelection = interactiveGameMenu(sc);

			if (userSelection.equals("ChangePlayers")) {
				numOfPlayers = changePlayerCount(sc);
			}

			if (userSelection.equals("Quit")) {
				break;
			}

			players = new ArrayList<>();
			addPlayers(numOfPlayers, players, dealer);

			dealer.grabDeck();

			while (userSelection.equals("Deal")) {

				dealer.shuffleDeck();

				dealer.dealToPlayers(players, dealer, players.size() - 1);

				int playerCount = 1;

				for (Player player : players) {
					System.out.println();

					boolean endTurn = false;

					if (player.getCardSum() == 21 && !(player instanceof Dealer)) {
						System.out.println(green + "Player " + playerCount + ": " + " BlackJack!" + reset);
						continue;
					}

					if (player instanceof Dealer) {

						System.out.println(player.toString() + " " + green + "Turn" + reset);

					} else {
						System.out.println(player.toString() + " " + green + playerCount + " " + "Turn" + reset);

					}

					while (!endTurn) {

						if (player instanceof Dealer) {

							endTurn = dealer.dealerTurn(players, player, dealer, checkPlayersStatus(players));

						} else {
							player.getStats();
							playerOptions();
							endTurn = playerGameSelection(sc, player, dealer);
							if (player.getCardSum() > 21) {
								System.out.println(green + "Player " + playerCount + ": " + red + player.getCardSum()
										+ " " + "BUST!" + reset);
								break;
							}
						}
					}
					playerCount++;
				}
				System.out.println();
				showWinner(players, dealer);
				System.out.println();
				clearAllHands(players);

				if (dealer.checkLowDeck()) {
					dealer.returnCards();
				}

				break;
			}
		}
		sc.close();
	}

	private int changePlayerCount(Scanner sc) {
		String message = cyan + "Enter new player count [1 min, 4 max]: ";
		int count = VerifyScanner.inputValidation(sc, "int", message, 0, 5);
		System.out.println(reset);
		return count;
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
		System.out.println(green + "Game Results" + reset);
		System.out.println();
		for (int i = 0; i < players.size() - 1; i++) {
			int playerSum = players.get(i).getCardSum();
			int dealerSum = dealer.getCardSum();

			System.out.println(
					green + "Player " + (i + 1) + ": " + reset + playerSum + red + " Dealer: " + reset + dealerSum);

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
			System.out.println(reset);
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

	public String interactiveGameMenu(Scanner sc) {
		gameMenu();
		String message = cyan + "Selection: ";
		int userSelection = VerifyScanner.inputValidation(sc, "int", message, 0, 4);
		String selection = "";
		switch (userSelection) {

		case 1:
			selection = "Deal";
			break;
		case 2:
			selection = "ChangePlayers";
			break;
		case 3:
			selection = "Quit";
			System.out.println();
			System.out.println(green + "Thank You For Playing" + reset);
			break;
		}
		System.out.println();
		return selection;
	}

	public void gameMenu() {
		System.out.println(magenta + "       " + underline + "Game Menu" + reset);
		System.out.println("1) Deal");
		System.out.println("2) Change number of players");
		System.out.println("3) Quit Game");

	}

}
