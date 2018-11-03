package base.game;

import base.Background;
import base.GameObject;
import base.enemy.Enemy;
import base.enemy.EnemyBullet;
import base.player.Player;
import base.player.PlayerBullet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
    public GameObject background;
    public GameObject player;
    public static ArrayList<PlayerBullet> bullets = new ArrayList<>();
    public static ArrayList<Enemy> enemies = new ArrayList<>();
    public static ArrayList<EnemyBullet> enemyBullets = new ArrayList<>();


    public GameCanvas() {
        //super
        this.background = new Background();
        this.player = new Player();
        GameCanvas.bullets = new ArrayList<>();
        GameCanvas.enemies = new ArrayList<>();
        GameCanvas.enemyBullets = new ArrayList<>();
        Enemy enemy = new Enemy();
        GameCanvas.enemies.add(enemy);
    }

    public void gameLoop() {
        int delay = 1000 / 60;
        long lastRun = 0;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastRun > delay) {
                this.runAll();
                this.renderAll();
                lastRun = currentTime;
            }
        }
    }

    public void runAll() {
        this.background.run();
        this.player.run();
        for(PlayerBullet bullet : bullets) {
            bullet.run();
        }
        for(Enemy enemy : enemies) {
            enemy.run();
        }
        for(EnemyBullet enemyBullet : enemyBullets) {
            enemyBullet.run();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.background.render(g);
        this.player.render(g);
        for(PlayerBullet bullet : bullets) {
            bullet.render(g);
        }
        for(Enemy enemy : enemies) {
            enemy.render(g);
        }
        for(EnemyBullet enemyBullet : enemyBullets) {
            enemyBullet.render(g);
        }
    }

    public void renderAll() {
        this.repaint();
    }
}
