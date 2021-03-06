package pongGame;

public class Position {
    private int x;
    private int y;

    public Position(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean at(int y, int x) {
        return this.y == y && this.x == x;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}