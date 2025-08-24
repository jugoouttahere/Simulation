public class Renderer {

    public void render(WorldMap worldMap) {
        for (int row = 0; row < worldMap.row; row++) {
            for (int col = 0; col < worldMap.col; col++) {
                Entity entity = worldMap.getEntity(row, col);

                if (entity == null) {
                    System.out.print(".  ");
                } else if (entity instanceof Herbivore) {
                    System.out.print("H  ");
                } else if (entity instanceof Predator) {
                    System.out.print("P  ");
                } else if (entity instanceof Grass) {
                    System.out.print("G  ");
                } else if (entity instanceof Rock) {
                    System.out.print("R  ");
                } else if (entity instanceof Tree) {
                    System.out.print("T  ");
                } else {
                    System.out.print("?  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
