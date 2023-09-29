public class Scoreboard {
  private Player player;
  private Bot bot;

  public Scoreboard(Player player, Bot bot) {
    this.player = player;
    this.bot = bot;
  }
  // Méthode pour vérifier et sauvegarder le meilleur score du joueur
  public void checkAndSaveBestScore() {

      LocalStorage.saveData(player.getName(), player.getScore(), bot.getScore(), Math.max(player.getActualWinStreak(), player.getBestWinStreak()));
  }
  public void displayScore() {
    System.out.println("Score : " + player.getName() + " " + player.getScore() + " - " + bot.getScore() + " " + bot.getName());
    System.out.println("Actuelle serie de victoire : "+ player.getActualWinStreak());
    System.out.println("Meilleure serie de victoires : " + player.getBestWinStreak());

  }
}
