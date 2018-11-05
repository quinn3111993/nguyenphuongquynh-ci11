package base.player;

import base.game.GameCanvas;
import base.GameObject;
import base.KeyEventPress;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {

    public Player() {
        super();
//        BufferedImage image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
//        this.renderer = new SingleImageRenderer(image);
        this.createRenderer();
        this.position.set(200, 300);
    }

    private void createRenderer() {
        //ArrayList<BufferedImage> images
        ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
        images.add(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/4.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/5.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/6.png"));
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
        this.count++;
    }

    int count = 20;

    private void fire() {
        if(count > 20) {
            PlayerBullet bullet = new PlayerBullet();
            bullet.position.set(this.position.x, this.position.y);

            GameCanvas.bullets.add(bullet);
            this.count = 0;
        }
//        else {
//            this.count++;
//        }
    }
}
