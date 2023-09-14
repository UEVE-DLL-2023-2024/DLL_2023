public class Scoreboard {
  private Player player;
  private Bot bot;

  public Scoreboard(Player player, Bot bot) {
    this.player = player;
    this.bot = bot;
  }

  public void displayScore() {
    System.out.println("Score : " + player.getName() + " " + player.getScore() + " - " + bot.getScore() + " " + bot.getName());
  }
}
