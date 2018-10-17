package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDao {

	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public GoodsDao() {
		conn=DBConnection.getConn();
	}
	public List<Goods> getGoodsFenye(int x,int y){
		List<Goods> list=new ArrayList<Goods>();
		String sql="select * from goods limit "+x+","+y;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Goods goods=new Goods();
				goods.setName(rs.getString("name"));
				goods.setPic(rs.getString("pic"));
				goods.setIntroduce(rs.getString("introduce"));
				
				list.add(goods);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Goods> getAllGoods(){
		List<Goods> list=new ArrayList<Goods>();
		String sql="select * from goods";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Goods goods=new Goods();
				goods.setName(rs.getString("name"));
				goods.setPic(rs.getString("pic"));
				goods.setIntroduce(rs.getString("introduce"));
				
				list.add(goods);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Goods> getGoodsByName1(String name){
		List<Goods> list=new ArrayList<Goods>();
		String sql="select * from goods where name=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			rs=ps.executeQuery();
			while(rs.next()) {
				Goods goods=new Goods();
				goods.setName(rs.getString("name"));
				goods.setPic(rs.getString("pic"));
				goods.setIntroduce(rs.getString("introduce"));
				list.add(goods);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public Boolean getGoodsByName(String name){
		Boolean flag=false;
		String sql="select * from goods where name=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
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
	public void addGoods(Goods goods) {
		String sql="insert into goods values(?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, goods.getName());
			ps.setString(2, goods.getPic());
			ps.setString(3, goods.getIntroduce());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteGoods(String name) {
		String sql="delete from goods where name=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,name);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void editGoods(Goods goods) {
		String sql="update goods set pic=?,introduce=? where name=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,goods.getPic());
			ps.setString(2,goods.getIntroduce());
			ps.setString(3, goods.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		GoodsDao gd=new GoodsDao();
		List list =gd.getGoodsFenye(3, 6);
		System.out.println(list.size());
		

	}
	
}
