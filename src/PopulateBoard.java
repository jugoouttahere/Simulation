import java.util.Random;

public class PopulateBoard implements Action {
    private final int countHerbivores;
    private final int countPredators;
    private final int countGrass;
    private final int countTrees;
    private final int countRocks;

    public PopulateBoard(int countHerbivores, int countPredators, int countGrass, int countTrees, int countRocks) {
        this.countHerbivores = countHerbivores;
        this.countPredators = countPredators;
        this.countGrass = countGrass;
        this.countTrees = countTrees;
        this.countRocks = countRocks;
    }

    @Override
    public void execute(Board board) {
        for (int i = 0; i < countHerbivores; i++) {
            Coordinates emptyCoordinates = getRandomEmptyCoord(board);
            board.putEntity(new Herbivore(1, 10, emptyCoordinates), emptyCoordinates);
        }

        for (int i = 0; i < countPredators; i++) {
            Coordinates emptyCoordinates = getRandomEmptyCoord(board);
            board.putEntity(new Predator(1, 20, 5, emptyCoordinates), emptyCoordinates);
        }

        for (int i = 0; i < countGrass; i++) {
            Coordinates emptyCoordinates = getRandomEmptyCoord(board);
            board.putEntity(new Grass(emptyCoordinates), emptyCoordinates);
        }

        for (int i = 0; i < countTrees; i++) {
            Coordinates emptyCoordinates = getRandomEmptyCoord(board);
            board.putEntity(new Tree(emptyCoordinates), emptyCoordinates);
        }

        for (int i = 0; i < countRocks; i++) {
            Coordinates emptyCoordinates = getRandomEmptyCoord(board);
            board.putEntity(new Rock(emptyCoordinates), emptyCoordinates);
        }

    }

    private Coordinates getRandomEmptyCoord(Board board) {
        Random random = new Random();
        Coordinates randCoordinate;

        do {
            randCoordinate = new Coordinates(
                    random.nextInt(Board.MAX_ROWS), random.nextInt(Board.MAX_COLS));
        } while (!board.isCellEmpty(randCoordinate));

        return randCoordinate;
    }
}
