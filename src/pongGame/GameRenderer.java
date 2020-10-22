package pongGame;

import java.util.ArrayList;

public class GameRenderer {

    public void renderMap(GameTable gameTable, Ball ball, ArrayList<Paddle> paddles) {

        for (int y = 0; y < gameTable.height(); y++) {
            for (int x = 0; x < gameTable.width(); x++) {

                if (printPaddle(paddles, y, x)) {
                    continue;
                }

                if (ball.at(y, x)) {
                    System.out.print("o");
                } else if (gameTable.isWall(y, x)) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private boolean printPaddle(ArrayList<Paddle> paddles, int y, int x) {
        for (Paddle paddle : paddles) {
            for (Position position : paddle.getPositions()) {
                if (position.at(y, x)) {
                    System.out.print("|");

                    return true;
                }
            }
        }

        return false;
    }
}
