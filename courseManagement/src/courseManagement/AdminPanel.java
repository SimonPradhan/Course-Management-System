package courseManagement;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import courseManagement.models.course.Course;
import courseManagement.models.user.SystemUser;
import courseManagement.models.user.Teacher;

public class AdminPanel {

	private JFrame frame;

	public AdminPanel(SystemUser user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(SystemUser user) {
		ArrayList<Course> courses = DataRetriever.getCourses();
		ArrayList<Teacher> teachers = DataRetriever.getTeachers();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(211, 208, 203));
		frame.setBounds(100, 100, 1224, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(120, 196, 68));
		panel.setBounds(0, 0, 1210, 92);
		frame.getContentPane().add(panel);
	
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(199, 102, 1011, 570);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		frame.setVisible(true);
		panel_2.add(new Dashboard(courses, teachers , user).dashboard);
		
		
		JLabel lblNewLabel = new JLabel("Welcome back 👋 " + user.getName());
		lblNewLabel.setBackground(new Color(0, 185, 47));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(30, 10, 522, 57);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 22));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 102, 189, 567);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel tutorButton = new JPanel();
		tutorButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.removeAll();
				panel_2.add(new TeacherPanel(user).teacher);
				panel_2.repaint();
				panel_2.revalidate();
			}
		});
		tutorButton.setBackground(new Color(255, 255, 255));
		tutorButton.setBounds(24, 164, 155, 52);
		panel_1.add(tutorButton);
		tutorButton.setLayout(null);
		
		JLabel tutor = new JLabel(new ImageIcon(getClass().getResource("/teacher.png")));
		tutor.setBounds(10, 10, 32, 32);
		tutorButton.add(tutor);
		
		JLabel lblNewLabel_1 = new JLabel("Teacher");
		lblNewLabel_1.setFont(new Font("Corbel", Font.BOLD, 19));
		lblNewLabel_1.setBounds(52, 10, 81, 32);
		tutorButton.add(lblNewLabel_1);
		
		JPanel Dashboard = new JPanel();
		Dashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.removeAll();
				panel_2.add(new Dashboard(courses,teachers, user).dashboard);
				panel_2.repaint();
				panel_2.revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Dashboard.setBackground(Color.LIGHT_GRAY );
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Dashboard.setBackground(Color.WHITE);
			}
		});
		Dashboard.setBackground(new Color(255, 255, 255));
		Dashboard.setBounds(24, 32, 155, 52);
		panel_1.add(Dashboard);
		Dashboard.setLayout(null);
		
		JLabel home = new JLabel(new ImageIcon(getClass().getResource("/dashboard.png")));
		home.setBounds(10, 10, 32, 32);
		Dashboard.add(home);
		
		JLabel lblNewLabel_1_1 = new JLabel("Dashboard");
		lblNewLabel_1_1.setFont(new Font("Corbel", Font.BOLD, 19));
		lblNewLabel_1_1.setBounds(52, 10, 93, 32);
		Dashboard.add(lblNewLabel_1_1);
		
		JPanel coursesbtn = new JPanel();
		coursesbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.removeAll();
				panel_2.add(new Courses(user).courses);
				panel_2.repaint();
				panel_2.revalidate();
			}
		});
		coursesbtn.setBackground(new Color(255, 255, 255));
		coursesbtn.setBounds(24, 98, 155, 52);
		panel_1.add(coursesbtn);
		coursesbtn.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Courses");
		lblNewLabel_1_1_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Corbel", Font.BOLD, 19));
		lblNewLabel_1_1_1.setBounds(52, 10, 93, 32);
		coursesbtn.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel(new ImageIcon(getClass().getResource("/book.png")));
		lblNewLabel_2.setBounds(10, 10, 32, 32);
		coursesbtn.add(lblNewLabel_2);
		
		JPanel Student = new JPanel();
		Student.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.removeAll();
				panel_2.add(new StudentPanel(user).student);
				panel_2.repaint();
				panel_2.revalidate();
			}
		});
		Student.setBackground(new Color(255, 255, 255));
		Student.setBounds(24, 236, 155, 55);
		panel_1.add(Student);
		Student.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel(new ImageIcon(getClass().getResource("/student.png")));
		lblNewLabel_3.setBounds(10, 10, 32, 32);
		Student.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Students");
		lblNewLabel_1_2.setFont(new Font("Corbel", Font.BOLD, 19));
		lblNewLabel_1_2.setBounds(51, 10, 81, 32);
		Student.add(lblNewLabel_1_2);
		
		JPanel Logout = new JPanel();
		Logout.setLayout(null);
		Logout.setBackground(Color.WHITE);
		Logout.setBounds(24, 311, 155, 55);
		panel_1.add(Logout);
		
		JLabel lblNewLabel_3_1 = new JLabel(new ImageIcon(getClass().getResource("/logout.png")));
		lblNewLabel_3_1.setBounds(10, 10, 32, 32);
		Logout.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Logout");
		lblNewLabel_1_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new SignIn();
			}
		});
		lblNewLabel_1_2_1.setFont(new Font("Corbel", Font.BOLD, 19));
		lblNewLabel_1_2_1.setBounds(51, 10, 81, 32);
		Logout.add(lblNewLabel_1_2_1);
		
		
	}
}
