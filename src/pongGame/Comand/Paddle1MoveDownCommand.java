package pongGame.Comand;

import pongGame.GameLevel;
import pongGame.GameRules;

public class Paddle1MoveDownCommand implements Command {
    private final GameLevel gameLevel;

    public Paddle1MoveDownCommand(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }

    @Override
    public void execute() {
        GameRules.getInstance().paddle1MoveDown(gameLevel.getPaddle1());
    }
}