package pongGame;

import pongGame.Comand.CommandFactory;

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
    private final GameEnd gameEnd;
    private final GameStart gameStart;
    private final CommandFactory commandFactory;

    public WindowsMain() throws IOException {
        super.setPreferredSize(new Dimension(900, 600));
        super.pack();
        super.setVisible(true);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GameTable gameTable = new GameTable();

        this.gameStart = new GameStart();
        this.gameEnd = new GameEnd();
        this.gameLevel = new GameLevel(gameTable);
        this.gameRules = GameRules.getInstance();
        this.windowsRenderer = new WindowsRenderer();
        this.commandFactory = new CommandFactory();

        super.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
                if (gameRules.isGameJustStarted()) {
                    timer.start();
                }

                commandFactory.createCommandByKeyPressed(e, gameLevel).execute();

                if (gameRules.isGameOver()) {
                    timer.stop();
                    setVisible(false);
                    dispose();
                }

                movePaddles();
                checkPaddleCollisions();
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
            checkBallCollisions();
        });
    }

    private void movePaddles() {
        gameLevel.getPaddle1().move();
        gameLevel.getPaddle2().move();
    }

    private void checkPaddleCollisions() {
        gameRules.stopPaddleIfInTheCorner(gameLevel.getPaddle1());
        gameRules.stopPaddleIfInTheCorner(gameLevel.getPaddle2());
    }

    private void checkBallCollisions() {
        gameRules.bounceBallFromPaddle(gameLevel.getPaddle1(), gameLevel.getBall());
        gameRules.bounceBallFromPaddle(gameLevel.getPaddle2(), gameLevel.getBall());
        gameRules.changeDirectionIfBallHitWall(gameLevel.getBall(), gameLevel.getScore());
        gameRules.setGameEnd(gameLevel.getScore());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (gameRules.isGameJustStarted()) {
            this.gameStart.draw(g);
        } else {
            this.gameStart.deleteString(g);
        }

        if (gameRules.isGameOver()) {
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