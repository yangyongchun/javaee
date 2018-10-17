package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RenzhengDao {
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public RenzhengDao() {
		conn=DBConnection.getConn();
	}
	
	public List<Renzheng> getAllRenzheng(){
		List<Renzheng> list=new ArrayList<Renzheng>();
		String sql="select * from renzheng";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Renzheng renzheng=new Renzheng();
				renzheng.setId(rs.getInt("id"));
				renzheng.setPath(rs.getString("path"));
				renzheng.setTime(rs.getString("time"));
				
				list.add(renzheng);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Renzheng> getRenzhengById1(int id){
		List<Renzheng> list=new ArrayList<Renzheng>();
		String sql="select * from renzheng where id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				Renzheng renzheng=new Renzheng();
				renzheng.setId(rs.getInt("id"));
				renzheng.setPath(rs.getString("path"));
				renzheng.setTime(rs.getString("time"));
				
				list.add(renzheng);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public Boolean getRenzhengByPath(String path){
		Boolean flag=false;
		String sql="select * from renzheng where path=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, path);
			rs=ps.executeQuery();
			while(rs.next()) {
				flag=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public void addRenzheng(Renzheng renzheng) {
		String sql="insert into renzheng values(?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, renzheng.getId());
			ps.setString(2, renzheng.getPath());
			ps.setString(3, renzheng.getTime());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleterenzheng(int id) {
		String sql="delete from renzheng where id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void editRenzheng(Renzheng renzheng) {
		String sql="update renzheng set path=?,time=? where id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,renzheng.getPath());
			ps.setString(2,renzheng.getTime());
			ps.setInt(3, renzheng.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
