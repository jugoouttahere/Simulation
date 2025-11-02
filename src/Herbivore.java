public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates, int speed, int hp) {
        super(coordinates, speed, hp);
    }

    public Herbivore(int row, int col, int speed, int hp) {
        super(row, col, speed, hp);
    }
}
