/// Created by BB on 2016-12-05.

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JComponent {

    public Board() {
        setPreferredSize(new Dimension(720, 720));
        setVisible(true);
        setFocusable(true);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    @Override
    public void paint(Graphics graphics) {
        Map map = new Map();
        super.paint(graphics);
        for (Tile tile : map.getTiles()) {
            tile.draw(graphics);
        }
        for (GameObject entity : map.getEntities()) {
            entity.draw(graphics);
        }
    }
}
