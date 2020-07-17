package jdbc;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test_mohu {
	public static void main(String[] args) {
		List <Person> list = getList("Áõ","ÄÐ","l");
		for (Person p : list) {
			System.out.println(p);
		}
		
	}

	private static List<Person> getList(String name, String sex, String email) {
		List<Person> list = new ArrayList<Person>();
		Person p =null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =null;
		
		try {
			conn = DBUtil.getConnecttion();
			stmt = conn.createStatement();
			String sql= "select * from bhy where 1=1";
			
			if(!(sex == null || "".equals(sex))){
				sql += " and sex like '%"+sex+"%' ";
			}
			if(!(email == null || "".equals(email))){
				sql += " and email like '%"+email+"%' ";
			}
			if(!(name == null || "".equals(name))){
				sql += " and name like '%"+name+"%' ";
			}
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				p = new Person();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setSex(rs.getString("sex"));
				p.setEmail(rs.getString("email"));
				p.setBirthday(rs.getDate("birthday"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
