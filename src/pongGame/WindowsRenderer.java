package pongGame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class WindowsRenderer {

    private final BufferedImage ghostImage;
    private final BufferedImage wallImage;
    private final BufferedImage pacmanImage;

    public WindowsRenderer() throws IOException {
        pacmanImage = ImageIO.read(new FileInputStream("img/circle.png"));
        ghostImage = ImageIO.read(new FileInputStream("img/paddle.png"));
        wallImage = ImageIO.read(new FileInputStream("img/wall.png"));
    }

    public void render(Graphics g, GameLevel gameLevel) {
        g.drawImage(pacmanImage, 50 + gameLevel.getBall().getPosition().getX() * 20,
                100 + gameLevel.getBall().getPosition().getY() * 20, 20, 20, null);

        drawPaddle(g, gameLevel.getPaddle1());
        drawPaddle(g, gameLevel.getPaddle2());

        for (int y = 0; y < GameTable.TABLE_HEIGHT; y++) {
            for (int x = 0; x < GameTable.TABLE_WIDTH; x++)
                if (gameLevel.getGameTable().isWall(y, x)) {
                    g.drawImage(wallImage, 50 + x * 20, 100 + y * 20, 20, 20, null);
                }
        }
    }

    public void drawPaddle(Graphics g, Paddle paddle) {
        for (Position position : paddle.getPositions())
            g.drawImage(ghostImage, 50 + position.getX() * 20, 100 + position.getY() * 20, 20, 20,
                    null);
    }
}
