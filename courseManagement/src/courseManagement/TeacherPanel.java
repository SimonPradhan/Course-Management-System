package courseManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import courseManagement.models.course.Module;
import courseManagement.models.user.Admin;
import courseManagement.models.user.SystemUser;
import courseManagement.models.user.Teacher;

public class TeacherPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	JPanel teacher;
	private JTable table;
	JScrollPane scrollPane;
	public TeacherPanel(SystemUser user) {
		setBackground(new Color(255, 255, 255));
		setBounds(new Rectangle(0, 0, 1001, 570));
		setLayout(null);
		
		teacher = new JPanel();
		teacher.setBounds(0, 0, 1001, 570);
		add(teacher);
		teacher.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Teachers Details");
		lblNewLabel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 10, 181, 26);
		teacher.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Teacher");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel(new GridLayout(4, 2));
				JLabel nameLabel = new JLabel("Enter teacher name: ");
				JTextField nameField = new JTextField();
				JLabel emailLabel = new JLabel("Enter teacher email: ");
				JTextField emailField = new JTextField();
				JLabel passwordLabel = new JLabel("Enter teacher password: ");
				JPasswordField passwordField = new JPasswordField();
				JLabel numberLabel = new JLabel("Enter teacher phone number: ");
				JTextField numberField = new JTextField();
				panel.add(emailLabel);
				panel.add(emailField);

				panel.add(nameLabel);
				panel.add(nameField);

				panel.add(passwordLabel);
				panel.add(passwordField);

				panel.add(numberLabel);
				panel.add(numberField);

				int result = JOptionPane.showConfirmDialog(null, panel, "Add Teacher", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					String email = emailField.getText().trim();
					String name = nameField.getText().trim();
					String password = new String(passwordField.getPassword());
					String number = numberField.getText().trim();
					try {
						DataManager.addTeacher(name, number, email, password);
						JOptionPane.showMessageDialog(null, "Teacher added successfully");
						refreshTable(user);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Error adding teacher", e1.getMessage(),
								JOptionPane.ERROR_MESSAGE);
					}
				}}
		});
		btnNewButton.setBounds(497, 46, 133, 40);
		
		
		JButton btnDeleteTeacher = new JButton("Delete Teacher");
		btnDeleteTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel(new GridLayout(1, 2));
				JLabel idLabel = new JLabel("Enter teacher id: ");
				JTextField idField = new JTextField();

				panel.add(idLabel);
				panel.add(idField);

				int result = JOptionPane.showConfirmDialog(null, panel, "Delete Teacher", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					String teacherId = idField.getText();

					try {
						DataManager.deleteTeacher(teacherId);
						JOptionPane.showMessageDialog(null, "Teacher deleted successfully");
						refreshTable(user);

					} catch (SQLException e1) {
						System.out.println(e1.getMessage());
						JOptionPane.showMessageDialog(null, "Error deleting teacher", e1.getMessage(),
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnDeleteTeacher.setBackground(new Color(255, 255, 255));
		btnDeleteTeacher.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		btnDeleteTeacher.setBounds(657, 46, 145, 40);
		
		
		
		if (user instanceof Teacher) {
			JButton btnNewButton_1 = new JButton("Give Marks");
			btnNewButton_1.setBackground(new Color(255, 255, 255));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panel = new JPanel(new GridLayout(5, 2));
					JLabel idLabel = new JLabel("Enter student id: ");
					JTextField idField = new JTextField();
					JLabel moduleLabel = new JLabel("Enter module id: ");
					JTextField moduleField = new JTextField();
					JLabel marksLabel = new JLabel("Enter marks obtained: ");
					JTextField marksField = new JTextField();

					panel.add(idLabel);
					panel.add(idField);

					panel.add(moduleLabel);
					panel.add(moduleField);

					panel.add(marksLabel);
					panel.add(marksField);

					int result = JOptionPane.showConfirmDialog(null, panel, "Mark Student",
							JOptionPane.OK_CANCEL_OPTION);
					if (result == JOptionPane.OK_OPTION) {
						String id = idField.getText().trim();
						String moduleId = moduleField.getText();
						String marks = marksField.getText().trim();
						try {
							DataManager.markStudent(id, moduleId, marks);
							JOptionPane.showMessageDialog(null, "Student marked successfully");

						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "Error marking student", e1.getMessage(),
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
			btnNewButton_1.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
			btnNewButton_1.setBounds(181, 46, 133, 40);
			teacher.add(btnNewButton_1);
			}
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel(new GridLayout(5, 2));
				JLabel idLabel = new JLabel("Enter teacher id: ");
				JTextField idField = new JTextField();
				JLabel nameLabel = new JLabel("Enter teacher name: ");
				JTextField nameField = new JTextField();
				JLabel emailLabel = new JLabel("Enter teacher email: ");
				JTextField emailField = new JTextField();
				JLabel passwordLabel = new JLabel("Enter teacher password: ");
				JPasswordField passwordField = new JPasswordField();
				JLabel numberLabel = new JLabel("Enter teacher phone number: ");
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
						DataManager.editTeacher(id, name, number, email, password);
						JOptionPane.showMessageDialog(null, "Teacher updated successfully");
						refreshTable(user);

					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Error updating teacher", e1.getMessage(),
								JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		btnNewButton_2.setBounds(824, 46, 133, 40);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 94, 981, 2);
		teacher.add(separator);
		
		createTable(user);
		
		if (user instanceof Admin) {
			teacher.add(btnNewButton);
			teacher.add(btnDeleteTeacher);
			teacher.add(btnNewButton_2);
		}
	}

	private void createTable(SystemUser user) {
		ArrayList<Teacher> teachers = DataRetriever.getTeachers();
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 117, 950, 416);
		teacher.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "ID", "Teacher_Name","E-mail", "Phone_No.", "Module"});
		for (Teacher teacher : teachers) {
			System.out.println(teacher.getName());
			model.addRow(new Object[] { teacher.getId(), teacher.getName(),teacher.getEmail(), teacher.getPhone(), teacher.getModules()});
		}
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		
		
		JButton btnNewButton_1_1 = new JButton("Assign");
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel idLabel = new JLabel("Enter teacher id: ");
				JTextField idField = new JTextField();
				JLabel moduleIdLabel = new JLabel("Enter module id: ");
				JTextField moduleIdField = new JTextField();

				JPanel panel = new JPanel(new BorderLayout());
				JPanel inputPanel = new JPanel(new GridLayout(3, 2));

				ButtonGroup group = new ButtonGroup();

				JRadioButton assignRadioButton = new JRadioButton("Assign");
				JRadioButton unassignRadioButton = new JRadioButton("Unassign");

				group.add(assignRadioButton);
				group.add(unassignRadioButton);

				inputPanel.add(assignRadioButton);
				inputPanel.add(unassignRadioButton);

				inputPanel.add(idLabel);
				inputPanel.add(idField);
				inputPanel.add(moduleIdLabel);
				inputPanel.add(moduleIdField);

				String[] columnNames = { "Module ID", "Module Name" };

				// Get the data for the table by calling a method or using a database
				ArrayList<Module> modules = DataRetriever.getAllModules();

				int rowCount = modules.size();
				int columnCount = 2;

				Object[][] data = new Object[rowCount][columnCount];

				for (int i = 0; i < rowCount; i++) {
					data[i][0] = modules.get(i).getId();
					data[i][1] = modules.get(i).getName();
				}

				JTable modulesTable = new JTable(data, columnNames);
				JScrollPane scrollPane = new JScrollPane(modulesTable);

				panel.add(inputPanel, BorderLayout.NORTH);
				panel.add(scrollPane, BorderLayout.CENTER);

				int result = JOptionPane.showConfirmDialog(null, panel, "Assign Teacher", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					if (assignRadioButton.isSelected()) {
						// Assign button is selected
						String teacherId = idField.getText().trim();
						String moduleId = moduleIdField.getText().trim();
						try {
							DataManager.assignModulesToTeacher(teacherId, moduleId);
							JOptionPane.showMessageDialog(null, "Teacher assigned successfully");
							refreshTable(user);
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "Error assigning teacher", e1.getMessage(),
									JOptionPane.ERROR_MESSAGE);
						}
					} else if (unassignRadioButton.isSelected()) {
						// Unassign button is selected
						String teacherId = idField.getText().trim();
						String moduleId = moduleIdField.getText().trim();
						try {
							DataManager.unassignModulesFromTeacher(teacherId, moduleId);
							JOptionPane.showMessageDialog(null, "Teacher unassigned successfully");
							refreshTable(user);
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "Error unassigning teacher", e1.getMessage(),
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(345, 46, 133, 38);
		
		if (user instanceof Admin) {
			teacher.add(btnNewButton_1_1);
		}
	}
	
	private void refreshTable(SystemUser user) {
		teacher.remove(scrollPane);
		createTable(user);
		teacher.revalidate();
		teacher.repaint();
	}
}
