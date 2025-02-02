package GUI;

import javax.swing.*;

public class viewstudentdetails extends JFrame {

    public viewstudentdetails() {
        setTitle("View Student Details");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextField studentIdField = new JTextField();

        Object[] message = {
            "Student ID:", studentIdField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "View Student Details", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String studentId = studentIdField.getText().trim();

            if (!stuentmanagementsystem.studentData.containsKey(studentId)) {
                JOptionPane.showMessageDialog(null, "Student ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[] data = stuentmanagementsystem.studentData.get(studentId);
            String studentDetails = "Name: " + data[0] + "\n" +
                                    "Age: " + data[1] + "\n" +
                                    "Course: " + (data[2].isEmpty() ? "Not Enrolled" : data[2]) + "\n" +
                                    "Grade: " + (data[3].isEmpty() ? "No Grade Assigned" : data[3]);

            JOptionPane.showMessageDialog(null, studentDetails, "Student Details", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
