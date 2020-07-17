package jdbc;

import java.io.*;
import java.sql.*;

public class Test_wb_tp {
	public static void main(String[] args) {
		//clobDemo();
		//clobReadDemo();
		readImgToDB();
		System.out.println("ok");
	}
	//把一个文本文件读到数据库中，数据库中字段类型为text	
	public static void clobDemo() {
		Connection conn= null;
		PreparedStatement stm=null;	
		
		try {
			conn = DBUtil.getConnecttion();
			String sql="insert into t1 (title,content) values ( ?,?)";
			stm = conn.prepareStatement(sql);
			stm.setString(1, "这是标题");
			Reader r=new FileReader("1.txt");
			stm.setCharacterStream(2, r);
			stm.executeUpdate();
			r.close();		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.close(conn, stm, null);
		}
	}
	
	//把一个文本文件读到数据库中，数据库中字段类型为text	
	public static void clobReadDemo(){
		Connection conn= null;
		PreparedStatement stm=null;
		ResultSet rs=null;
		
		try {
			conn = DBUtil.getConnecttion();
			String sql="select * from t1 where title='这是标题'";
			stm=conn.prepareStatement(sql);
			rs=stm.executeQuery();
			if(rs.next()){  
			    System.out.println(rs.getString("title"));   
			    Reader r=rs.getCharacterStream("content");  
			    BufferedReader br=new BufferedReader(r);
			    BufferedWriter bw=new BufferedWriter(new FileWriter("copy.txt"));
			    String str=null;
			    while((str=br.readLine())!=null){
			    	bw.write(str);
			    	bw.newLine();
			    	bw.flush();
			    }	
			    
			    br.close();
			    bw.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stm, rs);
		}
	}
	
	//把一个图象读到数据库中
	public static void readImgToDB(){
		Connection conn=null;
		PreparedStatement stm=null;
		try {
			conn=DBUtil.getConnecttion();
			String sql=" insert into t1 (title,photo) values (?,?) ";   
			
			stm=conn.prepareStatement(sql);
			stm.setString(1, "新标题");
			
			InputStream in=new FileInputStream("d:/1.PNG");
			stm.setBinaryStream(2, in);
			
			stm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stm, null);
		}	
	}
	//把数据库中的一个图象读出来
	public static void getImgToFile(){
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnecttion();
			String sql = " select * from t1 where title = '新标题'";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			if(rs.next()){
				System.out.println(rs.getString("title"));
				
				InputStream in=rs.getBinaryStream("photo");
				OutputStream out=new FileOutputStream("d:/copy.PNG");
				
				byte [] buff=new byte [1024];
				int len=0;
				while((len=in.read(buff))!=-1){
					out.write(buff,0,len);
				}		
				in.close();
				out.close();
			}				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
