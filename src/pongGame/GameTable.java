package pongGame;

public class GameTable {
    static final int TABLE_HEIGHT = 21;
    static final int TABLE_WIDTH = 40;
    private final int[][] table = new int[TABLE_HEIGHT][TABLE_WIDTH];

    public GameTable() {
        initiateTable();
    }

    private void initiateTable() {
        for (int y = 0; y < TABLE_HEIGHT; y++) {
            for (int x = 0; x < TABLE_WIDTH; x++) {

                if (x == 0 || y == 0 || x == TABLE_WIDTH - 1 || y == TABLE_HEIGHT - 1) {
                    table[y][x] = 1;
                } else {
                    table[y][x] = 0;
                }
            }
        }
    }

    public boolean isWall(int y, int x) {
        return table[y][x] == 1;
    }

    public int width() {
        return TABLE_WIDTH;
    }
}