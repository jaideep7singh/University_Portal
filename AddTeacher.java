package university.portal;

import javax.swing.*;
import java.awt.*;
import java.util.*; // for random class
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.PreparedStatement;

public class AddTeacher extends JFrame implements ActionListener {
    // Globally declared
    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfX, tfXII, tfaadhar;
    JLabel labelempId;
    JDateChooser dcdob;
    JComboBox cbqualifiaction, cbdepartment; // For Dropdown
    JButton submit, cancel;

    // random is a class which take random roll no. according to the number of
    // students
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000 + 1000L));

    // contructor that has same name as class
    AddTeacher() {

        setSize(900, 700);
        setLocation(350, 50);

        setLayout(null);

        // For heading
        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        add(heading);

        // to mark name in frame
        JLabel jblname = new JLabel("Name");
        jblname.setBounds(50, 150, 100, 30);
        jblname.setFont(new Font("Serif", Font.BOLD, 20));
        add(jblname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);

        JLabel jblfname = new JLabel("Father's Name");
        jblfname.setBounds(400, 150, 200, 30);
        jblfname.setFont(new Font("Serif", Font.BOLD, 20));
        add(jblfname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);

        JLabel lblempId = new JLabel("Employee ID");
        lblempId.setBounds(50, 200, 200, 30);
        lblempId.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblempId);

        labelempId = new JLabel("101" + first4);
        labelempId.setBounds(200, 200, 200, 30);
        labelempId.setFont(new Font("Serif", Font.BOLD, 20));
        add(labelempId);

        JLabel jbldob = new JLabel("Date of Birth");
        jbldob.setBounds(400, 200, 200, 30);
        jbldob.setFont(new Font("Serif", Font.BOLD, 20));
        add(jbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(600, 200, 150, 30);
        add(dcdob);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("Serif", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 200, 30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        JLabel lblX = new JLabel("Class X (%)");
        lblX.setBounds(400, 300, 200, 30);
        lblX.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblX);

        tfX = new JTextField();
        tfX.setBounds(600, 300, 150, 30);
        add(tfX);

        JLabel lblXII = new JLabel("Class XII (%)");
        lblXII.setBounds(50, 350, 200, 30);
        lblXII.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblXII);

        tfXII = new JTextField();
        tfXII.setBounds(200, 350, 150, 30);
        add(tfXII);

        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(400, 350, 200, 30);
        lblaadhar.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        add(tfaadhar);

        JLabel lblcourse = new JLabel("Qualification");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblcourse);

        String course[] = { "B.Tech", "M.Tech", "BBA", "MBA", "Bsc", "Msc", "Mcom", "BA", "MA" };
        cbqualifiaction = new JComboBox<String>(course);
        cbqualifiaction.setBounds(200, 400, 150, 30);
        cbqualifiaction.setBackground(Color.WHITE);
        add(cbqualifiaction);

        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblbranch);

        String branch[] = { "Computer Science", "Electrical", "Mechanical", "Civil", "Chemical" };
        cbdepartment = new JComboBox<String>(branch);
        cbdepartment.setBounds(600, 400, 150, 30);
        cbdepartment.setBackground(Color.WHITE);
        add(cbdepartment);

        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = labelempId.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String X = tfX.getText();
            String XII = tfXII.getText();
            String aadhar = tfaadhar.getText();

            String qualifiaction = (String) cbqualifiaction.getSelectedItem();
            String department = (String) cbdepartment.getSelectedItem();

            try {
                String query = "insert into teacher values ('" + name + "','" + fname + "','" + rollno + "','" + dob
                        + "','" + aadhar + "', '" + address + "' ,  '" + phone + "','" + email + "','" + X + "','" + XII
                        + "','" + qualifiaction
                        + "','" + department + "')";

                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Teacher details inserted successfully ");
                setVisible(false);
            } catch (Exception e) {

                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        // object of a class
        new AddTeacher();
    }
}
