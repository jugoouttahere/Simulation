import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class PopulateBoard implements Actionable {
    private Set<Coordinates> usedCoordinates = new HashSet<>();
    private Random random = new Random();

    @Override
    public void execute(Board board) {
        spawnEntity(board, WorldGenerator.HERBIVORE_COUNT, "Herbivore");
        spawnEntity(board, WorldGenerator.PREDATOR_COUNT, "Predator");
        spawnEntity(board, WorldGenerator.GRASS_COUNT, "Grass");
        spawnEntity(board, WorldGenerator.TREE_COUNT, "Tree");
        spawnEntity(board, WorldGenerator.ROCK_COUNT, "Rock");
    }

    private void spawnEntity(Board board, int count, String type) {
        for (int i = 0; i < count; i++) {
            switch (type) {
                case "Herbivore":
                    spawnHerbivore(board);
                    break;
                case "Predator":
                    spawnPredator(board);
                    break;
                case "Grass":
                    spawnGrass(board);
                    break;
                case "Tree":
                    spawnTree(board);
                    break;
                case "Rock":
                    spawnRock(board);
                    break;
            }
        }
    }

    private void spawnPredator(Board board) {
        Coordinates coordinates = getRandomUniqueCoordinates(board);
        board.putEntity(new Predator(coordinates, 1, 1, 1), coordinates);
        usedCoordinates.add(coordinates);
    }

    private void spawnHerbivore(Board board) {
        Coordinates coordinates = getRandomUniqueCoordinates(board);
        board.putEntity(new Herbivore(coordinates, 1, 1), coordinates);
        usedCoordinates.add(coordinates);
    }

    private void spawnRock(Board board) {
        Coordinates coordinates = getRandomUniqueCoordinates(board);
        board.putEntity(new Rock(coordinates), coordinates);
        usedCoordinates.add(coordinates);
    }

    private void spawnTree(Board board) {
        Coordinates coordinates = getRandomUniqueCoordinates(board);
        board.putEntity(new Tree(coordinates), coordinates);
        usedCoordinates.add(coordinates);
    }

    private void spawnGrass(Board board) {
        Coordinates coordinates = getRandomUniqueCoordinates(board);
        board.putEntity(new Grass(coordinates), coordinates);
        usedCoordinates.add(coordinates);
    }

    private Coordinates getRandomUniqueCoordinates(Board board) {
        Coordinates coordinates;
        do {
            coordinates = new Coordinates(
                    random.nextInt(board.MAX_ROWS),
                    random.nextInt(board.MAX_COLS)
            );
        } while (usedCoordinates.contains(coordinates));
        return coordinates;
    }
}
