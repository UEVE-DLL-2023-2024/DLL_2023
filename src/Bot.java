import java.util.Random;

public class Bot extends Entity {
	public Bot() {
		super("Bot");
	}
	// Fonction aidant le bot a choisir PIERRE, FEUILLE ou CISEAUX
	@Override
	public int selectSign() {
		Random random = new Random();
		int sign = random.nextInt(3) + 1;
		return sign;
	}
}
