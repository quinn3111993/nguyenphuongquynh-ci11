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
        this.velocity.set(0,-5);
    }


    @Override
    public void run() {
//        float x = this.speed * (float)Math.sin(this.angle / 180 * Math.PI);
//        float y = this.speed * -(float)Math.cos(this.angle / 180 * Math.PI);
//        this.position.addThis(x,y);
        super.run();
        this.destroyIfNeeded();
    }

    private void destroyIfNeeded() {
        if(this.position.y < -20 || this.position.y >= Settings.SCREEN_HEIGHT || this.position.x <0 || this.position.x > Settings.BACKGROUND_WIDTH) {
            this.destroy();
        }
    }
}
