package jdbc;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.mysql.jdbc.Connection;

public class Test_Date {
	public static void main(String[] args) {
		//Person p = new Person();
		/*p.setId(3);
		p.setName("貂蝉");
		p.setSex("女");
		p.setEmail("dc@126.com");
		p.setBirthday(new Date());
		int result = addPerson(p);
		if(result > 0){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}*/
		Person p = selPerson();
		System.out.println(p);
	}

	private static Person selPerson() {
		Connection conn = null;
		PreparedStatement stmt = null;
		Person p = null;
		ResultSet rs =null;
		
		try {
			conn = DBUtil.getConnecttion();
			String sql="select * from student where id=3";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				p = new Person();
				p.setName(rs.getString("name"));
				p.setSex(rs.getString("sex"));
				p.setEmail(rs.getString("email"));
				p.setBirthday(rs.getDate("birthday"));  //这个地方不需要转换了
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	private static int addPerson(Person p) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int result = 0;
		
		try {
			conn = DBUtil.getConnecttion();
			String sql="insert into bhy(id,name,sex,email,birthday) values(?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);	
			stmt.setInt(1, p.getId());
			stmt.setString(2, p.getName());
			stmt.setString(3, p.getSex());
			stmt.setString(4, p.getEmail());
			stmt.setDate(5, new java.sql.Date(p.getBirthday().getTime()));
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt, null);
		}
		return result;
	}
	
	/*System.out.println(new Date());
	String time = new SimpleDateFormat("yyyy/MM/dd E hh:mm:ss").format(new Date()); 
	System.out.println(time);*/
}
