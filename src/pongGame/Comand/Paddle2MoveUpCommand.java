package pongGame.Comand;

import pongGame.GameLevel;
import pongGame.GameRules;

public class Paddle2MoveUpCommand implements Command {
    private final GameLevel gameLevel;

    public Paddle2MoveUpCommand(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }

    @Override
    public void execute() {
        GameRules.getInstance().paddle2MoveUp(gameLevel.getPaddle2());
    }
}