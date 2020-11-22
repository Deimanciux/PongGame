package pongGame.Comand;

import pongGame.GameRules;

public class GameEndCommand implements Command {
    public GameEndCommand() {
    }

    @Override
    public void execute() {
        GameRules.getInstance().endGame();
    }
}