package pongGame;

import java.util.ArrayList;

public class GameRules {

    static final int POINTS_FOR_END = 1;
    private boolean gameOver = false;
    private boolean gameJustStarted = true;

    public GameRules() {
    }

    public void processUserInput(int key, Paddle paddle) {
        switch (paddle.getId()) {
            case 1:
                if (key == 'w') {
                    paddle.setYDirection(-1);
                }
                if (key == 's') {
                    paddle.setYDirection(1);
                }
                break;
            case 2:
                if (key == 'e') {
                    paddle.setYDirection(-1);
                }
                if (key == 'd') {
                    paddle.setYDirection(1);
                }
                break;
        }
    }


    public void changeDirectionIfBallHitWall(Ball ball, Score score) {

        if (ball.getPosition().getY() <= 1) {
            ball.changeYDirection(-1);

            return;
        }

        if (ball.getPosition().getX() <= 1) {
            ball.changeXDirection(-1);
            score.setPlayer1(score.getPlayer1() + 1);

            return;
        }

        if (ball.getPosition().getY() >= GameTable.TABLE_HEIGHT - 2) {
            ball.changeYDirection(-1);

            return;
        }

        if (ball.getPosition().getX() >= GameTable.TABLE_WIDTH - 2) {
            ball.changeXDirection(-1);
            score.setPlayer2(score.getPlayer1() + 1);
        }
    }

    public void stopPaddlesIfInTheCorner(ArrayList<Paddle> paddles) {
        for (Paddle paddle : paddles) {
            for (Position position : paddle.getPositions()) {
                if (position.getY() <= 0) {
                    defineUpperCornerPositions(paddle);
                    continue;
                }

                if (position.getY() >= GameTable.TABLE_HEIGHT - Paddle.PADDLE_HEIGHT + 1) {
                    defineLowerCornerPositions(paddle);
                }
            }
        }

    }

    public void stopPaddleIfInTheCorner(Paddle paddle) {
        for (Position position : paddle.getPositions()) {
            if (position.getY() <= 0) {
                defineUpperCornerPositions(paddle);
                continue;
            }

            if (position.getY() >= GameTable.TABLE_HEIGHT - Paddle.PADDLE_HEIGHT + 1) {
                defineLowerCornerPositions(paddle);
            }
        }
    }

    private void defineUpperCornerPositions(Paddle paddle) {
        int i = 1;

        for (Position position : paddle.getPositions()) {
            position.setY(i);
            i++;
        }
    }

    private void defineLowerCornerPositions(Paddle paddle) {
        int i = GameTable.TABLE_HEIGHT - Paddle.PADDLE_HEIGHT - 1;

        for (Position position : paddle.getPositions()) {
            position.setY(i);
            i++;
        }
    }

    public void bounceBallFromPaddle(Paddle paddle, Ball ball) {
        if (paddle.isNearPaddle(ball.getPosition(), 1)) {
            ball.setXDirection(Math.abs(ball.getXDirection()));

            if (paddle.getId() == 2) {
                ball.setXDirection(ball.getXDirection() * (-1));
            }
        }
    }

    public void incrementScore(Paddle paddle, Score score) {
        if(paddle.getId() == 1) {
            score.setPlayer1(score.getPlayer1() + 1);
        } else {
            score.setPlayer2(score.getPlayer2() + 1);
        }
    }

    public void makeGameEnd(Score score) {
        if(score.getPlayer1() ==  POINTS_FOR_END || score.getPlayer2() ==  POINTS_FOR_END) {
            setGameOver(true);
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isGameJustStarted() {
        return gameJustStarted;
    }

    public void setGameJustStarted(boolean gameJustStarted) {
        this.gameJustStarted = gameJustStarted;
    }
}
