public class Predator extends Creature {
    private final int attackPower;

    public Predator(Coordinates coordinates, int speed, int hp, int attackPower) {
        super(coordinates, speed, hp);
        this.attackPower = attackPower;
    }

    public Predator(int row, int col, int speed, int hp, int attackPower) {
        this(new Coordinates(row, col), speed, hp, attackPower);
    }

    public int getAttackPower() {
        return attackPower;
    }
}
