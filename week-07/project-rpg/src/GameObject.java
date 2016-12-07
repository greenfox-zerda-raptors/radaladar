/// Created by BB on 2016-12-05.

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public abstract class GameObject {
    protected String filename;
    protected int[] position = new int[2];
    protected BufferedImage image;

    public GameObject() {}

    public void setImage() {
        try {
            this.image = ImageIO.read(new File(this.filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics graphics) {
        if (image != null) {
            graphics.drawImage(image, this.position[0]*72, this.position[1]*72, null);
        }
    }
}
