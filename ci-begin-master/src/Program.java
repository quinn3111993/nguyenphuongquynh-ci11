import base.game.GameWindow;
import base.game.GameCanvas;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {

    public static void main(String[] args) {
        GameWindow window = new GameWindow();
        GameCanvas canvas = new GameCanvas();
        window.add(canvas);
        window.setVisible(true);
        canvas.gameLoop();

    }
}

