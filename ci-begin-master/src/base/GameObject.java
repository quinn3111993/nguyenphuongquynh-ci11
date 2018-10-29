package base;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
    BufferedImage image;
    int x;
    int y;

    public GameObject() {

    }

    //logic
    public void run() {
//        if(this.x < 300) {
//            this.x++;
//        }
    }

    //display
    public void render(Graphics g) {
       g.drawImage(this.image, this.x, this.y,null);
    }
}