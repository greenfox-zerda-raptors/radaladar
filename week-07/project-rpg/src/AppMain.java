/// Created by BB on 2016-12-05.

import javax.swing.*;
import java.awt.*;

public class AppMain{

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dungeon Crawler - - - - - - - - - - - - - - - - - - - - - - Bálint Biczók, 2016");
        Board board = new Board();
        frame.add(board);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = ((dim.width/2)-(frame.getWidth()/2));
        int yPos = (dim.height/2)-(frame.getHeight()/2);
        frame.setLocation(xPos, yPos);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
