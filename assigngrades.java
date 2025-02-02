package GUI;

import javax.swing.*;

import GUI.stuentmanagementsystem;

import java.awt.*;

public class assigngrades extends JFrame {

    public assigngrades() {
        setTitle("Assign Grade");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        panel.add(new JLabel("Student ID:"));
        JTextField studentIdField = new JTextField();
        panel.add(studentIdField);

        panel.add(new JLabel("Grade:"));
        JTextField gradeField = new JTextField();
        panel.add(gradeField);

        JButton submitButton = new JButton("Assign");
        submitButton.addActionListener(e -> {
            String studentId = studentIdField.getText().trim();
            String grade = gradeField.getText().trim();

            if (!stuentmanagementsystem.studentData.containsKey(studentId)) {
                JOptionPane.showMessageDialog(this, "Student ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (grade.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Grade field must be filled out!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[] data = stuentmanagementsystem.studentData.get(studentId);
            data[3] = grade;
            stuentmanagementsystem.studentData.put(studentId, data);
            JOptionPane.showMessageDialog(this, "Grade Assigned Successfully.");
        });

        panel.add(submitButton);
        add(panel);
    }
}
