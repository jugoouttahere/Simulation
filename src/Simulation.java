import java.util.List;

public class Simulation {

    private WorldMap worldMap = new WorldMap(5,5);
    private Renderer renderer = new Renderer();
    private List<Action> init;
    private List<Action> turn;
    private int turnCount;

    public Simulation() {
        for (Action action : init) {
            action.execute(worldMap);
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

        for (Action action : turn) {
            action.execute(worldMap);
        }

        renderer.render(worldMap);
        turnCount++;
    }
}
