package courseManagement;

import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import courseManagement.models.course.Course;
import courseManagement.models.user.SystemUser;
import courseManagement.models.user.Teacher;

public class Dashboard extends JPanel {

	/**
	 * Create the panel.
	 */
	JPanel dashboard;
	private JTable table;
	public Dashboard(ArrayList<Course> courses, ArrayList<Teacher> teachers, SystemUser user) {
		setBounds(new Rectangle(0, 0, 1001, 570));
		setLayout(null);
		
		dashboard = new JPanel();
		dashboard.setBounds(0, 0, 1001, 570);
		add(dashboard);
		dashboard.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(26, 21, 230, 89);
		panel_3.setLayout(null);
		dashboard.add(panel_3);
		
		JLabel TotalCourse = new JLabel(new ImageIcon(getClass().getResource("/book1.png")));
		TotalCourse.setBounds(10, 30, 32, 32);
		panel_3.add(TotalCourse);
		
		
		JLabel lblNewLabel_5 = new JLabel(courses.size() + " Total Courses");
		lblNewLabel_5.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		lblNewLabel_5.setBounds(52, 30, 142, 39);
		panel_3.add(lblNewLabel_5);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(309, 21, 230, 89);
		panel_3_1.setLayout(null);
		dashboard.add(panel_3_1);
		
		JLabel TotalTeacher = new JLabel(new ImageIcon(getClass().getResource("/teacher.png")));
		TotalTeacher.setBounds(10, 30, 32, 32);
		panel_3_1.add(TotalTeacher);
		
		
		JLabel lblNewLabel_5_1 = new JLabel(teachers.size() + " Total Teacher");
		lblNewLabel_5_1.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		lblNewLabel_5_1.setBounds(52, 30, 142, 39);
		panel_3_1.add(lblNewLabel_5_1);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBounds(602, 21, 230, 89);
		panel_3_2.setLayout(null);
		dashboard.add(panel_3_2);
		
		JLabel TotalStudent = new JLabel(new ImageIcon(getClass().getResource("/student.png")));
		TotalStudent.setBounds(10, 30, 32, 32);
		panel_3_2.add(TotalStudent);
		
		JLabel lblNewLabel_5_2 = new JLabel(" Total Student");
		lblNewLabel_5_2.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		lblNewLabel_5_2.setBounds(52, 30, 142, 39);
		panel_3_2.add(lblNewLabel_5_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 120, 981, 20);
		dashboard.add(separator);
		
		JLabel hi = new JLabel(new ImageIcon(getClass().getResource("/hi (1).png")));
		hi.setBounds(0, 181, 245, 324);
		dashboard.add(hi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(255, 150, 574, 372);
		dashboard.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "ID", "Course Name"});
		for (Course course : courses) {
			System.out.println(course.getName());
			model.addRow(new Object[] { course.getId(), course.getName()});
		}
		
		table = new JTable(model);
		table.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		table.setBorder(null);
		scrollPane.setViewportView(table);
		

	}
}
