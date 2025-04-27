package university.portal;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener {
    // Globally declared
    JTextField tfcourse, tfaddress, tfemail, tfphone, tfbranch;
    JLabel labelrollno;
    JButton submit, cancel;
    Choice crollno;

    // contructor that has same name as class
    UpdateStudent() {

        setSize(900, 650);
        setLocation(350, 50);

        setLayout(null);

        // For heading
        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 35));
        add(heading);

        JLabel lblrollnuber = new JLabel("Select Roll Number");
        lblrollnuber.setBounds(50, 100, 200, 35);
        lblrollnuber.setFont(new Font("Serif", Font.PLAIN, 20));
        add(lblrollnuber);

        // Dropdown to hold roll numbers
        crollno = new Choice();
        crollno.setBounds(250, 110, 200, 20);
        add(crollno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // to mark name in frame
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(200, 150, 150, 30);
        labelname.setFont(new Font("Tohama", Font.PLAIN, 18));
        add(labelname);

        JLabel jblfname = new JLabel("Father's Name");
        jblfname.setBounds(400, 150, 200, 30);
        jblfname.setFont(new Font("Serif", Font.BOLD, 20));
        add(jblfname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(600, 150, 150, 30);
        labelfname.setFont(new Font("Tohama", Font.PLAIN, 18));
        add(labelfname);

        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(50, 200, 200, 30);
        lblrollno.setFont(new Font("Serif", Font.BOLD, 18));
        add(lblrollno);

        labelrollno = new JLabel();
        labelrollno.setBounds(200, 200, 200, 30);
        labelrollno.setFont(new Font("Tohama", Font.PLAIN, 20));
        add(labelrollno);

        JLabel jbldob = new JLabel("Date of Birth");
        jbldob.setBounds(400, 200, 200, 30);
        jbldob.setFont(new Font("Serif", Font.BOLD, 20));
        add(jbldob);

        JLabel labeldob = new JLabel();
        labeldob.setBounds(600, 200, 150, 30);
        labeldob.setFont(new Font("Tohama", Font.PLAIN, 18));
        add(labeldob);

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

        JLabel labelX = new JLabel();
        labelX.setBounds(600, 300, 150, 30);
        labelX.setFont(new Font("Tohama", Font.PLAIN, 18));
        add(labelX);

        JLabel lblXII = new JLabel("Class XII (%)");
        lblXII.setBounds(50, 350, 200, 30);
        lblXII.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblXII);

        JLabel labelXII = new JLabel();
        labelXII.setBounds(200, 350, 150, 30);
        labelXII.setFont(new Font("Tohama", Font.PLAIN, 18));
        add(labelXII);

        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(400, 350, 200, 30);
        lblaadhar.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblaadhar);

        JLabel labelaadhar = new JLabel();
        labelaadhar.setBounds(600, 350, 150, 30);
        labelaadhar.setFont(new Font("Tohama", Font.PLAIN, 18));
        add(labelaadhar);

        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblcourse);

        tfcourse = new JTextField();
        tfcourse.setBounds(200, 400, 150, 30);
        tfcourse.setBackground(Color.WHITE);
        add(tfcourse);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblbranch);

        tfbranch = new JTextField();
        tfbranch.setBounds(600, 400, 150, 30);
        tfbranch.setBackground(Color.WHITE);
        add(tfbranch);

        try {
            Conn c = new Conn(); // Conn class is created to connect to the database
            String query = "SELECT * FROM student where rollno= '" + crollno.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelX.setText(rs.getString("class_X"));
                labelXII.setText(rs.getString("class_XII"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelrollno.setText(rs.getString("rollno"));
                tfcourse.setText(rs.getString("course"));
                tfbranch.setText(rs.getString("branch"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn(); // Conn class is created to connect to the database
                    String query = "SELECT * FROM student where rollno= '" + crollno.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);

                    while (rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                        labeldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        labelX.setText(rs.getString("class_X"));
                        labelXII.setText(rs.getString("class_XII"));
                        labelaadhar.setText(rs.getString("aadhar"));
                        labelrollno.setText(rs.getString("rollno"));
                        tfcourse.setText(rs.getString("course"));
                        tfbranch.setText(rs.getString("branch"));

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        submit = new JButton("Update");
        submit.setBounds(250, 500, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 500, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {

            String rollno = labelrollno.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();

            String course = tfcourse.getText();
            String branch = tfbranch.getText();

            try {
                String query = "update student set address =  '" + address + "'  , phone = '" + phone + "', email = '"
                        + email + "', course = '" + course + "', branch =  '" + branch + "'where rollno = '" + rollno
                        + "'";

                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student details updated successfully ");
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
        new UpdateStudent();
    }
}
