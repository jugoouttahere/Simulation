import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class PopulateBoard implements Action {
    private Set<Coordinates> usedCoordinates = new HashSet<>();

    @Override
    public void execute(Board board) {
        for (int i = 0; i < WorldGenerator.HERBIVORE_COUNT; i++) {
            spawnHerbivore(board);
        }

        for (int i = 0; i < WorldGenerator.PREDATOR_COUNT; i++) {
            spawnPredator(board);
        }

        for (int i = 0; i < WorldGenerator.GRASS_COUNT; i++) {
            spawnGrass(board);
        }

        for (int i = 0; i < WorldGenerator.TREE_COUNT; i++) {
            spawnTree(board);
        }

        for (int i = 0; i < WorldGenerator.ROCK_COUNT; i++) {
            spawnRock(board);
        }
    }

    private void spawnPredator(Board board) {
        Coordinates coordinates = getRandomUniqueCoordinates(board);
        board.putEntity(new Predator(coordinates,1,1,1), coordinates);
        usedCoordinates.add(coordinates);
    }

    private void spawnHerbivore(Board board) {
        Coordinates coordinates = getRandomUniqueCoordinates(board);
        board.putEntity(new Herbivore(coordinates,1,1), coordinates);
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
        Random random = new Random();
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
