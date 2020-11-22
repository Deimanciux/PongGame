package pongGame;

public class Score extends TextDrawer {

    private int player1 = 0;
    private int player2 = 0;

    public Score() {
        super(new Position(90, 20), 50);
    }

    @Override
    protected String setText() {
        return (player1 / 10) + String.valueOf(player1 % 10) +
                " " + (player2 / 10) + player2 % 10;
    }

    public int getPlayer1() {
        return player1;
    }

    public void setPlayer1(int player1) {
        this.player1 = player1;
    }

    public int getPlayer2() {
        return player2;
    }

    public void setPlayer2(int player2) {
        this.player2 = player2;
    }
}