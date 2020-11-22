package pongGame;

public class GameLevel {
    private final GameTable gameTable;
    private Score score;
    private Paddle paddle1;
    private Paddle paddle2;
    private Ball ball;

    public GameLevel(GameTable gameTable) {
        this.gameTable = gameTable;
        createNewBall();
        createNewPaddle1();
        createNewPaddle2();
        createNewScore();
    }

    public void createNewBall() {
        this.ball = new Ball(new Position(GameTable.TABLE_HEIGHT / 2, GameTable.TABLE_WIDTH / 2));
    }

    public void createNewPaddle1() {
        this.paddle1 = new Paddle(1, new Position(GameTable.TABLE_HEIGHT / 2, 1));
    }

    public void createNewPaddle2() {
        this.paddle2 = new Paddle(2, new Position(GameTable.TABLE_HEIGHT / 2, gameTable.width() - 2));
    }

    public void createNewScore() {
        this.score = new Score();
    }

    public GameTable getGameTable() {
        return gameTable;
    }

    public Paddle getPaddle1() {
        return paddle1;
    }

    public Paddle getPaddle2() {
        return paddle2;
    }

    public Ball getBall() {
        return ball;
    }

    public Score getScore() {
        return score;
    }
}