package courseManagement;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.Icon;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class StudentDashboard extends JPanel {

	/**
	 * Create the panel.
	 */
	public StudentDashboard() {
		setBounds(new Rectangle(0, 0, 1001, 570));
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1001, 570);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(20, 10, 230, 89);
		panel.add(panel_3);
		
		JLabel TotalCourse = new JLabel((Icon) null);
		TotalCourse.setBounds(10, 30, 32, 32);
		panel_3.add(TotalCourse);
		
		JLabel lblNewLabel_5 = new JLabel("0 Total Courses");
		lblNewLabel_5.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		lblNewLabel_5.setBounds(52, 30, 142, 39);
		panel_3.add(lblNewLabel_5);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(320, 10, 230, 89);
		panel.add(panel_3_1);
		
		JLabel TotalTeacher = new JLabel((Icon) null);
		TotalTeacher.setBounds(10, 30, 32, 32);
		panel_3_1.add(TotalTeacher);
		
		JLabel lblNewLabel_5_1 = new JLabel("0 Total Teacher");
		lblNewLabel_5_1.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		lblNewLabel_5_1.setBounds(52, 30, 142, 39);
		panel_3_1.add(lblNewLabel_5_1);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBounds(639, 10, 230, 89);
		panel.add(panel_3_2);
		
		JLabel TotalStudent = new JLabel((Icon) null);
		TotalStudent.setBounds(10, 30, 32, 32);
		panel_3_2.add(TotalStudent);
		
		JLabel lblNewLabel_5_2 = new JLabel(" Total Student");
		lblNewLabel_5_2.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		lblNewLabel_5_2.setBounds(52, 30, 142, 39);
		panel_3_2.add(lblNewLabel_5_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 109, 981, 7);
		panel.add(separator);
		
		JLabel lblNewLabel = new JLabel("My Enrollment\r\n");
		lblNewLabel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 21));
		lblNewLabel.setBounds(406, 133, 150, 39);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 185, 960, 114);
		panel.add(panel_1);

	}
}
