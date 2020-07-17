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
	//��һ���ı��ļ��������ݿ��У����ݿ����ֶ�����Ϊtext	
	public static void clobDemo() {
		Connection conn= null;
		PreparedStatement stm=null;	
		
		try {
			conn = DBUtil.getConnecttion();
			String sql="insert into t1 (title,content) values ( ?,?)";
			stm = conn.prepareStatement(sql);
			stm.setString(1, "���Ǳ���");
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
	
	//��һ���ı��ļ��������ݿ��У����ݿ����ֶ�����Ϊtext	
	public static void clobReadDemo(){
		Connection conn= null;
		PreparedStatement stm=null;
		ResultSet rs=null;
		
		try {
			conn = DBUtil.getConnecttion();
			String sql="select * from t1 where title='���Ǳ���'";
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
	
	//��һ��ͼ��������ݿ���
	public static void readImgToDB(){
		Connection conn=null;
		PreparedStatement stm=null;
		try {
			conn=DBUtil.getConnecttion();
			String sql=" insert into t1 (title,photo) values (?,?) ";   
			
			stm=conn.prepareStatement(sql);
			stm.setString(1, "�±���");
			
			InputStream in=new FileInputStream("d:/1.PNG");
			stm.setBinaryStream(2, in);
			
			stm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stm, null);
		}	
	}
	//�����ݿ��е�һ��ͼ�������
	public static void getImgToFile(){
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnecttion();
			String sql = " select * from t1 where title = '�±���'";
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
