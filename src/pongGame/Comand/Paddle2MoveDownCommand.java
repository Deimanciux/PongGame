package pongGame.Comand;

import pongGame.GameLevel;
import pongGame.GameRules;

public class Paddle2MoveDownCommand implements Command {
    private final GameLevel gameLevel;

    public Paddle2MoveDownCommand(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }

    @Override
    public void execute() {
        GameRules.getInstance().paddle2MoveDown(gameLevel.getPaddle2());
    }
}