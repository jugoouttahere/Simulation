import java.util.HashMap;
import java.util.Map;

public class Board {
    public static final int MAX_ROWS = 20;
    public static final int MAX_COLS = 20;

    public Map<Coordinates, Entity> entities = new HashMap<>();

    public void putEntity(Entity entity, Coordinates coordinates) {
        if (isValidCoordinates(coordinates)) {
            entity.coordinates = coordinates;
            entities.put(coordinates, entity);
        } else {
            throw new IllegalArgumentException("Координаты за границами доски: " + coordinates);
        }
    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public boolean isCellEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }

    public void removeEntity(Coordinates coordinates) {
        entities.remove(coordinates);
    }

    public boolean isValidCoordinates(Coordinates coordinates) {
        return coordinates.getRow() >= 0 && coordinates.getRow() <= MAX_ROWS &&
                coordinates.getCol() >= 0 && coordinates.getCol() <= MAX_COLS;
    }

}
