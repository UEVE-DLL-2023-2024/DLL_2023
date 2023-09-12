import java.util.Random;

public class Bot {
	// Fonction aidant le bot a choisir PIERRE, FEUILLE ou CISEAUX
	public int selectSign() {
		Random random = new Random();
		int sign = random.nextInt(3) + 1;
		return sign;
	}
}
