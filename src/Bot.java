import java.util.Random;

public class Bot extends Entity {
	public Bot() {
		super("Bot");
	}
	// Fonction aidant le bot a choisir PIERRE, FEUILLE ou CISEAUX
	@Override
	public int selectSign(char gameModeRPS) {
		Random random = new Random();
		if(gameModeRPS == 'C' || gameModeRPS =='H'){
			return random.nextInt(3) + 1;
		}
		else{
			return random.nextInt(5) + 1;
		}
	}
}
