package pongGame;

import java.io.IOException;

public class ConsoleInput {
    public int readConsoleInput() {
        int key = 0;
        do {
            try {
                key = System.in.read();
            } catch (IOException e){
                System.out.println("Failed");
            }

        } while(key == 13 || key == 10);
        return key;
    }
}
