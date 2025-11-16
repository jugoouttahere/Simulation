import java.util.*;

public class BFS {
    private final Board board;
    private final int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
            {1, 1}, {-1, -1}, {1, -1}, {-1, 1}
    };

    public BFS(Board board) {
        this.board = board;
    }

    public Coordinates findNextStep(Coordinates start, Class<? extends Entity> targetEntity) {
        Queue<Coordinates> queue = new LinkedList<>();
        Set<Coordinates> visited = new HashSet<>();
        HashMap<Coordinates, Coordinates> parents = new HashMap<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Coordinates current = queue.poll();
            Entity entity = board.getEntity(current);

            if (targetEntity.isInstance(entity)) {
                Coordinates nextStep = current;
                while (parents.get(nextStep) != null && !parents.get(nextStep).equals(start)) {
                    nextStep = parents.get(nextStep);
                }
                return nextStep;
            }

            for (Coordinates neighbor : getNeighbors(current, board)) {
                if (!visited.contains(neighbor) &&
                        (board.isCellEmpty(neighbor) || (board.getEntity(neighbor) != null && targetEntity.isInstance(board.getEntity(neighbor))))) {
                    visited.add(neighbor);
                    parents.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        return null;
    }

    private Set<Coordinates> getNeighbors(Coordinates coordinates, Board board) {
        Set<Coordinates> neighbors = new HashSet<>();

        for (int i = 0; i < directions.length; i++) {
            int dirRow = directions[i][0];
            int dirCol = directions[i][1];

            int newRow = coordinates.getRow() + dirRow;
            int newCol = coordinates.getCol() + dirCol;
            Coordinates newCoordinates = new Coordinates(newRow, newCol);

            if (!board.isCoordinatesOnBoard(newCoordinates)) {
                continue;
            }

            Entity entity = board.getEntity(newCoordinates);
            if (entity instanceof Rock || entity instanceof Tree) {
                continue;
            }

            if (Math.abs(dirRow) + Math.abs(dirCol) == 2) {
                Coordinates side1 = new Coordinates(coordinates.getRow() + dirRow, coordinates.getCol());
                Coordinates side2 = new Coordinates(coordinates.getRow(), coordinates.getCol() + dirCol);

                Entity entity1 = board.getEntity(side1);
                Entity entity2 = board.getEntity(side2);

                if (entity1 instanceof Rock || entity1 instanceof Tree ||
                        entity2 instanceof Rock || entity2 instanceof Tree) {
                    continue;
                }
            }

            neighbors.add(newCoordinates);
        }
        return neighbors;
    }
}
