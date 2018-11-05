package base.enemy;

import base.GameObject;
import base.game.GameCanvas;
import base.game.Settings;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject {
    public Enemy() {
        super();
        this.createRenderer();
        this.position.set(50,50);
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/blue/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/blue/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/blue/3.png"));
        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
//        super.run();
        if(this.position.y < 300) {
            this.position.addThis(0,3);
        }
        fire();
    }

    int count = 0;
    private void fire() {
        if(count >= 20) {

            EnemyBullet enemyBullet = new EnemyBullet();
            enemyBullet.position.set(this.position.x, this.position.y);

            GameCanvas.enemyBullets.add(enemyBullet);
            count = 0;
        } else {
            count++;
        }
    }
}
