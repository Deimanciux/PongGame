package pongGame.Comand;

import pongGame.GameLevel;
import pongGame.GameRules;

public class Paddle1MoveUpCommand implements Command {
    private final GameLevel gameLevel;

    public Paddle1MoveUpCommand(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }

    @Override
    public void execute() {
        GameRules.getInstance().paddle1MoveUp(gameLevel.getPaddle1());
    }
}