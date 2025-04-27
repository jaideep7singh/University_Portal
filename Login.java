package university.portal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    // Globally declared
    JTextField tfusername;
    JPasswordField tfpassword;
    JButton login, cancel;

    // Constructor
    Login() {
        // Background color
        getContentPane().setBackground(Color.PINK);
        setLayout(null);

        // Username Label
        JLabel lblusername = new JLabel("Username: ");
        lblusername.setBounds(40, 20, 100, 20);
        add(lblusername);

        // Username TextField
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 20);
        add(tfusername);

        // Password Label
        JLabel lblpassword = new JLabel("Password: ");
        lblpassword.setBounds(40, 70, 100, 20);
        add(lblpassword);

        // Password Field
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 20);
        add(tfpassword);

        // Login Button
        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("serif", Font.BOLD, 16));
        login.addActionListener(this); // Fixed: Add ActionListener
        add(login);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 140, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif", Font.BOLD, 16));
        cancel.addActionListener(this); // Fixed: Add ActionListener
        add(cancel);

        // Adding an Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Assets/logo of person.jpg")); // Fixed path issue
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 20, 200, 200);
        add(image);

        // Frame Settings
        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }

    // Modify your Login class to handle the Cancel button
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            // Your login logic here
            String username = tfusername.getText();
            String password = tfpassword.getText();

            String query = "select * from login where username='" + username + "' and password='" + password + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new project();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                }

                c.s.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            System.exit(0); // 🔴 This will exit the entire program

        }

    }

    public static void main(String[] args) {
        new Login();
    }
}
