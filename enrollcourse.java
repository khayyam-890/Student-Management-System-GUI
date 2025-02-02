package GUI;

import javax.swing.*;

import GUI.stuentmanagementsystem;

import java.awt.*;

public class enrollcourse extends JFrame {

    public enrollcourse() {
        setTitle("Enroll Student in Course");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        panel.add(new JLabel("Student ID:"));
        JTextField studentIdField = new JTextField();
        panel.add(studentIdField);

        panel.add(new JLabel("Course:"));
        JTextField courseField = new JTextField();
        panel.add(courseField);

        JButton submitButton = new JButton("Enroll");
        submitButton.addActionListener(e -> {
            String studentId = studentIdField.getText().trim();
            String course = courseField.getText().trim();

            if (!stuentmanagementsystem.studentData.containsKey(studentId)) {
                JOptionPane.showMessageDialog(this, "Student ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (course.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Course field must be filled out!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[] data = stuentmanagementsystem.studentData.get(studentId);
            data[2] = course;
            stuentmanagementsystem.studentData.put(studentId, data);
            JOptionPane.showMessageDialog(this, "Student Enrolled in Course Successfully.");
        });

        panel.add(submitButton);
        add(panel);
    }
}
