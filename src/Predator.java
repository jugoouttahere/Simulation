public class Predator extends Creature {
    private final int attackPower;

    public Predator(int speed, int hp, int attackPower, Coordinates coordinates) {
        super(speed, hp, coordinates);
        this.attackPower = attackPower;
    }

    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public void makeMove() {

    }
}
