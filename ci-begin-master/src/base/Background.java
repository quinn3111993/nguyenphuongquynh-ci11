package base;

import tklibs.SpriteUtils;

public class Background extends GameObject {
    public Background() {
        this.image = SpriteUtils.loadImage("assets/images/background/0.png");
        this.y = - this.image.getHeight();
    }

    @Override
    public void run() {
        this.y += 10;
        if (this.y > 0) {
            this.y = 0;
        }

    }
}
