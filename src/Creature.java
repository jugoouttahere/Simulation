public abstract class Creature extends Entity {
    private int speed;
    private int hp;

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

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
    }

    public abstract void makeMove(Board board);

    public abstract boolean isValidMove(Board board, Coordinates coordinates);

}