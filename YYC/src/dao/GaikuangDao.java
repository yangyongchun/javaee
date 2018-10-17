package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GaikuangDao {
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public GaikuangDao() {
		conn=DBConnection.getConn();
	}
	public String getContent() {
		String sql="select * from gaikuang";
		String str = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
			str=rs.getString("content");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	public void editGaikuang(String str1,String str2) {
		String sql="update gaikuang set content=?where content=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,str1);
			ps.setString(2,str2);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String [] args) {
		GaikuangDao dao=new GaikuangDao();
		System.out.println(dao.getContent());
	}
}
