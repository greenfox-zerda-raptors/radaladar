/// Created by BB on 2016-12-05.

import javax.swing.*;
import java.awt.*;

public class AppMain{

    public static void main(String[] args) {
        int level = 1;
        Hero hero = new Hero();
        JFrame frame = new JFrame("╰༼.◕ヮ◕.༽つ¤=[]———— Dungeon Crawler ———— []=¤ԅ༼ ☯ 〜 ☯ ༽╯ - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  Bálint Biczók, 2016");
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        JPanel infoPanel = new JPanel();
        infoPanel.setPreferredSize(new Dimension(200, 720));
        JLabel label = new JLabel();
        infoPanel.add(label);
        infoPanel.setVisible(true);
        Board board = new Board(panel, label, level, hero);
        panel.add(infoPanel);
        panel.add(board);
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
