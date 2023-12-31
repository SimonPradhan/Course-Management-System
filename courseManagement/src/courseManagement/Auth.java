package courseManagement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import courseManagement.models.user.Admin;
import courseManagement.models.user.Student;
import courseManagement.models.user.Teacher;

import courseManagement.models.user.SystemUser;

public class Auth {
	private static PreparedStatement checkEmailStmt;
	private static PreparedStatement retrieveRoleStmt;
	private static PreparedStatement checkEmailExistenceStmt;
	private static PreparedStatement addCredentialStmt;

	public Auth(DatabaseManager db) throws SQLException {
		checkEmailStmt = db.getConnection().prepareStatement("SELECT count(*) FROM auth WHERE email=?");
		retrieveRoleStmt = db.getConnection()
				.prepareStatement("SELECT id,name,role FROM auth WHERE email=? AND BINARY password=?");
		checkEmailExistenceStmt = db.getConnection().prepareStatement("SELECT email FROM auth WHERE email=?");
		addCredentialStmt = db.getConnection()
				.prepareStatement("INSERT INTO auth (name, email, password, role) VALUES (?,?,?, 'Student')");
	}

	public static SystemUser returnSystemUser(String email, String password) throws Exception {
		try {
			checkEmailStmt.setString(1, email);
			ResultSet rs = checkEmailStmt.executeQuery();
			int count = 0;
			if (rs.next())
				count = rs.getInt(1);
			if (count == 0)
				throw new Exception("No user with this email found!");
			else {
				retrieveRoleStmt.setString(1, email);
				retrieveRoleStmt.setString(2, password);
				rs = retrieveRoleStmt.executeQuery();
				if (rs.next()) {
					switch (rs.getString("role")) {
						case "Student":
							return new Student(rs.getInt("id"), rs.getString("name"));
						case "Teacher":
							return new Teacher(rs.getString("name"));
						case "Admin":
							return new Admin(rs.getString("name"));
						default:
							throw new Exception("An error occurred while retrieving role!");
					}
				} else
					throw new Exception("Password not valid!");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new Exception("An error occurred while checking the email and password!");
		}
	}

	public static void addCredential(String name, String email, String password) throws Exception {
		try {
			checkEmailExistenceStmt.setString(1, email);
			ResultSet rs = checkEmailExistenceStmt.executeQuery();
			if (rs.next()) {
				throw new Exception("Email already in use!");
			} else {
				addCredentialStmt.setString(1, name);
				addCredentialStmt.setString(2, email);
				addCredentialStmt.setString(3, password);
				addCredentialStmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
