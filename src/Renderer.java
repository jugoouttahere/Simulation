public class Renderer {

    private static final String EMPTY_CELL_SPRITE = "\u2B1B";
    private static final String HERBIVORE_SPRITE = "\uD83D\uDC07";
    private static final String PREDATOR_SPRITE = "\uD83D\uDC3A";
    private static final String GRASS_SPRITE = "\uD83C\uDF3F";
    private static final String TREE_SPRITE = "\uD83C\uDF32";
    private static final String ROCK_SPRITE = "\uD83E\uDEA8";

    public void render(Board board) {
        for (int row = 10; row > 0; row--) {
            StringBuilder line = new StringBuilder();
            for (int col = 0; col < 10; col++) {
                Coordinates coordinates = new Coordinates(row, col);
                if (board.isCellEmpty(coordinates)) {
                    line.append(EMPTY_CELL_SPRITE);
                } else {
                    line.append(getSprite(board, coordinates));
                }
            }
            System.out.println(line);
        }
    }

    private String getSprite(Board board, Coordinates coordinates) {
        Entity entity = board.getEntity(coordinates);
        switch (entity.getClass().getSimpleName()) {
            case "Herbivore":
                return HERBIVORE_SPRITE;
            case "Predator":
                return PREDATOR_SPRITE;
            case "Grass":
                return GRASS_SPRITE;
            case "Tree":
                return TREE_SPRITE;
            case "Rock":
                return ROCK_SPRITE;
        }
        return "";
    }
}
