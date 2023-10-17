package courseManagement;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import courseManagement.models.user.Admin;
import courseManagement.models.user.Student;
import courseManagement.models.user.SystemUser;
import courseManagement.models.user.Teacher;

public class SignIn {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn window = new SignIn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignIn() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			DatabaseManager db = DatabaseManager.getInstance();
			new Auth(db);
			new DataRetriever();
			new DataManager();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null,
					"Can not connect to database!\nPlease make sure mySQL is correctly setup and running!",
					"Error 500: Server Communication Failed", JOptionPane.ERROR_MESSAGE);
			System.exit(500);
		}
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Corbel", Font.BOLD, 12));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 492, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel(" Welcome back \r\n");
		lblNewLabel.setBounds(134, 98, 242, 66);
		lblNewLabel.setFont(new Font("DialogInput", Font.BOLD, 28));
		
		textField = new JTextField();
		textField.setBounds(144, 227, 177, 21);
		textField.setFont(new Font("Corbel", Font.BOLD, 12));
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setBounds(144, 268, 76, 18);
		lblNewLabel_1_1.setFont(new Font("Corbel", Font.BOLD, 16));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(144, 287, 177, 21);
		passwordField.setFont(new Font("Corbel", Font.BOLD, 12));
		
		JLabel invalidEmail = new JLabel("");
		invalidEmail.setForeground(new Color(255, 0, 0));
		invalidEmail.setBounds(144, 249, 235, 13);
		frame.getContentPane().add(invalidEmail);
		
		JLabel invalidPass = new JLabel("");
		invalidPass.setForeground(new Color(255, 0, 0));
		invalidPass.setBounds(144, 312, 268, 13);
		frame.getContentPane().add(invalidPass);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.setBounds(186, 335, 96, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Boolean> isValidSubmission = new ArrayList<Boolean>();
				String email = textField.getText();
				String password = new String(passwordField.getPassword());
				isValidSubmission.add(Validator.validate(email, invalidEmail, "Email"));
				isValidSubmission.add(Validator.validate(password, invalidPass, "Password")); {
				
				if (!isValidSubmission.contains(false)){
					try {
						SystemUser user = Auth.returnSystemUser(email, password);
						JOptionPane.showMessageDialog(null, "Logged in successfully");
						if (user instanceof Student) {
							new AdminPanel(user);
							frame.setVisible(false);
						} else if (user instanceof Teacher) {
							new AdminPanel(user);
							frame.setVisible(false);
						} else if (user instanceof Admin) {
							new AdminPanel(user);
							frame.setVisible(false);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), null, JOptionPane.ERROR_MESSAGE);
					}
				
					
					
				
				}
			}
		}});
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setFont(new Font("Corbel", Font.BOLD, 16));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 10, 64, 66);
		Image img = new ImageIcon(this.getClass().getResource("/heraldLogo64.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		
		JLabel lblNewLabel_1 = new JLabel("Email\r\n");
		lblNewLabel_1.setBounds(144, 208, 58, 20);
		lblNewLabel_1.setFont(new Font("Corbel", Font.BOLD, 16));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblNewLabel_1_1);
		frame.getContentPane().add(lblNewLabel_1);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(passwordField);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Login to your account");
		lblNewLabel_3.setFont(new Font("DialogInput", Font.BOLD, 17));
		lblNewLabel_3.setBounds(144, 165, 242, 18);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblHeraldCollege = new JLabel("Herald College");
		lblHeraldCollege.setFont(new Font("DialogInput", Font.BOLD, 28));
		lblHeraldCollege.setBounds(84, 10, 242, 66);
		frame.getContentPane().add(lblHeraldCollege);
		

	}
}
