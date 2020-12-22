package pongGame.Tests;

import org.junit.Test;
import pongGame.GameRules;
import pongGame.Paddle;
import pongGame.Position;

import static org.junit.Assert.assertEquals;

public class GameRulesTest {
    @Test
    public void testPaddle1MoveUp() {
        Paddle paddle = new Paddle(1, new Position(5, 1));
        GameRules.getInstance().paddle1MoveUp(paddle);

        assertEquals(-1, paddle.getyDirection());
    }

    @Test
    public void testPaddle1MoveDown() {
        Paddle paddle = new Paddle(1, new Position(5, 1));
        GameRules.getInstance().paddle1MoveDown(paddle);

        assertEquals(1, paddle.getyDirection());
    }
}
