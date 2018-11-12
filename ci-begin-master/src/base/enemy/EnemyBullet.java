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
        this.velocity.set(0,5);
    }

    @Override
    public void run() {
        super.run();
        this.destroyIfNeeded();
    }

    private void destroyIfNeeded() {
        if(this.position.y < -20 || this.position.y >= Settings.SCREEN_HEIGHT || this.position.x <0 || this.position.x > Settings.BACKGROUND_WIDTH) {
            this.destroy();
        }
    }
}
