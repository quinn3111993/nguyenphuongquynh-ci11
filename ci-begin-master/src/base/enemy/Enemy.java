package base.enemy;

import base.GameObject;
import base.game.GameCanvas;
import base.game.Settings;
import tklibs.SpriteUtils;

public class Enemy extends GameObject {
    public Enemy() {
        super();
        this.image = SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png");
        this.position.set(200,0);
    }

    @Override
    public void run() {
        fire();
    }

    int count = 0;
    private void fire() {
        if(count > 20) {

            EnemyBullet bullet = new EnemyBullet();
            bullet.position.set(this.position.x, this.position.y);

            GameCanvas.enemyBullets.add(bullet);
            count = 0;
        } else {
            count++;
        }
    }
}
