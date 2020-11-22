package pongGame.Comand;

import pongGame.GameRules;

public class GameStartCommand implements Command {
    public GameStartCommand() {
    }

    @Override
    public void execute() {
        GameRules.getInstance().startGame();
    }
}