package base;

import tklibs.SpriteUtils;

public class Background extends GameObject {
    public Background() {
        this.image = SpriteUtils.loadImage("assets/images/background/0.png");
        this.y = - this.image.getHeight() + GameWindow.height;
    }

    @Override
    public void run() {
        if (this.y < 0) {
            this.y += 10;
        } else {
            this.y = 0;
        }

    }
}
