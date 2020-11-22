package pongGame.Comand;

import pongGame.GameLevel;

import java.awt.event.KeyEvent;

public class CommandFactory {

    public Command createCommandByKeyPressed(KeyEvent e, GameLevel gameLevel) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                return new Paddle1MoveUpCommand(gameLevel);
            case KeyEvent.VK_UP:
                return new Paddle2MoveUpCommand(gameLevel);
            case KeyEvent.VK_S:
                return new Paddle1MoveDownCommand(gameLevel);
            case KeyEvent.VK_DOWN:
                return new Paddle2MoveDownCommand(gameLevel);
            case KeyEvent.VK_Y:
                return new GameStartCommand();
            case KeyEvent.VK_Q:
                return new GameEndCommand();
        }
        throw new RuntimeException("There is no such command");
    }
}