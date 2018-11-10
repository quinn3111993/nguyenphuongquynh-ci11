package base.player;

import base.GameObject;
import base.game.Settings;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject {
    float angle = 0;
    float speed = 5;

    public PlayerBullet() {
        super();
        this.createRenderer();
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
            "assets/images/player-bullets/a/0.png",
                "assets/images/player-bullets/a/1.png",
                "assets/images/player-bullets/a/2.png",
                "assets/images/player-bullets/a/3.png"
        );
        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        float x = this.speed * (float)Math.sin(this.angle / 180 * Math.PI);
        float y = this.speed * -(float)Math.cos(this.angle / 180 * Math.PI);
        this.position.addThis(x,y);

//        this.position.addThis(0, -5);
        if(this.position.y < -20 || this.position.x < 0 || this.position.x > Settings.SCREEN_WIDTH) {
            this.destroy();
        }
    }
}
