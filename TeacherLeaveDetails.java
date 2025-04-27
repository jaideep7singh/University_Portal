package university.portal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherLeaveDetails extends JFrame implements ActionListener {

    Choice cempID; // Dropdown to hold employee Id
    JTable table; // Table to display teacher data
    JButton search, print, cancel; // Button to differnt fuction to teacher data

    TeacherLeaveDetails() {
        // Set background and layout
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Label for roll number search
        JLabel heading = new JLabel("Search by Employee ID");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        // Dropdown to hold Employee ID
        cempID = new Choice();
        cempID.setBounds(180, 20, 150, 20);
        add(cempID);

        // Create table before using it
        table = new JTable();

        // Scroll pane for table
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        // Connect to DB and populate dropdown + table
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");

            // Load roll numbers into dropdown
            while (rs.next()) {
                cempID.add(rs.getString("empID"));
            }

            // Run query again to populate table
            rs = c.s.executeQuery("select * from teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        cancel = new JButton("Cancel");
        cancel.setBounds(220, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        // Frame properties
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if ((ae.getSource() == search)) {
            String query = "select * from teacherleave where rollno = '" + cempID.getSelectedItem() + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if ((ae.getSource() == print)) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherLeaveDetails();
    }
}
// end{code}
