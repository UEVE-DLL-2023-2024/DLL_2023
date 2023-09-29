public abstract class Entity {
  private String name;
  private int score;
  private int bestWinStreak;
  private int actualWinStreak;

  public Entity() {
    this.score = 0;
    this.bestWinStreak = 0;
  }

  public Entity(String name) {
    this.name = name;
    this.score = LocalStorage.getScore(this.name);
    this.bestWinStreak = LocalStorage.getBestWinStreak(this.name);

  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getScore() {
    return this.score;
  }

  public void incrementScore() {
    this.score++;
  }

  public int getBestWinStreak(){
    return this.bestWinStreak;
  }

  abstract public int selectSign();

  protected void setScore(int score) {
    this.score = score;
  }

  protected void setBestWinstreak(int bestWinStreak) {
    this.bestWinStreak = bestWinStreak;
  }

  public void resetActualWinStreak() {
    this.actualWinStreak = 0;

  }

  public int getActualWinStreak() {
  return this.actualWinStreak;
  }

  public void incrementActualWinStreak() {
    this.actualWinStreak++;
  }
}
