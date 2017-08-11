package mvc.mvc.configuration.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Database {

	private Connection conn;
	static final String CONN_URL="jdbc:postgresql://localhost:5432/EXPERT_DB";
	private Database(){}
	public static Database getInstance(){
		return new Database();
	}
	
	public Connection getConnection(){
		try{
			Class.forName("org.postgresql.Driver");
			Properties p=new Properties();
			p.put("user","postgres");
			p.put("password","123");
			conn=DriverManager.getConnection(CONN_URL,"postgres","123");
			System.out.println("connect success");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return conn;
	}
}
