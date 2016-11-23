import javax.swing.*;
import java.awt.*;

/**
 * Created by BB on 2016-11-23.
 */
public class ImageApp extends JFrame {

    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();

    public ImageApp() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(new Dimension(900, 600));
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width/2)-(this.getWidth()/2);
        int yPos = (dim.height/2)-(this.getHeight()/2);
        this.setLocation(xPos, yPos);
        ImageIcon icon = createImageIcon("image.jpg", "");
        JLabel label1 = new JLabel("", icon, JLabel.CENTER);
        panel.add(label1);
        this.add(panel);
    }

    private ImageIcon createImageIcon(String path,
                                        String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImageApp();
            }
        });
    }
}
