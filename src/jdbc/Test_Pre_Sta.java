package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class Test_Pre_Sta {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("����������");
		String name = scan.nextLine();
		System.out.println("������id");
		int id = scan.nextInt();
		
		
		Person p = getLogin(id, name);
		if(p == null){
			System.out.println("��¼ʧ��");
		}else{
			System.out.println("��¼�ɹ�");
		}
		
		
	}
	
	
	
	
	public static Person getLogin(int id, String name) {
		Person p = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnecttion();
			String sql = "select * from bhy where id = ? and name=?"; 
			stmt = conn.prepareStatement(sql); 
			stmt.setInt(1, id ); 
			stmt.setString(2, name); 
			rs = stmt.executeQuery(); 
			if(rs.next()){
				p = new Person();
				p.setName(rs.getString("id"));
				p.setName(rs.getString("name"));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt, rs);
		}
		return p;
		
	}
	
	
	
	
	
	
	
}
