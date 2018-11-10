package base.enemy;

import base.GameObject;
import base.game.Settings;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject {
    public EnemyBullet() {
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        this.renderer = new SingleImageRenderer(image);
    }

    @Override
    public void run() {
        super.run();
        this.position.addThis(0, 5);
        if(this.position.y > Settings.SCREEN_HEIGHT || this.position.x < 0 || this.position.x > Settings.SCREEN_WIDTH) {
            this.destroy();
        }
    }
}
