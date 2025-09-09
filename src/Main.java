public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Renderer renderer = new Renderer();

        board.putEntity(new Herbivore(2,2,new Coordinates(1,2)), new Coordinates(1,2));
        board.putEntity(new Tree(new Coordinates(2,4)),new Coordinates(2,4));
        board.putEntity(new Rock(new Coordinates(2,5)),new Coordinates(2,5));
        board.putEntity(new Grass(new Coordinates(3,4)),new Coordinates(3,4));
        board.putEntity(new Predator(2,2,4,new Coordinates(5,6)), new Coordinates(5,6));

        renderer.render(board);
    }
}
