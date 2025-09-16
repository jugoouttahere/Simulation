import java.util.*;

public class BFS {
    Queue<Coordinates> queue = new LinkedList<>();
    Set<Coordinates> visited = new HashSet<>();

//    HashMap<Coordinates, Set<Coordinates>> neighbors = new HashMap<>();
//    HashMap<Coordinates, Coordinates> parents = new HashMap<>();


    public void addToQueue(Coordinates current) {
        queue.add(current);
    }

    public void setVisited(Coordinates current) {
        visited.add(current);
    }

    public Coordinates findTargetBFS(Board board, Coordinates current, Coordinates target) {
        addToQueue(current);
        setVisited(current);

        current = null;

        while (!queue.isEmpty()) {
            Coordinates coordinate = queue.poll();
            if (coordinate == target) {
                return coordinate;
            }
        }

        return null;

    }

    public Set<Coordinates> getNeighbors(Creature creature, Board board) {
        Set<Coordinates> neighbors = new HashSet<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < directions.length; i++) {
            Coordinates coord = creature.coordinates;

            int newRow = coord.getRow() + directions[i][0];
            int newCol = coord.getCol() + directions[i][1];

            Coordinates newCoordinates = new Coordinates(newRow, newCol);

            if (board.isValidCoordinates(newCoordinates) && creature.isValidMove(board, newCoordinates)) {
                neighbors.add(newCoordinates);
            }
        }
        return neighbors;
    }

}
