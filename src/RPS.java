import java.util.Scanner;

public class RPS {
	private Player player1;
	private Player player2;
	private Bot bot;
	private Scoreboard scoreboard;

	private int mode;

	public RPS() {
		player1 = new Player();
		player2 = new Player();
		bot = new Bot();
		scoreboard = new Scoreboard(player1, bot);
	}

	public static void main(String[] args) {
		RPS rps = new RPS();
		rps.getNumberOfRound();
		rps.chooseGameMode();
		rps.startGame();
	}

	// Choix du mode de jeu
	public void chooseGameMode() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choisissez le mode de jeu :");
		System.out.println("1. Contre un autre joueur");
		System.out.println("2. Contre le bot");
		mode = sc.nextInt();

		if (mode == 1) {
			System.out.println("Joueur 1, entrez votre nom :");
			player1.askName();
			System.out.println("Joueur 2, entrez votre nom :");
			player2.askName();
		} else if (mode == 2) {
			System.out.println("Joueur, entrez votre nom :");
			player1.askName();
		} else {
			System.out.println("Mode de jeu invalide. Choisissez 1 ou 2.");
			chooseGameMode();
		}
	}

	// Fonction appelee recursivement tant que les joueurs souhaitent jouer
	public void startGame() {
		int player1Sign = player1.selectSign();

		if (mode == 2) {
			scoreboard.displayScore();

			int nbRound = player1.getNbOfRound();
			int playerCount = player1.getScore();
			int botCount = bot.getScore();

			if (playerCount == nbRound || botCount == nbRound){
				System.out.println("Fin du jeu");
				player1.resetScore();
				bot.resetScore();

				if (player1.playAgain()) {
					System.out.println();
					getNumberOfRound();
					startGame();
				} else {
					System.out.println("Fin du jeu !");
				}
			} else {
				// Le joueur 2 (bot) fait son choix en privé.
				int botSign = bot.selectSign();
				int result = Controller.compareSigns(player1Sign, botSign);
				displayResult(result, player1.getName(), "Bot");

				// Continuez le jeu.
				startGame();
			}
		} else if (mode == 1) {
			if (player2.getName() != null) {
				int player2Sign = player2.selectSign();
				int result = Controller.compareSigns(player1Sign, player2Sign);
				displayResult(result, player1.getName(), player2.getName());
			} else {
				// Le joueur 2 (bot) fait son choix en privé.
				int botSign = bot.selectSign();
				int result = Controller.compareSigns(player1Sign, botSign);
				displayResult(result, player1.getName(), "Bot");
			}

			// Jouer avec qui ?
			if (player1.playAgain()) {
				System.out.println();
				startGame();
			}
		}
	}


	// Fonction utilisee pour demander le nom du joueur
	public void getPlayerName() {
		player1.askName();
	}

	// Fonction pour afficher le résultat
	public void displayResult(int result, String player1Name, String player2Name) {
		switch (result) {
			case 0:
				System.out.println("Egalite !");
				break;
			case 1:
				System.out.println(player1Name + " remporte la manche !");
				break;
			case -1:
				System.out.println(player2Name + " remporte la manche !");
				break;
		}
	}

	public void getNumberOfRound(){
		player1.askNumberOfRound();
	}
}