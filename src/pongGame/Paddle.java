package pongGame;

import java.util.ArrayList;

public class Paddle {
    static final int PADDLE_WIDTH = 1;
    static final int PADDLE_HEIGHT = 3;
    private final int id;
    private int yDirection;
    private final ArrayList<Position> positions = new ArrayList<>();
    private int score = 0;

    Paddle(int id, Position position) {
        this.id = id;

        for (int y = 0; y < PADDLE_HEIGHT; y++) {
            for (int x = 0; x < PADDLE_WIDTH; x++) {
                positions.add(new Position(position.getY() + y, position.getX() + x));
            }
        }
    }

    public void setYDirection(int yDirection) {
        this.yDirection = yDirection;
    }

    public void move() {
        for (Position position : positions) {
            position.setY(position.getY() + yDirection);
        }
    }

    public boolean isNearPaddle(Position position, int distance) {
        for (Position paddlePosition : positions) {
            if (paddlePosition.at(position.getY(), position.getX() - distance) || paddlePosition.at(position.getY(), position.getX() + distance)) {

                return true;
            }
        }
        return false;
    }

    public ArrayList<Position> getPositions() {
        return positions;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
