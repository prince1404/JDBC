package Com;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	
	static String driver="com.mysql.cj.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/user_db";
	static String username="root";
	static String password = "Maa@1404";
	
	
	public void saveUser(User u) throws Exception {
		Class.forName(driver);
		
		Connection c= DriverManager.getConnection(url,username, password);
		
		PreparedStatement ps= c.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
		ps.setInt(1, u.getId());
		ps.setString(2, u.getFname());
		ps.setString(3, u.getLname());
		ps.setString(4, u.getGender());
		ps.setString(5, u.getEmail());
		ps.setString(6, u.getPassword());
		ps.setLong(7, u.getPhone());
		
		ps.executeUpdate();
		
		c.close();
		
		System.out.println("Data saved....");
		
		
		
	}
	
	public void deleteById(int id) throws Exception {
		
		Class.forName(driver);
		
		Connection c= DriverManager.getConnection(url, username, password);
		
		PreparedStatement ps= c.prepareStatement("delete from user where id=?");
		
		ps.setInt(1, id);
		
		ps.executeUpdate();
		
		c.close();
		
		System.out.println("Data deleted....");
		
		
		
	}
	
	
		public User  getById(int id) throws Exception {
			
			Class.forName(driver);
			
			Connection c= DriverManager.getConnection(url,username,password);
			
			PreparedStatement ps= c.prepareStatement("select * from user where id =?");
			ps.setInt(1, id);
			
			ResultSet rs =ps.executeQuery();
			
			
			while(rs.next()) {
				int id1=rs.getInt("id");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				String password = rs.getString("password");
				long phone = rs.getLong("phone");
				
				
				User u =new User();
				u.setId(id1);
				u.setFname(fname);
				u.setLname(lname);
				u.setGender(gender);
				u.setEmail(email);
				u.setPassword(password);
				u.setPhone(phone);
				
				return u;
				
			}
			return null;
		}
	
	
		public User  getByEmail(String email) throws Exception {
			
			Class.forName(driver);
			
			Connection c= DriverManager.getConnection(url,username,password);
			
			PreparedStatement ps= c.prepareStatement("select * from user where email =?");
			ps.setString(1, email);
			
			ResultSet rs =ps.executeQuery();
			
			
			while(rs.next()) {
				int id1=rs.getInt("id");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String gender = rs.getString("gender");
				String email1 = rs.getString("email");
				String password = rs.getString("password");
				long phone = rs.getLong("phone");
				
				
				User u =new User();
				u.setId(id1);
				u.setFname(fname);
				u.setLname(lname);
				u.setGender(gender);
				u.setEmail(email1);
				u.setPassword(password);
				u.setPhone(phone);
				
				return u;
				
			}
			return null;
		}
		
		
		public List<User> fetchAll()  throws Exception {
			Class.forName(driver);
			
			Connection c= DriverManager.getConnection(url,username,password);
			
			Statement s = c.createStatement();
			
			ResultSet rs = s.executeQuery("select * from User");
			
			ArrayList<User> al = new ArrayList<>();
			

			while(rs.next()) {
				int id1=rs.getInt("id");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String gender = rs.getString("gender");
				String email1 = rs.getString("email");
				String password = rs.getString("password");
				long phone = rs.getLong("phone");
				
				
				User u =new User();
				u.setId(id1);
				u.setFname(fname);
				u.setLname(lname);
				u.setGender(gender);
				u.setEmail(email1);
				u.setPassword(password);
				u.setPhone(phone);
				
				
				al.add(u);
			 
		}
			return al;
			
		}
		
		public void UpdateUser(User u) throws Exception  {
			
			Class.forName(driver);
			
			Connection c= DriverManager.getConnection(url,username, password);
			
			PreparedStatement ps = c.prepareStatement
					("update user set fname=?,lname=?,gender=?,email=?,password=?,phone=? where id=?");
			
			ps.setString(1, u.getFname());
			ps.setString(2, u.getLname());
			ps.setString(3, u.getGender());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getPassword());
			ps.setLong(6, u.getPhone());
			ps.setInt(7, u.getId());
			
			ps.executeUpdate();
			
			c.close();
		}
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	

