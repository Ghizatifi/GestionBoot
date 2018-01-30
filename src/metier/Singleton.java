package metier;
import java.sql.Connection;
import java.sql.DriverManager;
public class Singleton {
	
	private static Connection connection; 
	static{
		try {            
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionvente", "root", "");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	// méthode getConnection
	public static Connection getConnection(){
		return connection;
	}
	
}
