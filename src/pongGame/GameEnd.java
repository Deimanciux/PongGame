package pongGame;

public class GameEnd extends TextDrawer {
    public GameEnd() {
        super(new Position(90, 180), 40);
    }

    @Override
    String setText() {
        return "Game Over(press Q to Exit)";
    }
}