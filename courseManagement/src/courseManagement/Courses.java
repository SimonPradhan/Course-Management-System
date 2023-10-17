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
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import courseManagement.models.course.Course;
import courseManagement.models.user.Admin;
import courseManagement.models.user.SystemUser;

public class Courses extends JPanel {

	JPanel courses;
	JScrollPane scrollPane;
	public Courses(SystemUser user) {
		setLayout(null);
		
		
		courses = new JPanel();
		courses.setBounds(0, 5, 1001, 570);
		add(courses);
		courses.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Course");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel(new GridLayout(2, 2));
				JLabel nameLabel = new JLabel("Enter course name: ");
				JTextField nameField = new JTextField();
				JLabel codeLabel = new JLabel("Enter course code: ");
				JTextField codeField = new JTextField();
				panel.add(codeLabel);
				panel.add(codeField);
				panel.add(nameLabel);
				panel.add(nameField);

				int result = JOptionPane.showConfirmDialog(null, panel, "Add Course", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					String courseName = nameField.getText();
					String courseId = codeField.getText();
					String[] column = { "course_id", "course_name" };
					String[] values = { courseId, courseName };
					try {
						DataManager.insert("courses", column, values);
						JOptionPane.showMessageDialog(null, "Course added successfully");
						refreshTable();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Error adding course", e1.getMessage(),
								JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		btnNewButton.setBounds(459, 46, 144, 40);
		
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel(new GridLayout(2, 2));
				JLabel idLabel = new JLabel("Enter course id: ");
				JTextField idField = new JTextField();

				panel.add(idLabel);
				panel.add(idField);

				int result = JOptionPane.showConfirmDialog(null, panel, "Delete Course", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					String courseId = idField.getText();

					try {
						DataManager.deleteCourse(courseId);
						JOptionPane.showMessageDialog(null, "Course updated successfully");
						refreshTable();

					} catch (SQLException e1) {
						System.out.println(e1.getMessage());
						JOptionPane.showMessageDialog(null, "Error deleting course", e1.getMessage(),
								JOptionPane.ERROR_MESSAGE);
					}}}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		btnNewButton_1.setBounds(812, 46, 144, 40);
		
		
		JButton btnNewButton_2 = new JButton("Delete Course");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel(new GridLayout(2, 2));
				JLabel codeLabel = new JLabel("Enter course code: ");
				JTextField codeField = new JTextField();
				panel.add(codeLabel);
				panel.add(codeField);

				int result = JOptionPane.showConfirmDialog(null, panel, "Delete Course", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					String courseId = codeField.getText();
					String[] column = { "course_id"};
					String[] values = { courseId };
					try {
						DataManager.deleteCourse(courseId);
						JOptionPane.showMessageDialog(null, "Course deleted successfully");
						refreshTable();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Error deleting course", e1.getMessage(),
								JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		btnNewButton_2.setBounds(628, 46, 162, 40);
		
		
		JLabel lblNewLabel = new JLabel("Courses Details");
		lblNewLabel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 10, 162, 43);
		courses.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 103, 981, 2);
		courses.add(separator);
		
		if (user instanceof Admin) {
			courses.add(btnNewButton);
			courses.add(btnNewButton_1);
			courses.add(btnNewButton_2);
		}
		createTable();
	}
	
	private void createTable() {
		ArrayList<Course> coursesList = DataRetriever.getCourses();
		scrollPane = new JScrollPane();
		scrollPane.setVisible(true);
		scrollPane.setBounds(25, 129, 939, 394);
		courses.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "ID", "Course Name"});
		for (Course course : coursesList) {
			System.out.println(course.getName());
			model.addRow(new Object[] { course.getId(), course.getName()});
		}
		JTable table_1 = new JTable(model);
		scrollPane.setViewportView(table_1);
	}
	
	private void refreshTable() {
		courses.remove(scrollPane);
		createTable();
		courses.revalidate();
		courses.repaint();
	}
}
