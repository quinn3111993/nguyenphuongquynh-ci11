package base.player;

import base.GameObject;
import base.game.Settings;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBulletRight extends GameObject {
    public PlayerBulletRight() {
        super();
        this.createRenderer();
    }

//    public PlayerBullet(int x, int y) {
//        super();
//        this.createRenderer();
//        this.position.addThis(x,y);
//    }

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
        this.position.addThis(1, -5);
        if(this.position.y < -20 || this.position.x < 0 || this.position.x > Settings.SCREEN_WIDTH) {
            this.destroy();
        }
    }
}
