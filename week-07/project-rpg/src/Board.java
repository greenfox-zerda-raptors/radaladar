/// Created by BB on 2016-12-05.

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class Board extends JComponent {
    private Map map = new Map();

    /// Constructor

    public Board() {
        setPreferredSize(new Dimension(720, 720));
        setVisible(true);
        setFocusable(true);
        addKeyListener(new MoveLogic(this, this.map));
    }

    /// Graphics override

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
}
