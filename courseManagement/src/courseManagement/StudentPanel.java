package courseManagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import courseManagement.models.user.Admin;
import courseManagement.models.user.Student;
import courseManagement.models.user.SystemUser;

public class StudentPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	JPanel student;
	JScrollPane scrollPane_1;
	public StudentPanel(SystemUser user) {
		setLayout(null);
		
		student = new JPanel();
		student.setBounds(0, 0, 1001, 570);
		add(student);
		student.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel(new GridLayout(6, 2));
				JLabel nameLabel = new JLabel("Enter student name: ");
				JTextField nameField = new JTextField();
				JLabel emailLabel = new JLabel("Enter student email: ");
				JTextField emailField = new JTextField();
				JLabel passwordLabel = new JLabel("Enter student password: ");
				JPasswordField passwordField = new JPasswordField();
				JLabel numberLabel = new JLabel("Enter student phone number: ");
				JTextField numberField = new JTextField();
				JLabel courseLabel = new JLabel("Enter course id: ");
				JTextField courseField = new JTextField();
				JLabel levelLabel = new JLabel("Enter student level: ");
				JTextField levelField = new JTextField();
				panel.add(emailLabel);
				panel.add(emailField);

				panel.add(nameLabel);
				panel.add(nameField);

				panel.add(passwordLabel);
				panel.add(passwordField);

				panel.add(numberLabel);
				panel.add(numberField);

				panel.add(courseLabel);
				panel.add(courseField);

				panel.add(levelLabel);
				panel.add(levelField);

				int result = JOptionPane.showConfirmDialog(null, panel, "Add Student", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					String email = emailField.getText().trim();
					String name = nameField.getText().trim();
					String password = new String(passwordField.getPassword());
					String number = numberField.getText().trim();
					String courseId = courseField.getText().trim();
					String level = levelField.getText().trim();
					try {
						DataManager.addStudent(name, number, email, password, Integer.parseInt(courseId),
								Integer.parseInt(level));
						JOptionPane.showMessageDialog(null, "Student added successfully");
						refreshTable();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Error adding student", e1.getMessage(),
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		btnNewButton.setBounds(439, 47, 149, 40);
		
		
		JButton btnNewButton_1 = new JButton("Delete Student");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel(new GridLayout(1, 2));
				JLabel idLabel = new JLabel("Enter student id: ");
				JTextField idField = new JTextField();

				panel.add(idLabel);
				panel.add(idField);

				int result = JOptionPane.showConfirmDialog(null, panel, "Delete Student", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					String studentId = idField.getText();

					try {
						DataManager.deleteStudent(studentId);
						JOptionPane.showMessageDialog(null, "Student deleted successfully");
						refreshTable();

					} catch (SQLException e1) {
						System.out.println(e1.getMessage());
						JOptionPane.showMessageDialog(null, "Error deleting student", e1.getMessage(),
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		btnNewButton_1.setBounds(619, 47, 166, 40);
		
		
		JButton btnNewButton_2 = new JButton("Update ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel(new GridLayout(5, 2));
				JLabel idLabel = new JLabel("Enter student id: ");
				JTextField idField = new JTextField();
				JLabel nameLabel = new JLabel("Enter student name: ");
				JTextField nameField = new JTextField();
				JLabel emailLabel = new JLabel("Enter student email: ");
				JTextField emailField = new JTextField();
				JLabel passwordLabel = new JLabel("Enter student password: ");
				JPasswordField passwordField = new JPasswordField();
				JLabel numberLabel = new JLabel("Enter student phone number: ");
				JTextField numberField = new JTextField();

				panel.add(idLabel);
				panel.add(idField);

				panel.add(emailLabel);
				panel.add(emailField);

				panel.add(nameLabel);
				panel.add(nameField);

				panel.add(passwordLabel);
				panel.add(passwordField);

				panel.add(numberLabel);
				panel.add(numberField);

				int result = JOptionPane.showConfirmDialog(null, panel, "Update Teacher", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					String id = idField.getText().trim();
					String email = emailField.getText().trim();
					String name = nameField.getText().trim();
					String password = new String(passwordField.getPassword());
					String number = numberField.getText().trim();
					try {
						DataManager.editStudent(id, name, number, email, password);
						JOptionPane.showMessageDialog(null, "Student updated successfully");
						refreshTable();

					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Error updating student", e1.getMessage(),
								JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		btnNewButton_2.setBounds(808, 47, 144, 40);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 102, 966, 12);
		student.add(separator);
		
		JLabel lblNewLabel = new JLabel("Student Details");
		lblNewLabel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 10, 166, 45);
		student.add(lblNewLabel);
		
		if (user instanceof Admin) {
			student.add(btnNewButton);
			student.add(btnNewButton_1);
			student.add(btnNewButton_2);
		}
		
		if (user instanceof Student) {
		Student studentUser = (Student) user;
		JButton btnNewButton_3 = new JButton("Show marks");
		btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println(studentUser.getId());
					JPanel panel = new JPanel(new GridLayout(1, 2));
					JLabel idLabel = new JLabel("Enter module id: ");
					JTextField idField = new JTextField();

					JLabel marksLabel = new JLabel("");

					panel.add(idLabel);
					panel.add(idField);

					panel.add(marksLabel);

					int result = JOptionPane.showConfirmDialog(null, panel, "View Results",
							JOptionPane.OK_CANCEL_OPTION);
					if (result == JOptionPane.OK_OPTION) {
						String moduleId = idField.getText();

						try {
							int marks = DataManager.retrieveMarks(studentUser.getId(), moduleId);
							String res = "You have scored " + marks + " marks in "
									+ DataRetriever.getModuleById(Integer.parseInt(moduleId)).getName();
							JOptionPane.showMessageDialog(null, res, "Your Result", JOptionPane.INFORMATION_MESSAGE);

						} catch (SQLException e1) {
							System.out.println(e1.getMessage());
							JOptionPane.showMessageDialog(null, "Results not available for the module",
									e1.getMessage(),
									JOptionPane.ERROR_MESSAGE);
						}
					}
			}
		});
		btnNewButton_3.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBounds(284, 47, 121, 40);
		student.add(btnNewButton_3);
		}
		createTable();
		
	}
	private void createTable() {
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVisible(true);
		scrollPane_1.setBounds(25, 129, 939, 394);
		student.add(scrollPane_1);
		
		ArrayList<Student> studentData = DataRetriever.getStudents();

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "ID", "Name", "Phone Number", "Email Address", "Course Enrolled" });
		for (Student student : studentData) {
			model.addRow(
					new Object[] { student.getId(), student.getName(), student.getPhone(), student.getEmail(),
							student.getEnrolledCourse() });
		}
		JTable table_1 = new JTable(model);
		table_1.setEnabled(false);
		scrollPane_1.setViewportView(table_1);
		
		
	}
	
	private void refreshTable() {
		student.remove(scrollPane_1);
		createTable();
		student.revalidate();
		student.repaint();
	}
}
