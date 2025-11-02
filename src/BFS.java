import java.util.*;

public class BFS {
    private Board board;

    public BFS(Board board) {
        this.board = board;
    }

    public List<Coordinates> findPath(Coordinates start, Coordinates target) {
        Queue<Coordinates> queue = new LinkedList<>();
        Set<Coordinates> visited = new HashSet<>();
        HashMap<Coordinates, Coordinates> parents = new HashMap<>();
        List<Coordinates> path = new ArrayList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Coordinates current = queue.poll();

            if (current.equals(target)) {
                Coordinates next = target;
                while (next != null) {
                    path.add(next);
                    next = parents.get(next);
                }
                Collections.reverse(path);
                return path;
            }

            for (Coordinates neighbor : getNeighbors(current, board)) {
                if (!visited.contains(neighbor) &&
                        (board.isCellEmpty(neighbor) || neighbor.equals(target))) {
                    visited.add(neighbor);
                    parents.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        return Collections.emptyList();
    }

    private Set<Coordinates> getNeighbors(Coordinates coordinates, Board board) {
        Set<Coordinates> neighbors = new HashSet<>();
        int[][] directions = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1},
                {1, 1}, {-1, -1}, {1, -1}, {-1, 1}
        };

        for (int i = 0; i < directions.length; i++) {
            int dirRow = directions[i][0];
            int dirCol = directions[i][1];

            int newRow = coordinates.getRow() + dirRow;
            int newCol = coordinates.getCol() + dirCol;
            Coordinates newCoordinates = new Coordinates(newRow, newCol);

            if (!board.isCoordinatesOnBoard(newCoordinates)) {
                continue;
            }

            if ((board.getEntity(newCoordinates) instanceof Rock) || (board.getEntity(newCoordinates) instanceof Tree)) {
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
