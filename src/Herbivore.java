public class Herbivore extends Creature {
    public Herbivore(int speed, int hp, Coordinates coordinates) {
        super(speed, hp, coordinates);
    }

    @Override
    public void makeMove(Board board) {

    }

    @Override
    public boolean isValidMove(Board board, Coordinates coordinates) {
        if (!board.isCellEmpty(coordinates)) {
            Entity entity = board.getEntity(coordinates);
            return !(entity instanceof Rock)
                    && !(entity instanceof Tree)
                    && !(entity instanceof Predator)
                    && !(entity instanceof Herbivore);
        }
        return true;
    }
}
