public class MoveCreatures implements Actionable {
    private Board board;
    private BFS bfs;

    public MoveCreatures(Board board) {
        this.board = board;
        this.bfs = new BFS(board);
    }

    @Override
    public void execute(Board board) {
        for (Creature creature : board.getCreatures()) {

            Class<? extends Entity> targetEntity;
            if (creature instanceof Herbivore) {
                targetEntity = Grass.class;
            } else if (creature instanceof Predator) {
                targetEntity = Herbivore.class;
            } else {
                continue;
            }

            Coordinates nextStep = bfs.findNextStep(creature.getCoordinates(), targetEntity);
            if (nextStep != null) {
                creature.move(nextStep, board);
            }
        }
    }

    private Coordinates findTarget(Coordinates creaturePos) {
        Entity creature = board.getEntity(creaturePos);

        if (creature instanceof Herbivore) {
            return findNearest(creaturePos, Grass.class);
        }

        if (creature instanceof Predator) {
            return findNearest(creaturePos, Herbivore.class);
        }

        return null;
    }

    private Coordinates findNearest(Coordinates from, Class<? extends Entity> target) {
        Coordinates nearest = null;
        int bestDistance = Integer.MAX_VALUE;

        for (Entity entity : board.getEntities()) {
            if (target.isInstance(entity)) {
                Coordinates pos = entity.getCoordinates();

                int dist = bestDistanceFinder(from, pos);

                if (dist < bestDistance) {
                    bestDistance = dist;
                    nearest = pos;
                }
            }
        }

        return nearest;
    }

    private static int bestDistanceFinder(Coordinates creaturePos, Coordinates predatorPos) {
        int dist = Math.abs(creaturePos.getRow() - predatorPos.getRow())
                + Math.abs(creaturePos.getCol() - predatorPos.getCol());
        return dist;
    }
}
