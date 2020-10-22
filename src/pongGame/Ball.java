package pongGame;

import java.util.Random;

public class Ball {
    private int xDirection;
    private int yDirection;
    private final Position position;

    Ball(Position position) {
        this.position = position;
        setXDirection(randomDirection());
        setYDirection(randomDirection());
    }

    public int randomDirection() {
        Random random = new Random();
        int randomDirection = random.nextInt(2);

        if (randomDirection == 0) {
            randomDirection--;
        }

        return randomDirection;
    }

    public void setXDirection(int randomXDirection) {
        xDirection = randomXDirection;
    }

    public void setYDirection(int randomYDirection) {
        yDirection = randomYDirection;
    }

    public int getXDirection() {
        return xDirection;
    }

    public void changeYDirection(int changer) {
        yDirection = yDirection * changer;
    }

    public void changeXDirection(int changer) {
        xDirection = xDirection * changer;
    }

    public Position getPosition() {
        return position;
    }

    public void move() {
        position.setX(position.getX() + xDirection);
        position.setY(position.getY() + yDirection);
    }
}
