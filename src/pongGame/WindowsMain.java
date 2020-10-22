package pongGame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class WindowsMain extends JFrame {

    private final GameLevel gameLevel;
    private final GameRules gameRules;
    private final WindowsRenderer windowsRenderer;
    private final Timer timer;
    private GameEnd gameEnd;
    private GameStart gameStart;

    public WindowsMain() throws IOException {
        super.setPreferredSize(new Dimension(900, 600));
        super.pack();
        super.setVisible(true);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Score score = new Score();
        gameStart = new GameStart();
        gameEnd = new GameEnd();
        GameTable gameTable = new GameTable();

        this.gameLevel = new GameLevel(gameTable, score);
        this.gameRules = new GameRules();
        this.windowsRenderer = new WindowsRenderer();

        super.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                        gameLevel.getPaddle1().setYDirection(-1);
                        break;
                    case KeyEvent.VK_S:
                        gameLevel.getPaddle1().setYDirection(1);
                        break;
                    case KeyEvent.VK_UP:
                        gameLevel.getPaddle2().setYDirection(-1);
                        break;
                    case KeyEvent.VK_DOWN:
                        gameLevel.getPaddle2().setYDirection(1);
                        break;
                    case KeyEvent.VK_Y:
                        if(gameRules.isGameJustStarted()) {
                            timer.start();
                            gameRules.setGameJustStarted(false);
                        }
                        break;
                    case KeyEvent.VK_Q:
                        timer.stop();
                        setVisible(false);
                        dispose();
                }
                gameLevel.getPaddle1().move();
                gameLevel.getPaddle2().move();
                gameRules.stopPaddleIfInTheCorner(gameLevel.getPaddle1());
                gameRules.stopPaddleIfInTheCorner(gameLevel.getPaddle2());

                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                    case KeyEvent.VK_S:
                        gameLevel.getPaddle1().setYDirection(0);
                        break;
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_DOWN:
                        gameLevel.getPaddle2().setYDirection(0);
                        break;
                }
            }
        });

        timer = new Timer(300, e -> {
            repaint();

            gameLevel.getBall().move();
            gameRules.bounceBallFromPaddle(gameLevel.getPaddle1(), gameLevel.getBall());
            gameRules.bounceBallFromPaddle(gameLevel.getPaddle2(), gameLevel.getBall());
            gameRules.changeDirectionIfBallHitWall(gameLevel.getBall(), gameLevel.getScore());
            gameRules.makeGameEnd(gameLevel.getScore());
        });

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if(gameRules.isGameJustStarted()) {
            this.gameStart.draw(g);
        } else {
            this.gameStart.deleteString(g);
        }

        if(gameRules.isGameOver()) {
            timer.stop();
            this.gameEnd.draw(g);
        }

        this.gameLevel.getScore().draw(g);
        this.windowsRenderer.render(g, this.gameLevel);
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            try {
                new WindowsMain();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static final long serialVersionUID = 1L;
}
