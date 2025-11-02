import java.util.List;

public class MoveCreatures implements Action {
    private Board board;
    private BFS bfs;

    public MoveCreatures(Board board) {
        this.board = board;
        this.bfs = new BFS(board);
    }

    @Override
    public void execute(Board board) {
        for (Creature creature : board.getCreatures()) {
            List<Coordinates> path = bfs.findPath(creature.getCoordinates(), findNearestTarget(creature.getCoordinates()));

            creature.move(path.get(1), board);
        }
    }

    private Coordinates findNearestTarget(Coordinates creaturePos) {
        Coordinates nearest = null;
        int bestDistance = Integer.MAX_VALUE;

        if (board.getEntity(creaturePos) instanceof Herbivore) {
            for (Entity entity : board.getEntities()) {
                if (entity instanceof Grass) {
                    Coordinates grassPos = entity.getCoordinates();
                    List<Coordinates> path = bfs.findPath(creaturePos, grassPos);
                    if (path != null && path.size() < bestDistance) {
                        bestDistance = path.size();
                        nearest = grassPos;
                    }
                }
            }
        }

        if (board.getEntity(creaturePos) instanceof Predator) {
            for (Entity entity : board.getEntities()) {
                if (entity instanceof Herbivore) {
                    Coordinates grassPos = entity.getCoordinates();
                    List<Coordinates> path = bfs.findPath(creaturePos, grassPos);
                    if (path != null && path.size() < bestDistance) {
                        bestDistance = path.size();
                        nearest = grassPos;
                    }
                }
            }
        }

        return nearest;
    }
}
