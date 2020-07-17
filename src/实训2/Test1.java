package 实训2;

import java.sql.*;

import jdbc.Person;

import com.mysql.jdbc.Connection;

public class Test1 {
	public static void main(String[] args) throws Exception {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接
			String url =  "jdbc:mysql://localhost:3306/sm";
			String username = "root";
			String password = "root";
			conn =  (Connection) DriverManager.getConnection(url, username, password);
			//通过Connection对象获取Statement对象
			stmt = conn.createStatement();
			//使用Statement执行sql语句
			String sql = "select * from bhy ";
			rs = stmt.executeQuery(sql);
			// 5. 操作ResultSet结果集
			System.out.println("id	|	name  	|	sex  "
				    + "   |	email		|	birthday ");
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String email = rs.getString("email");
				Date birthday = rs.getDate("birthday");
				
				System.out.println(id + "	|	" + name + "	|	"
					   	+ sex + "	|	" + email + "	|	" + birthday);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(rs != null){rs.close();}
			if(stmt != null){stmt.close();}
			if(conn != null){conn.close();}
		}
		
		
	}

	
	
}
