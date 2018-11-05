package base.enemy;

import base.GameObject;
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
        this.position.addThis(0,5);
    }
}
