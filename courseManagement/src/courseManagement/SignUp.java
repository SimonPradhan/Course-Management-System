package courseManagement;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

public class SignUp {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
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
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 630, 721);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(getClass().getResource("/heraldLogo64.jpg")));
		lblNewLabel.setBounds(10, 10, 86, 79);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblHeraldCollege = new JLabel("Herald College");
		lblHeraldCollege.setFont(new Font("DialogInput", Font.BOLD, 28));
		lblHeraldCollege.setBounds(106, 20, 242, 66);
		frame.getContentPane().add(lblHeraldCollege);
		
		textField = new JTextField();
		textField.setBounds(152, 190, 260, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 243, 260, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(152, 290, 260, 26);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1 = new JLabel("First Name: ");
		lblNewLabel_1.setFont(new Font("Franklin Gothic Book", Font.BOLD, 18));
		lblNewLabel_1.setBounds(32, 190, 110, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name: ");
		lblNewLabel_2.setFont(new Font("Franklin Gothic Book", Font.BOLD, 18));
		lblNewLabel_2.setBounds(32, 248, 110, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Franklin Gothic Book", Font.BOLD, 18));
		lblNewLabel_3.setBounds(32, 296, 110, 20);
		frame.getContentPane().add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(152, 338, 260, 26);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_3_1 = new JLabel("Password: ");
		lblNewLabel_3_1.setFont(new Font("Franklin Gothic Book", Font.BOLD, 18));
		lblNewLabel_3_1.setBounds(32, 344, 110, 20);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(152, 383, 260, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Phone No:");
		lblNewLabel_3_1_1.setFont(new Font("Franklin Gothic Book", Font.BOLD, 18));
		lblNewLabel_3_1_1.setBounds(32, 389, 110, 20);
		frame.getContentPane().add(lblNewLabel_3_1_1);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setFont(new Font("Franklin Gothic Book", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(237, 465, 99, 36);
		frame.getContentPane().add(btnNewButton);
	}
}
