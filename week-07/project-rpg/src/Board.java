/// Created by BB on 2016-12-05.

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JComponent {
    private Map map = new Map();

    public Board() {
        setPreferredSize(new Dimension(720, 720));
        setVisible(true);
        setFocusable(true);
        addKeyListener(new MoveLogic());
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        for (Tile tile : map.getTiles()) {
            tile.draw(graphics);
        }
        for (GameObject entity : map.getEntities()) {
            entity.draw(graphics);
        }
    }

    public class MoveLogic implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    map.getHero().faceDirection(1);
                    if (map.getHero().position[1] - 1 >= 0 && map.getMapFloor()[map.getHero().position[1] - 1][map.getHero().position[0]] == 0) {
                        map.getHero().position[1]--;
                    }
                    repaint();
                    break;
                case KeyEvent.VK_RIGHT:
                    map.getHero().faceDirection(2);
                    if (map.getHero().position[0] + 1 <= 9 && map.getMapFloor()[map.getHero().position[1]][map.getHero().position[0] + 1] == 0) {
                        map.getHero().position[0]++;
                    }
                    repaint();
                    break;
                case KeyEvent.VK_DOWN:
                    map.getHero().faceDirection(3);
                    if (map.getHero().position[1] + 1 <= 9 && map.getMapFloor()[map.getHero().position[1] + 1][map.getHero().position[0]] == 0) {
                        map.getHero().position[1]++;
                    }
                    repaint();
                    break;
                case KeyEvent.VK_LEFT:
                    map.getHero().faceDirection(4 );
                    if (map.getHero().position[0] - 1 >= 0 && map.getMapFloor()[map.getHero().position[1]][map.getHero().position[0] - 1] == 0) {
                        map.getHero().position[0]--;
                    }
                    repaint();
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    }
}
