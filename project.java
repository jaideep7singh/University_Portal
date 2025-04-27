package university.portal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Main class extending JFrame and implementing ActionListener for menu actions
public class project extends JFrame implements ActionListener {

    // Constructor to initialize the GUI
    project() {
        // Set window size
        setSize(1540, 850);

        // Center the window on screen
        setLocationRelativeTo(null);

        // Exit application when window is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Set the title of the window
        setTitle("University Portal");

        // ----- Background Image Setup -----
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Assets/Front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        // ----- Menu Bar -----
        JMenuBar mb = new JMenuBar();

        // ----- View Information Menu -----
        JMenu viewInfo = new JMenu("New Information");
        viewInfo.setForeground(Color.BLUE);
        mb.add(viewInfo);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.addActionListener(this);
        viewInfo.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.addActionListener(this);
        viewInfo.add(studentInfo);

        // ----- View Details Menu -----
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.RED);
        mb.add(details);

        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);

        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.addActionListener(this);
        details.add(studentDetails);

        // ----- Apply Leave Menu -----
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);

        JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);

        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        // ----- Leave Details Menu -----
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.RED);
        mb.add(leaveDetails);

        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);

        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);

        // ----- Exam Details Menu -----
        JMenu exam = new JMenu("Exam Details");
        exam.setForeground(Color.BLUE);
        mb.add(exam);

        JMenuItem examinationdetails = new JMenuItem("Examination Results");
        examinationdetails.addActionListener(this);
        exam.add(examinationdetails);

        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        enterMarks.addActionListener(this);
        exam.add(enterMarks);

        // ----- Update Details Menu -----
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.RED);
        mb.add(updateInfo);

        JMenuItem updateFaculty = new JMenuItem("Update Faculty Details");
        updateFaculty.addActionListener(this);
        updateInfo.add(updateFaculty);

        JMenuItem updateStudent = new JMenuItem("Update Student Details");
        updateStudent.addActionListener(this);
        updateInfo.add(updateStudent);

        // ----- Fee Details Menu -----
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.GREEN);
        mb.add(fee);

        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.addActionListener(this);
        fee.add(feeStructure);

        JMenuItem feeForm = new JMenuItem("Student Fee Form");
        feeForm.addActionListener(this);
        fee.add(feeForm);

        // ----- Utility Menu (external applications) -----
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.ORANGE);
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.addActionListener(this);
        utility.add(calculator);

        // About
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLACK);
        mb.add(about);

        JMenuItem ab = new JMenuItem("About");
        ab.addActionListener(this);
        about.add(ab);

        // ----- Exit Menu -----
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.RED);
        mb.add(exit);

        JMenuItem ex = new JMenuItem("Exit");
        ex.addActionListener(this);
        exit.add(ex);

        // Add the menu bar to the frame
        setJMenuBar(mb);

        // Make the frame visible
        setVisible(true);
    }

    // Handle actions performed when a menu item is clicked
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        switch (msg) {
            case "Exit":
                setVisible(false);
                break;

            case "Calculator":
                try {
                    Runtime.getRuntime().exec("calc.exe");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case "Notepad":
                try {
                    Runtime.getRuntime().exec("notepad.exe");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case "View Student Information":
                new AddStudent();
                break;

            case "View Faculty Information":
                new AddTeacher();
                break;

            case "View Student Details":
                new StudentDetails();
                break;

            case "View Faculty Details":
                new TeacherDetails();
                break;

            case "New Faculty Information":
                new AddTeacher();
                break;

            case "New Student Information":
                new AddStudent();
                break;

            case "Student Leave":
                new StudentLeave();
                break;

            case "Faculty Leave":
                new TeacherLeave();
                break;

            case "Student Leave Details":
                new StudentLeaveDetails();
                break;

            case "Faculty Leave Details":
                new TeacherLeaveDetails();
                break;

            case "Update Faculty Details":
                new UpdateTeacher();
                break;

            case "Update Student Details":
                new UpdateStudent();
                break;

            case "Enter Marks":
                new Entermarks();
                break;

            case "Examination Results":
                new ExaminationDetails();
                break;
            case "Fee Structure":
                new FeeStructure();
                break;
            case "About":
                new About();
                break;
            case "Student Fee Form":
                new StudentFeeForm();
                break;

            default:
                JOptionPane.showMessageDialog(this, "Action for '" + msg + "' not yet implemented.");
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        new project();
    }
}
// end{code}