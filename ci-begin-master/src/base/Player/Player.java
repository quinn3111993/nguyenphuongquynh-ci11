package base.player;

import base.FrameCounter;
import base.game.GameCanvas;
import base.GameObject;
import base.KeyEventPress;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
    FrameCounter fireCounter;
    public Player() {
        super();
        this.createRenderer();
        this.position.set(200, 300);
        this.fireCounter = new FrameCounter(20);
    }

    private void createRenderer() {
        //ArrayList<BufferedImage> images
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/players/straight/0.png",
                "assets/images/players/straight/1.png",
                "assets/images/players/straight/2.png",
                "assets/images/players/straight/3.png",
                "assets/images/players/straight/4.png",
                "assets/images/players/straight/5.png",
                "assets/images/players/straight/6.png"
        );
        //AnimationRenderer(images)
        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        if(KeyEventPress.isUpPress) {
            this.position.addThis(0, -1);
        }
        if(KeyEventPress.isDownPress) {
            this.position.addThis(0, 1);
        }
        if(KeyEventPress.isLeftPress) {
            this.position.addThis(-1, 0);
        }
        if(KeyEventPress.isRightPress) {
            this.position.addThis(1, 0);
        }
        if(KeyEventPress.isFirePress) {
            this.fire();
        }
    }

    private void fire() {
        if(this.fireCounter.run()) {
            PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);
            bullet.position.set(this.position);
            this.fireCounter.reset();

            PlayerBulletRight bullet2 = GameObject.recycle(PlayerBulletRight.class);
            bullet2.position.set(this.position);
            bullet2.position.addThis(20,0);

            PlayerBulletRight bullet3 = GameObject.recycle(PlayerBulletRight.class);
            bullet3.position.set(this.position);
            bullet3.position.addThis(60,0);

            PlayerBulletRight bullet4 = GameObject.recycle(PlayerBulletRight.class);
            bullet4.position.set(this.position);
            bullet4.position.addThis(120,0);

            PlayerBulletLeft bullet5 = GameObject.recycle(PlayerBulletLeft.class);
            bullet5.position.set(this.position);
            bullet5.position.addThis(-20,0);

            PlayerBulletLeft bullet6 = GameObject.recycle(PlayerBulletLeft.class);
            bullet6.position.set(this.position);
            bullet6.position.addThis(-60,0);

            PlayerBulletLeft bullet7 = GameObject.recycle(PlayerBulletLeft.class);
            bullet7.position.set(this.position);
            bullet7.position.addThis(-120,0);

            this.fireCounter.reset();
        }
    }
}
