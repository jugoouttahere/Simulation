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

    @Override
    public boolean isValidMove(Board board, Coordinates coordinates) {
        if (!board.isCellEmpty(coordinates)) {
            Entity entity = board.getEntity(coordinates);
            return !(entity instanceof Rock)
                    && !(entity instanceof Tree)
                    && !(entity instanceof Predator)
                    && !(entity instanceof Grass);
        }
        return true;
    }
}
