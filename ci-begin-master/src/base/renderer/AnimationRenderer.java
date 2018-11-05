package base.renderer;

import base.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimationRenderer extends Renderer {
    ArrayList<BufferedImage> images;
    int currentImageIndex;

    public AnimationRenderer(ArrayList<BufferedImage> images) {
        this.images = images;
        this.currentImageIndex = 0;

    }

    int count = 0;

    @Override
    public void render(Graphics g, GameObject master) {
        g.drawImage(this.images.get(currentImageIndex), (int)master.position.x, (int)master.position.y, null);

        if(count >= 5) {
            this.currentImageIndex++;
            if(currentImageIndex >= this.images.size()) {
                this.currentImageIndex = 0;
            }
        } else {
            count++;
        }



    }
}
