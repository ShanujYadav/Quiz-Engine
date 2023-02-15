import java.sql.Connection;
import java.sql.DriverManager;
public class MyData {
		static Connection getConnection() {
			Connection cn=null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn= DriverManager.getConnection("jdbc:mysql://localhost/QE?user=root&password=root");
			}
			catch(Exception e) {
				
			}
			return cn;
		}}
