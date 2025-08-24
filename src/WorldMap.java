import java.util.HashMap;
import java.util.Map;

public class WorldMap {
    int row;
    int col;

    Map<Coordinates, Entity> entities = new HashMap<>();

    public WorldMap(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void addEntity(Entity entity, int row, int col) {
        entity.row = row;
        entity.col = col;
        entities.put(new Coordinates(row, col), entity);
    }

    public Entity getEntity(int row, int col) {
        return entities.get(new Coordinates(row, col));
    }
}
