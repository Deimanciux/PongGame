package pongGame;

import javax.swing.*;
import java.awt.*;

public class GameStart extends TextDrawer {

    public GameStart() {
        super(new Position(90, 180), 40);
    }

    @Override
    String setText() {
        return "If you want to start press Y";
    }

    public void deleteString(Graphics g) {
        g.setColor(UIManager.getColor("Panel.background"));
        g.fillRect(0, 0, 500, 100);
    }
}