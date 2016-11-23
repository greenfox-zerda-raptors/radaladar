import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by BB on 2016-11-23.
 */
public class UIControls extends JFrame {

    private JTextField inputField = new JTextField("Enter text here", 20);
    private JButton buttonReset = new JButton("Reset");
    private JLabel labelNow = new JLabel("Text: ");
    private JLabel labelMemory = new JLabel("Memory: ");
    private JPanel panel = new JPanel();

    public UIControls() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(new Dimension(400, 400));
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width/2)-(this.getWidth()/2);
        int yPos = (dim.height/2)-(this.getHeight()/2);
        this.setLocation(xPos, yPos);
        panel.add(Box.createRigidArea(new Dimension(0,20)));
        inputField.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        labelMemory.setText("Memory: " + labelNow.getText());
                        labelNow.setText("Text: " + inputField.getText());
                    }
                }
        );
        panel.add(inputField);
        panel.add(Box.createRigidArea(new Dimension(0,20)));
        panel.add(labelNow);
        panel.add(Box.createRigidArea(new Dimension(0,20)));
        panel.add(labelMemory);
        panel.add(Box.createRigidArea(new Dimension(0,20)));
        buttonReset.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        labelMemory.setText("Memory: ");
                    }
                }
        );
        panel.add(buttonReset);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS) );
        this.add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UIControls();
            }
        });
    }
}
