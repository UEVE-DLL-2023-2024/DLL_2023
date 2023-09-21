public abstract class Entity {
  private String name;
  private int score;

  public Entity() {
    this.score = 0;
  }

  public Entity(String name) {
    this.name = name;
    this.score = 0;
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

  abstract public int selectSign();
}
