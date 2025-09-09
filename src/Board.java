import java.util.HashMap;
import java.util.Map;

public class Board {
    public Map<Coordinates, Entity> entities = new HashMap<>();

    public void putEntity(Entity entity, Coordinates coordinates) {
        entity.coordinates = coordinates;
        entities.put(coordinates, entity);
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


}
