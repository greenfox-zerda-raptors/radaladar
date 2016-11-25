/// Created by BB on 2016-11-25.

import javax.swing.*;
import java.awt.*;

public class Card extends JButton {
    private int id;
    private boolean isMatched = false;
    private ImageIcon icon;

    /// Constructor

    public Card(int id) {
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        this.setPreferredSize(new Dimension(150,150));
        this.id = id;
        this.setImageIcon("button.png");
    }

    /// Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public void setImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        ImageIcon icon = new ImageIcon();
        if (imgURL != null) {
            icon = new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
        }
        this.icon = icon;
        this.setIcon(this.icon);
        this.validate();
        this.repaint();
    }
}
