import java.util.Scanner;

public class Player extends Entity {

	private String name;
	private int nbOfRound;
	// Variable utilisee pour recupere les entrees du clavier
	Scanner sc = new Scanner(System.in);

	public Player() {
		super();
	}

	public void askName() {
		System.out.println("Quel est votre nom ?");
		setName(sc.next());
	}

	public void askNumberOfRound(){
		System.out.println("Combien de manche(s) pour gagner ?");
		while (true) {
			String input = sc.next();
			try {
				nbOfRound = Integer.parseInt(input);
				if (nbOfRound <= 0) {
					throw new Exception();
				}
				break;
			} catch (Exception e) {
				System.out.println("Veuillez saisir une valeur numérique supérieure à zéro.");
				continue;
				}	
			}
		}

	public int getNbOfRound() {
		return nbOfRound;
	}

	// Function dealing with player sign selection 
	@Override
	public int selectSign() {
		System.out.println("Choisissez  PIERRE FEUILLE CISEAUX");

		String input = sc.next();
		input = input.toUpperCase();
		char c = input.charAt(0);
		// Verification du premier caractere de l'entree 
		if (c == 'P')
			return Controller.PIERRE;
		else if (c == 'F')
			return Controller.FEUILLE;
		else if (c == 'C')
			return Controller.CISEAUX;
		else {
			selectSign();
			return 0;
		}
	}

	// Fonction demandant au joueur s'il souhaite rejouer
	public boolean playAgain() {
		sc = new Scanner(System.in);
		System.out.print("Voulez-vous jouer a nouveau ? (O/N)");
		String playerInput = sc.nextLine();
		playerInput = playerInput.toUpperCase();
		return playerInput.charAt(0) == 'O';
	}
}
