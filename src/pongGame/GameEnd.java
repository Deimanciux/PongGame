package pongGame;

import java.awt.*;

public class GameEnd {

    public GameEnd() {
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("Consolas", Font.PLAIN, 40));
        g.drawString("Game Over(press Q to Exit)", 180, 90);
    }
}
