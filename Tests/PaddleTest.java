package pongGame.Tests;

import org.junit.Test;
import pongGame.Paddle;
import pongGame.Position;

import static org.junit.Assert.assertEquals;

public class PaddleTest {

    @Test
    public void testMoveDownPaddle() {
        Paddle paddle = new Paddle(1, new Position(10, 1));
        paddle.setYDirection(1);

        paddle.move();

        assertEquals(11, paddle.getPositions().get(0).getY());
    }

    @Test
    public void testMoveUpPaddle() {
        Paddle paddle = new Paddle(1, new Position(10, 1));
        paddle.setYDirection(-1);

        paddle.move();

        assertEquals(9, paddle.getPositions().get(0).getY());
    }
}
