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
		String inputName = sc.nextLine();

		while (inputName.length() > 20) {
            System.out.println("Le nom ne doit pas depasser 20 caracteres. Reessayez : ");
            inputName = sc.nextLine();
        }
		setName(inputName);
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
	public int selectSign(char gameModeRPS) {
		if(gameModeRPS == 'B'){
			System.out.println("Choisissez  PIERRE FEUILLE CISEAUX LEZARD SPOCK");
		}
		else{
			System.out.println("Choisissez  PIERRE FEUILLE CISEAUX");
		}
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
		else if (c == 'L' && gameModeRPS == 'B')
			return Controller.LEZARD;
		else if (c == 'S' && gameModeRPS == 'B')
			return Controller.SPOCK;
		else {
			return selectSign(gameModeRPS);
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
