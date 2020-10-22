package pongGame;

import java.awt.*;

public class Score extends Rectangle{

    int player1 = 0;
    int player2 = 0;

    Score(){
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

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("Consolas",Font.PLAIN,60));

        g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), 20, 90);
        g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10), 100, 90);
    }
}