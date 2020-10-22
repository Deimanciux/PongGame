package pongGame;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        GameTable gameTable = new GameTable();
        GameRenderer gameRenderer = new GameRenderer();
        Ball ball = new Ball(new Position(5, 10));

        Paddle paddle1 = new Paddle(1, new Position(1, 1));
        Paddle paddle2 = new Paddle(2, new Position(6, gameTable.width() - 2));
        ArrayList<Paddle> paddles = new ArrayList<>();
        paddles.add(paddle1);
        paddles.add(paddle2);

        ConsoleInput consoleInput = new ConsoleInput();
        GameRules gameRules = new GameRules();
        Score score = new Score();

        /*while (!gameRules.isGameOver()) {

            //gameRenderer.renderMap(gameTable, ball, paddles);

            int key = consoleInput.readConsoleInput();
            gameRules.processUserInput(key, paddle1);

            int key1 = consoleInput.readConsoleInput();
            gameRules.processUserInput(key1, paddle2);

            ball.move();
            gameRules.changeDirectionIfBallHitWall(ball, score);

            paddle1.move();
            paddle2.move();
            gameRules.stopPaddlesIfInTheCorner(paddles);
            gameRules.bounceBallFromPaddle(paddle1, ball);
            gameRules.bounceBallFromPaddle(paddle2, ball);
        }*/
    }
}
