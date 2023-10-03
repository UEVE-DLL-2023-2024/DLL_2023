import java.util.List;
import java.util.Scanner;

public class RPS {
	private Player player;
	private Bot bot;
	private Scoreboard scoreboard;
	Scanner sc = new Scanner(System.in);


	public RPS() {
		player = new Player();
		bot = new Bot();
		scoreboard = new Scoreboard(player, bot);
	}

	public static void main(String[] args) {
		RPS rps = new RPS();
		rps.getPlayerName();
		rps.startMenu();
	}
	public void startMenu(){
		System.out.println("Bienvenue "+player.getName()+" dans le jeu du Pierre Feuille Ciseaux !");
		System.out.println("1 - Jouer");
		System.out.println("2 - Voir votre scoreboard");
		System.out.println("3 - Voir tous les scoreboards");
		System.out.println("4 - Quitter");
		String input;
		while(true){
			input = sc.next();

			switch (input) {
				case "1":
					startGame();
					break;
				case "2":
					startScoreboard();
					break;
				case "3":
					startAllScoreboard();

					break;
				case "4":
					System.out.println("Fin du jeu !");
					System.exit(0);
					break;
				default:
					System.out.println("Veuillez saisir une valeur valide.");
					System.out.println("1 - Jouer");
					System.out.println("2 - Voir votre scoreboard");
					System.out.println("3 - Voir tous les scoreboards");
					System.out.println("4 - Quitter");
					break;
			}
		}
	}
	public void startScoreboard(){
		scoreboard.displayScore();
		System.out.println("1 - Revenir au menu");
		System.out.println("2 - Réinitialiser votre score (sauf la meilleure serie de victoire)");
		System.out.println("3 - Quitter");
		String input;
		while(true){
			input = sc.next();

			switch (input) {
				case "1":
					startMenu();
					break;
				case "2":
					player.resetScore();
					bot.resetScore();
					System.out.println("Score réinitialisé !");
					startMenu();
					break;
				case "3":
					System.out.println("Fin du jeu !");
					System.exit(0);

					break;
				default:
					System.out.println("1 - Revenir au menu");
					System.out.println("2 - Réinitialiser votre score (sauf la meilleure serie de victoire)");
					System.out.println("3 - Quitter");
					break;
			}
		}
	}
	public void startAllScoreboard(){
		List<List<String>> scoreboardList = LocalStorage.getAllScoreboard();
		for (List<String> Listscoreboard : scoreboardList) {
			for(String scoreboard : Listscoreboard){
				System.out.println(scoreboard);
			}
		}
		System.out.println("1 - Revenir au menu");
		System.out.println("2 - Quitter");
		String input;
		while(true){
			input = sc.next();

			switch (input) {
				case "1":
					startMenu();
					break;

				case "3":
					System.out.println("Fin du jeu !");
					System.exit(0);

					break;
				default:
					System.out.println("1 - Revenir au menu");
					System.out.println("2 - Réinitialiser votre score (sauf la meilleure serie de victoire)");
					System.out.println("3 - Quitter");
					break;
			}
		}
	}

	// Fonction appelee recursivement tant que le joueur souhaite jouer
	public void startGame() {
		bot.setScore(LocalStorage.getBotScore(player.getName()));
		int playerSign = player.selectSign();
		Controller.display(player.getName(), playerSign);
		int botSign = bot.selectSign();
		Controller.display("bot", botSign);

		int result = Controller.compareSigns(playerSign, botSign);
		switch (result) {
			case 0:
				player.resetActualWinStreak();
				System.out.println("Egalite !");
				break;
			case 1:
				player.incrementScore();
				player.incrementActualWinStreak();
				System.out.println(player.getName()+ " remporte la manche !");
				break;
			case -1:
				bot.incrementScore();
				player.resetActualWinStreak();
				System.out.println("Bot remporte la manche !");
				break;
			}

		scoreboard.checkAndSaveBestScore();
		scoreboard.displayScore();

		// Demande a l'utilisateur s'il veut jouer a nouveau
		if (player.playAgain()) {
			System.out.println();
			startGame();
		} else {
			System.out.println("Fin du jeu !");
		}
	}
	// Fonction utilisee pour demander le nom du joueur
	public void getPlayerName() {
		player.askName();
	}
}
