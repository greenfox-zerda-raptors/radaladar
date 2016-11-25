/// Created by BB on 2016-11-24.

import javax.swing.*;
import java.awt.*;

public class MemoryGameApp {

    public static void main(String[] args) {
        GameBoard b = new GameBoard();
        b.setTitle("Memory Game - Gotta Catch 'Em All!");
        b.setPreferredSize(new Dimension(675, 675));
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = ((dim.width/2)-(b.getWidth()/2));
        int yPos = (dim.height/2)-(b.getHeight()/2);
        b.setLocation(xPos, yPos);
        b.setResizable(false);
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.pack();
        b.setLocationRelativeTo(null);
        b.setVisible(true);
    }
}
