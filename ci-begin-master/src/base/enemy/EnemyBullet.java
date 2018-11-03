package base.enemy;

import base.GameObject;
import tklibs.SpriteUtils;

public class EnemyBullet extends GameObject {
    public EnemyBullet() {
        super();
        this.image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
    }

    @Override
    public void run() {
        this.position.addThis(0,1);
    }
}
