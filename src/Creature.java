public abstract class Creature extends Entity {
    private final int speed;
    private final int hp;

    public Creature(int speed, int hp, Coordinates coordinates) {
        super(coordinates);
        this.speed = speed;
        this.hp = hp;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    public abstract void makeMove();
}