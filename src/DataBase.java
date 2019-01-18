import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public  class DataBase  {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/users_db?autoReconnect=true&useSSL=false";

	private static final String USER = "root";
	private static final String PASS = "s1pte6wcc";

	static Connection conn = null;
	static Statement stmt = null;
	
	public DataBase(){
		
	}
	
	public void InsertToTable(UserObj user) {
		
		String insert = "INSERT INTO users_db.users" + "(first_name,last_name,email,phone,company,pass) " + 
		"VALUES ('" + user.getFirst_name() + "' ,'" + user.getLast_name()+"' ,'" + user.getEmail()+"' ,'" + user.getPhone()+ "' ,'" +user.getCompany()+
		"' ,'" + user.getPassword()+ "');";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			stmt.executeUpdate(insert);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	
	}
	public boolean checkEmail(String email){
		
		ResultSet rs = null;
		boolean result=false;
		
		String insert = "SELECT count(email) from users_db.users where email = '"+ email +"'; ";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(insert);
			rs.next();
			if(rs.getString(1).equals("1")){
				result = true;
			}else {
				result = false;
			}
			 
		
			
			
			
		} catch (SQLException e) {
			System.out.println("An exception happened while running a query");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return result;
		
	}
	
	public String confirmUser(String email){
		
		ResultSet rs = null;
		String result = "";
		String insert = "SELECT pass from users_db.users where email = '"+ email +"'; ";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(insert);
			rs.next();
			result = rs.getString(1);
			
		} catch (SQLException e) {
			System.out.println("An exception happened while running a query");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return result;
		
	}
	
	public void changeField(String field, String newValue, String email){
		
		
		String update = "update users_db.users set "+field + "='"+ newValue+"' where email='"+ email +"';";
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					stmt = conn.createStatement();
					stmt.executeUpdate(update);
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					try {
						if (stmt != null)
							stmt.close();
					} catch (SQLException se2) {
					}
					try {
						if (conn != null)
							conn.close();
					} catch (SQLException se) {
						se.printStackTrace();
					}
				}
	}
	
	public UserObj getUser(String email){
		ResultSet rs = null;
		UserObj user = null ;
		String insert = "SELECT * from users_db.users where email = '"+ email +"'; ";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(insert);
			rs.next();
			user = new UserObj(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			
		} catch (SQLException e) {
			System.out.println("An exception happened while running a query");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return user;
		
	}
	

}
