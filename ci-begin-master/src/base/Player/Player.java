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
            int numberBullet = 7;
            int numberBulletLeft = (int)Math.floor(numberBullet/2);
            float maxAngle = 90;
            for(int i = -numberBulletLeft; i <= numberBulletLeft; i++) {
                PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);
                bullet.position.set(this.position);
                bullet.setAngle((float)i / numberBulletLeft * maxAngle);
                bullet.setSpeed(5);
            }


            this.fireCounter.reset();
        }
    }
}
