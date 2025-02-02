package GUI;

import javax.swing.*;

import GUI.stuentmanagementsystem;

import java.awt.*;

public class updatestudent extends JFrame {

    private JTextField studentIdField, nameField, ageField;

    public updatestudent() {
        setTitle("Update Student");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        panel.add(new JLabel("Student ID:"));
        studentIdField = new JTextField();
        panel.add(studentIdField);

        panel.add(new JLabel("New Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("New Age:"));
        ageField = new JTextField();
        panel.add(ageField);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(e -> {
            String studentId = studentIdField.getText().trim();
            String name = nameField.getText().trim();
            String age = ageField.getText().trim();

            if (!stuentmanagementsystem.studentData.containsKey(studentId)) {
                JOptionPane.showMessageDialog(this, "Student ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[] data = stuentmanagementsystem.studentData.get(studentId);
            if (!name.isEmpty()) data[0] = name;
            if (!age.isEmpty()) {
                try {
                    Integer.parseInt(age);  // Check if age is a number
                    data[1] = age;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Age must be a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            stuentmanagementsystem.studentData.put(studentId, data);
            JOptionPane.showMessageDialog(this, "Student Updated Successfully.");
        });

        panel.add(updateButton);
        add(panel);
    }
}
