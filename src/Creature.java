public abstract class Creature extends Entity {
    private int speed;
    private int hp;

    public Creature(Coordinates coordinates, int speed, int hp) {
        super(coordinates);
        this.speed = speed;
        this.hp = hp;
    }

    public Creature(int row, int col, int speed, int hp) {
        this(new Coordinates(row, col), speed, hp);
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

    public void move(Coordinates newCoordinates, Board board) {
        board.getBoard().remove(this.getCoordinates());
        this.setCoordinates(newCoordinates);
        board.getBoard().put(newCoordinates, this);
    }
}