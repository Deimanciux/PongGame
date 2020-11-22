package pongGame;

import java.awt.*;

public abstract class TextDrawer {
    protected Position position;
    protected int size;

    TextDrawer(Position position, int size) {
        this.position = position;
        this.size = size;
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("Consolas", Font.PLAIN, size));
        g.drawString(setText(), position.getX(), position.getY());
    }

    abstract String setText();
}