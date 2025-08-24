public class Main {
    public static void main(String[] args) {
        WorldMap worldMap = new WorldMap(5, 5);

        worldMap.addEntity(new Herbivore(), 1, 1);
        worldMap.addEntity(new Predator(), 2, 2);
        worldMap.addEntity(new Grass(), 1, 3);
        worldMap.addEntity(new Rock(), 3, 3);
        worldMap.addEntity(new Tree(), 4, 1);

        Renderer renderer = new Renderer();
        renderer.render(worldMap);
    }
}
