package GUI;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class stuentmanagementsystem {

    static Map<String, String[]> studentData = new HashMap<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JMenuBar menuBar = new JMenuBar();

        JMenu studentMenu = new JMenu("Student");
        JMenuItem addStudent = new JMenuItem("Add Student");
        JMenuItem updateStudent = new JMenuItem("Update Student");
        JMenuItem viewStudent = new JMenuItem("View Student Details");
        studentMenu.add(addStudent);
        studentMenu.add(updateStudent);
        studentMenu.add(viewStudent);
        menuBar.add(studentMenu);

        JMenu courseMenu = new JMenu("Course");
        JMenuItem enrollCourse = new JMenuItem("Enroll in Course");
        courseMenu.add(enrollCourse);
        menuBar.add(courseMenu);

        JMenu gradeMenu = new JMenu("Grade");
        JMenuItem assignGrade = new JMenuItem("Assign Grade");
        gradeMenu.add(assignGrade);
        menuBar.add(gradeMenu);

        frame.setJMenuBar(menuBar);

        addStudent.addActionListener(e -> new addstudent().setVisible(true));
        updateStudent.addActionListener(e -> new updatestudent().setVisible(true));
        viewStudent.addActionListener(e -> new viewstudentdetails().setVisible(true));
        enrollCourse.addActionListener(e -> new enrollcourse().setVisible(true));
        assignGrade.addActionListener(e -> new assigngrades().setVisible(true));

        frame.setVisible(true);
    }
}
