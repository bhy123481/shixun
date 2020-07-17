package jdbc;

import java.sql.*;
import java.util.Date;



public class Test {
	public static void main(String[] args) {
		Connection conn =null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnecttion();
			stmt = conn.createStatement();
			String sql = " select * from bhy ";
			rs = stmt.executeQuery(sql);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt, rs);
		}
		Person p = new Person();
		/*p.setId(4);
		p.setName("刘备");
		p.setSex("男");
		p.setEmail("lb@126.com");
		*/
		//p.setBirthday(new Date());
		/*int result = addPerson(p);
		if(result > 0){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
		*/
		/*int result = updatePerson(p);
		if(result > 0){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}*/
		
		int result = delPerson(3);
		if(result > 0){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
	}
	
	//添加数据
	//public int addPeople
	public static int addPerson(Person p){
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DBUtil.getConnecttion();
			stmt = conn.createStatement();
			String sql = "insert into bhy(id,name,sex,email)"
					+ "values('"+p.getId()+"','"+p.getName()+"','"+p.getSex()+"','"+p.getEmail()+"')";
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt, null);
		}
		return result;
		
	}
	
	//修改数据
	public static int updatePerson(Person p){
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DBUtil.getConnecttion();
			stmt = conn.createStatement();
			String sql = "update bhy set name='"+p.getName()+"'"+"where id ="+p.getId();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt, null);
		}
		return result;
	}
	//删除数据
	public static int delPerson(int id){
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DBUtil.getConnecttion();
			stmt = conn.createStatement();
			String sql = "delete from bhy where id="+id;
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt, null);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
}
