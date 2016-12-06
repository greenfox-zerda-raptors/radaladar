/// Created by BB on 2016-12-05.

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Random;

public class Board extends JComponent {

    public Board() {
        setPreferredSize(new Dimension(720, 720));
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        Map map = new Map();
        super.paint(graphics);
        for (int i = 0; i <10; i++) {
            for (int j = 0; j < 10; j++){
                PositionedImage image = new PositionedImage(map.getTile(i, j).getImage(), j*72, i*72);
            image.draw(graphics);
            }
        }
    }
}
