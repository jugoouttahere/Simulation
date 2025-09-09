import java.util.List;

public class Simulation {
    private Board board = new Board();
    private Renderer renderer = new Renderer();
    private List<Action> initActions;
    private List<Action> turnActions;
    private int turnCount;

    public Simulation() {
        for (Action action : initActions) {
            action.execute(board);
        }
    }

    private void start() {
        while (true) {
            nextTurn();
        }
    }

    private void pause() {

    }

    private void nextTurn() {
        for (Action action : turnActions) {
            action.execute(board);
        }
        renderer.render(board);
        turnCount++;
    }
}
