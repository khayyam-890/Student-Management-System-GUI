package GUI;

import javax.swing.*;

import GUI.stuentmanagementsystem;

import java.awt.*;

public class addstudent extends JFrame {

    private JTextField nameTextField, idTextField, ageTextField;

    public addstudent() {
        setTitle("Add Student");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        panel.add(new JLabel("Name:"));
        nameTextField = new JTextField(15);
        panel.add(nameTextField);

        panel.add(new JLabel("Student ID:"));
        idTextField = new JTextField(15);
        panel.add(idTextField);

        panel.add(new JLabel("Age:"));
        ageTextField = new JTextField(15);
        panel.add(ageTextField);

        JButton submitButton = new JButton("Submit");
        panel.add(new JLabel()); // Empty space
        panel.add(submitButton);

        add(panel);

        submitButton.addActionListener(e -> {
            String name = nameTextField.getText().trim();
            String studentId = idTextField.getText().trim();
            String age = ageTextField.getText().trim();

            if (name.isEmpty() || studentId.isEmpty() || age.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (stuentmanagementsystem.studentData.containsKey(studentId)) {
                JOptionPane.showMessageDialog(this, "Student ID already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                Integer.parseInt(age);  // Check if age is a number
                GUI.stuentmanagementsystem.studentData.put(studentId, new String[]{name, age, "", ""});  // name, age, course, grade
                JOptionPane.showMessageDialog(this, "Student Added Successfully.");
                nameTextField.setText("");
                idTextField.setText("");
                ageTextField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Age must be a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
