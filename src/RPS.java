public class RPS {
	private Player player;
	private Bot bot;
	private Scoreboard scoreboard;

	public RPS() {
		player = new Player();
		bot = new Bot();
		scoreboard = new Scoreboard(player, bot);
	}

	public static void main(String[] args) {
		RPS rps = new RPS();
		rps.getPlayerName();
		rps.startGame();
	}

	// Fonction appelee recursivement tant que le joueur souhaite jouer
	public void startGame() {
		int playerSign = player.selectSign();
		Controller.display(player.getName(), playerSign);
		int botSign = bot.selectSign();
		Controller.display("bot", botSign);

		int result = Controller.compareSigns(playerSign, botSign);
		switch (result) {
		case 0: 
			System.out.println("Egalite !");
			break;
		case 1: 
			player.incrementScore();
			System.out.println(player.getName()+ " remporte la manche !");
			break;
		case -1: 
			bot.incrementScore();
			System.out.println("Bot remporte la manche !");
			break;
		}

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
