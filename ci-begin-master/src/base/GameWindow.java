package base;

import javax.swing.*;

public class GameWindow extends JFrame {
    static int height = 600;
    static int width = 800;
    public GameWindow() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(this.width, this.height);
        this.setTitle("Game Touhou");
        this.setResizable(false);
        this.setVisible(true);
    }
}
