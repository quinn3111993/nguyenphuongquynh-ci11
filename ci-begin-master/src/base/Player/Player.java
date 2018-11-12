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
        this.move();
        if(this.fireCounter.run() && KeyEventPress.isFirePress) {
            this.fire();
        }
        super.run();
    }

    private void move() {
        //TODO upgrade
        int vx = 0;
        int vy = 0;

        if(KeyEventPress.isUpPress) {
            vy -= 1;
        }
        if(KeyEventPress.isDownPress) {
            vy += 1;
        }
        if(KeyEventPress.isLeftPress) {
            vx -= 1;
        }
        if(KeyEventPress.isRightPress) {
            vx += 1;
        }
        this.velocity.set(vx,vy);
    }


    private void fire() {
//        if(this.fireCounter.run()) {
//            int numberBullet = 7;
//            int numberBulletLeft = (int)Math.floor(numberBullet/2);
//            float maxAngle = 90;
//            for(int i = -numberBulletLeft; i <= numberBulletLeft; i++) {
//                PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);
//                bullet.position.set(this.position);
//                bullet.setAngle((float)i / numberBulletLeft * maxAngle);
//                bullet.setSpeed(5);
//            }
//            this.fireCounter.reset();
//        }
            PlayerBulletType1 bullet = GameObject.recycle(PlayerBulletType1.class);
            bullet.position.set(this.position);

            PlayerBulletType2 bullet2 = GameObject.recycle(PlayerBulletType2.class);
            bullet2.position.set(this.position.add(-25,0));
            bullet2.velocity.set(-5, -5);

            PlayerBulletType2 bullet3 = GameObject.recycle(PlayerBulletType2.class);
            bullet3.position.set(this.position.add(25, 0));
            bullet3.velocity.set(5,-5);

            this.fireCounter.reset();

        }
    }
