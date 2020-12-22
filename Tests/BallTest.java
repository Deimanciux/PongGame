package pongGame.Tests;

import org.junit.Test;
import pongGame.Ball;
import pongGame.Position;

import static org.junit.Assert.assertEquals;

public class BallTest {
    @Test
    public void testChangeYDirection() {
        Ball ball = new Ball(new Position(1, 5));
        ball.setYDirection(1);

        ball.changeYDirection(-1);

        assertEquals(-1, ball.getyDirection());
    }
}