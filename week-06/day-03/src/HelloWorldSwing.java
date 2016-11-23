/**
 * Created by BB on 2016-11-23.
 */

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class HelloWorldSwing {

    protected JFrame frame = new JFrame("Hello World Application");
    protected JPanel panel = new JPanel();
    protected JLabel label = new JLabel("Hello World!");
    String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour", "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit", "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej", "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};


    public HelloWorldSwing() {

        ArrayList<JLabel> labelList = new ArrayList<>();
        for (String s: hellos) {
            labelList.add(new JLabel(s));
        }
        for (JLabel l : labelList) {
            panel.add(l);
        }
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setVisible(true);
        int xPos = (dim.width/2)-(this.frame.getWidth()/2);
        int yPos = (dim.height/2)-(this.frame.getHeight()/2);
        frame.setLocation(xPos, yPos);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HelloWorldSwing();
            }
        });
    }
}
