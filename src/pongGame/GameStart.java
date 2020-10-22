package pongGame;

import javax.swing.*;
import java.awt.*;

public class GameStart {
    public GameStart() {
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("Consolas", Font.PLAIN, 40));
        g.drawString("If you want to start press Y", 180, 90);
    }

    public void deleteString(Graphics g) {
        g.setColor(UIManager.getColor("Panel.background"));
        g.fillRect(0, 0, 500, 100);
    }
}
