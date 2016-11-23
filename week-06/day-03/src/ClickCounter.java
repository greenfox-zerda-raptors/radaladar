/**
 * Created by BB on 2016-11-23.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickCounter {

    private JButton buttonCounter = new JButton("Click me!");
    private JButton buttonReset = new JButton("Reset");
    private JLabel labelCount = new JLabel();
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("Click Counter");
    private int clicks = 0;

    public ClickCounter(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setResizable(false);
        frame.setVisible(true);
        int xPos = (dim.width/2)-(this.frame.getWidth()/2);
        int yPos = (dim.height/2)-(this.frame.getHeight()/2);
        frame.setLocation(xPos, yPos);
        panel.add(labelCount);
        updateCounter();
        buttonCounter.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clicks++;
                        updateCounter();
                    }
                });
        panel.add(buttonCounter);
        buttonReset.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clicks = 0;
                        updateCounter();
                    }
                }
        );
        panel.add(buttonReset);
        frame.add(panel);
    }

    private void updateCounter() {
        labelCount.setText("Clicked " + clicks +" times");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClickCounter();
            }
        });
    }
}
