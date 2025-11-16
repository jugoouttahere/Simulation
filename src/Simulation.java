import java.util.List;

public class Simulation {
    private Board board = new Board();
    private Renderer renderer = new Renderer(board);
    private WorldGenerator worldGenerator = new WorldGenerator(board);
    private MoveCreatures moveCreatures = new MoveCreatures(board);
    private int turnCount;

    public Simulation() {
        worldGenerator.execute(board);
    }

    public void start() throws InterruptedException {
        while (true) {
            nextTurn();
            Thread.sleep(500);
        }
    }

    public void pause() {

    }

    public void nextTurn() {
        moveCreatures.execute(board);
        renderer.render();
        System.out.println();
        turnCount++;
    }
}
