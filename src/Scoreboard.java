import java.util.ResourceBundle;

public class Scoreboard {
  private Player player;
  private Bot bot;
  private ResourceBundle messages;

  public Scoreboard(Player player, Bot bot, ResourceBundle messages) {
    this.player = player;
    this.bot = bot;
    this.messages = messages;
  }

  public void displayScore() {
    String scoreMessage = messages.getString("score")
            + " : " + player.getName()
            + " " + player.getScore()
            + " - " + bot.getScore()
            + " " + bot.getName();
    System.out.println(scoreMessage);
  }
}
