import java.util.ResourceBundle;

public class Controller {
	public static final int PIERRE = 1;
	public static final int FEUILLE = 2;
	public static final int CISEAUX = 3;
	public static final int LEZARD = 4;
	public static final int SPOCK = 5;

	// Fonction affichant le signe choisi
	public static void display(String someone, int sign, ResourceBundle messages) {
		String type = "";
		switch (sign) {
		case Controller.PIERRE:
			type = messages.getString("rock");
			break;
		case Controller.FEUILLE:
			type = messages.getString("paper");
			break;
		case Controller.CISEAUX:
			type = messages.getString("scissors");
			break;
		case Controller.LEZARD:
			System.out.print(someone + " a choisi LEZARD, ");
			break;
		case Controller.SPOCK:
			System.out.print(someone + " a choisi SPOCK, ");
			break;
		default:
			return;
		}
		System.out.print(someone + " " + messages.getString("has_chose") + " " + type + ", ");
	}

	// Fonction decidant qui a gagne la manche
	public static int compareSigns(int playerSign, int botSign) {
		if (playerSign == botSign) return 0;
		switch (playerSign) {
		case PIERRE:
			return (botSign == CISEAUX || botSign == LEZARD ? 1 : -1);
		case FEUILLE:
			return (botSign == PIERRE || botSign == SPOCK ? 1 : -1);
		case CISEAUX:
			return (botSign == FEUILLE || botSign == LEZARD ? 1 : -1);
		case LEZARD:
			return (botSign == SPOCK || botSign == FEUILLE ? 1 : -1);
		case SPOCK:
			return (botSign == CISEAUX || botSign == PIERRE ? 1 : -1);
		}
		return 0;
	}
}
