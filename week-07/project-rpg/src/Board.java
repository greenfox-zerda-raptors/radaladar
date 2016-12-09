/// Created by BB on 2016-12-05.

import javax.swing.*;
import java.awt.*;

public class Board extends JComponent {
    private Map mapGraphics;

    /// Constructor

    public Board(JPanel panel, JLabel label, int level, Hero hero) {
        setPreferredSize(new Dimension(720, 720));
        setVisible(true);
        setFocusable(true);
        Map map = new Map(level, hero);
        mapGraphics = map;
        addKeyListener(new GameLogic(this, map, panel, label, level, hero));
        SoundPlayer.loopStop();
        if (level == 1) {
            SoundPlayer.playFX(SoundPlayer.openingTheme);
        } else {
            SoundPlayer.playFX(SoundPlayer.nextLevel);
        }
        SoundPlayer.playBackGround(SoundPlayer.dungeonTheme);
    }

    /// Graphics override

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        for (Tile tile : mapGraphics.getTiles()) {
            tile.draw(graphics);
        }
        for (GameObject entity : mapGraphics.getEntities()) {
            entity.draw(graphics);
        }
    }

}
