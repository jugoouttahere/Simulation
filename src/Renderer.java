import java.util.HashMap;
import java.util.Map;

public class Renderer {
    private final Board board;
    private final Map<Class<? extends Entity>, String> spriteMap = new HashMap<>();

    private static final String EMPTY_CELL_SPRITE = "\u2B1B";
    private static final String HERBIVORE_SPRITE = "\uD83D\uDC07";
    private static final String PREDATOR_SPRITE = "\uD83D\uDC3A";
    private static final String GRASS_SPRITE = "\uD83C\uDF3F";
    private static final String TREE_SPRITE = "\uD83C\uDF32";
    private static final String ROCK_SPRITE = "\uD83E\uDEA8";

    public Renderer(Board board) {
        this.board = board;
        spriteMap.put(Herbivore.class, HERBIVORE_SPRITE);
        spriteMap.put(Predator.class, PREDATOR_SPRITE);
        spriteMap.put(Grass.class, GRASS_SPRITE);
        spriteMap.put(Tree.class, TREE_SPRITE);
        spriteMap.put(Rock.class, ROCK_SPRITE);
    }

    public void render() {
        for (int row = board.MAX_ROWS - 1; row >= 0; row--) {
            StringBuilder line = new StringBuilder();
            for (int col = 0; col < board.MAX_COLS - 1; col++) {
                Coordinates coordinates = new Coordinates(row, col);
                if (board.isCellEmpty(coordinates)) {
                    line.append(EMPTY_CELL_SPRITE);
                } else {
                    line.append(getSprite(coordinates));
                }
            }
            System.out.println(line);
        }
    }

    private String getSprite(Coordinates coordinates) {
        Entity entity = board.getEntity(coordinates);
        return spriteMap.getOrDefault(entity.getClass(),"");
    }
}
