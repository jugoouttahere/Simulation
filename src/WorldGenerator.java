public class WorldGenerator implements Action {
    private Board board;
    public final static int PREDATOR_COUNT = 1;
    public final static int HERBIVORE_COUNT = 5;
    public final static int GRASS_COUNT = 10;
    public final static int ROCK_COUNT = 5;
    public final static int TREE_COUNT = 5;

    public WorldGenerator(Board board) {
        this.board = board;
    }

    @Override
    public void execute(Board board) {
        spawnEntities(board);
    }

    private void spawnEntities(Board board) {
        PopulateBoard spawner = new PopulateBoard();
        spawner.execute(board);
    }
}
