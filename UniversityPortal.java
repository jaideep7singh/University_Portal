package university.portal;

import javax.swing.*;
import java.awt.*;

public class UniversityPortal extends JFrame implements Runnable {

    Thread t;

    UniversityPortal() {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Assets/Front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        t = new Thread(this);
        t.start();

        setVisible(true);

        int x = 1;
        for (int i = 4; i <= 350; i += 4, x += 1) {
            setLocation(700 - ((i + x) / 2), 400 - (i / 2));
            setSize(i + 3 * x, i + x / 2);
        }
        try {
            Thread.sleep(10);
        } catch (Exception e) {
        }
    }

    public void run() {
        try {
            Thread.sleep(4000);
            setVisible(false);
            // next Frame
            new Login();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {

        new UniversityPortal();
        System.out.println("Welcome to the University Portal!");
    }
}
