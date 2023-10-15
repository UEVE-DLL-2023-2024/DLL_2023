import java.util.ResourceBundle;
import java.util.Scanner;

public class Player extends Entity {

	private String name;
	private int nbOfRound;
	// Variable utilisee pour recupere les entrees du clavier
	Scanner sc = new Scanner(System.in);

	private ResourceBundle messages;

	public Player(ResourceBundle messages) {
		super();
		this.messages = messages;
	}

	public void askName() {
		System.out.println(messages.getString("name_question"));
		String inputName = sc.nextLine();

		while (inputName.length() > 20) {
            System.out.println(messages.getString("name_error"));
            inputName = sc.nextLine();
        }
		setName(inputName);
	}

	public void askRules() {
        sc = new Scanner(System.in);
        System.out.println("Voulez-vous lire les rapports de puissances des signes ? (O/N)");
        String playerInput = sc.nextLine();
        playerInput = playerInput.toUpperCase();
        char c = playerInput.charAt(0);

        if (c == 'O'){
            System.out.println("pierre > Lezard & ciseaux\r\n" + //
                "papier > pierre & Spock\r\n" + //
                "ciseaux > papier & Lezard\r\n" + //
                "Lezard > Spock & papier\r\n" + //
                "Spock > ciseaux & pierre\r\n");
            }
        else if (c == 'N'){}

        else {
            System.out.println("Valeur non valide, veuillez sairir O ou N");
            askRules();
        }

    }


	public int getNbOfRound() {
		return nbOfRound;
	}

	public void askNumberOfRound(){
		System.out.println(messages.getString("how_many_rounds"));
		while (true) {
			String input = sc.next();
			try {
				nbOfRound = Integer.parseInt(input);
				if (nbOfRound <= 0) {
					throw new Exception();
				}
				break;
			} catch (Exception e) {
				System.out.println(messages.getString("rounds_number_error"));
				continue;
				}
			}
		}

	// Function dealing with player sign selection
	@Override
	public int selectSign(char gameModeRPS) {
		String rock = messages.getString("rock");
		String paper = messages.getString("paper");
		String scissors = messages.getString("scissors");
		String lizard = messages.getString("lizard");
		String spock = messages.getString("spock");

		String options = "";

		if(gameModeRPS == 'B'){
			options = rock + " " + paper + " " + scissors + " " + lizard + " " + spock;
		} else{
			options = rock + " " + paper + " " + scissors;
		}

		System.out.println(messages.getString("chose") + " : " + options);
		String input = sc.next();
		input = input.toUpperCase();
		char c = input.charAt(0);
		// Verification du premier caractere de l'entree
		if (c == rock.charAt(0))
			return Controller.PIERRE;
		else if (c == paper.charAt(0))
			return Controller.FEUILLE;
		else if (c == scissors.charAt(0))
			return Controller.CISEAUX;
		else if (c == lizard.charAt(0) && gameModeRPS == 'B')
			return Controller.LEZARD;
		else if (c == spock.charAt(0) && gameModeRPS == 'B')
			return Controller.SPOCK;
		else {
			return selectSign(gameModeRPS);
		}
	}

	// Fonction demandant au joueur s'il souhaite rejouer
	public boolean playAgain() {
		sc = new Scanner(System.in);
		boolean val = true;
		String playerInput= "";

		while(val){
			System.out.print(messages.getString("play_again"));
			playerInput = sc.nextLine();
			playerInput = playerInput.toUpperCase();
			val = playerInput.charAt(0) != 'O' && playerInput.charAt(0) != 'N';

			if(val){
				System.out.println("\n"+messages.getString("yes_or_no")+"\n");
			}
		}

		return playerInput.charAt(0) != 'N';
	}
}