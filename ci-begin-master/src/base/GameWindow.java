package base;

import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setTitle("Game Touhou");
        this.setResizable(false);
        this.setVisible(true);
    }
}
