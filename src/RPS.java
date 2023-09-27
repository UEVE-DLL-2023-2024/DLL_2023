import java.util.Scanner;

public class RPS {
	private Player player;
	private Bot bot;
	private Scoreboard scoreboard;
	static Scanner sc = new Scanner(System.in);

	public RPS() {
		player = new Player();
		bot = new Bot();
		scoreboard = new Scoreboard(player, bot);
	}

	public static void main(String[] args) {
		RPS rps = new RPS();
		rps.getPlayerName();
		rps.getNumberOfRound();
		char gameModeRPS = rps.getGameMode();
		rps.startGame(gameModeRPS);
	}

	// Fonction appelee recursivement tant que le joueur souhaite jouer
	public void startGame(char gameModeRPS) {
		int playerSign = player.selectSign(gameModeRPS);
		Controller.display(player.getName(), playerSign);
		int botSign = bot.selectSign(gameModeRPS);
		Controller.display("bot", botSign);

		int result = Controller.compareSigns(playerSign, botSign);
		switch (result) {
		case 0: 
			System.out.println("Egalite !");
			break;
		case 1: 
			System.out.println(player.getName()+ " remporte la manche !");
			player.incrementScore();
			break;
		case -1: 
			bot.incrementScore();
			System.out.println("Bot remporte la manche !");
			break;
		}

		scoreboard.displayScore();

		// Demande a l'utilisateur s'il veut jouer a nouveau
		int nbRound = player.getNbOfRound();
		int playerCount = player.getScore();
		int botCount = bot.getScore();
		if (playerCount == nbRound || botCount == nbRound){
			System.out.println("Fin du jeu");
			player.resetScore();
			bot.resetScore();
			if (player.playAgain()) {
				System.out.println();
				getNumberOfRound();
				startGame(gameModeRPS);
			} else {
				System.out.println("Fin du jeu !");
			}
		 }
		 else { 
			startGame(gameModeRPS);
		}
	}

	// Fonction utilisee pour demander le nom du joueur
	public void getPlayerName() {
		player.askName();
	}
	
	public void getNumberOfRound(){
		player.askNumberOfRound();
	}

	public char getGameMode(){
		System.out.println("Selectionnez votre mode de jeu : CLASSIQUE ou BBT");
		String gameMode = sc.next();
		char c = gameMode.charAt(0);
		if(c != 'C' && c != 'B'){
			getGameMode();
		}	
		return c;
	}
}
