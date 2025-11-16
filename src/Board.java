import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    public final int MAX_ROWS = 10;
    public final int MAX_COLS = 10;

    private Map<Coordinates, Entity> board = new HashMap<>();

    public Entity getEntity(Coordinates coordinates) {
        return board.get(coordinates);
    }

    public void putEntity(Entity entity, Coordinates coordinates) {
        if (isCoordinatesOnBoard(coordinates) && isCellEmpty(coordinates)) {
            entity.setCoordinates(coordinates);
            board.put(coordinates, entity);
        }
    }

    public void put(Coordinates coordinates, Entity entity) {
        board.put(coordinates, entity);
    }

    public void removeEntity(Coordinates coordinates) {
        board.remove(coordinates);
    }

    public List<Entity> getEntities() {
        return board.values().stream().toList();
    }

    public List<Creature> getCreatures() {
        List<Creature> creatures = new ArrayList<>();

        for (Entity entity : getEntities()) {
            if (entity instanceof Creature) {
                creatures.add((Creature) entity);
            }
        }

        return creatures;
    }

    public boolean isCellEmpty(Coordinates coordinates) {
        if (coordinates == null) {
            return true;
        }
        return !board.containsKey(coordinates);
    }

    public boolean isCoordinatesOnBoard(Coordinates coordinates) {
        return (coordinates.getRow() >= 0 && coordinates.getRow() < MAX_ROWS) &&
                (coordinates.getCol() >= 0 && coordinates.getCol() < MAX_COLS);
    }
}