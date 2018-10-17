package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmpDao {
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public EmpDao() {
		conn=DBConnection.getConn();
	}
	public List<Emp> getEmpFengye( int x, int y){
		List<Emp> list=new ArrayList<Emp>();
		String sql="select * from emp limit "+x+","+y;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Emp emp=new Emp();
				emp.setUsername(rs.getString("username"));
				emp.setPassword(rs.getString("password"));
				emp.setCreateTime(rs.getString("createtime"));
				emp.setPower(rs.getInt("power"));
				list.add(emp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Emp> getAllEmp(){
		List<Emp> list=new ArrayList<Emp>();
		String sql="select * from emp";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Emp emp=new Emp();
				emp.setUsername(rs.getString("username"));
				emp.setPassword(rs.getString("password"));
				emp.setCreateTime(rs.getString("createtime"));
				emp.setPower(rs.getInt("power"));
				list.add(emp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Emp> getEmpByUsername1(String username){
		List<Emp> list=new ArrayList<Emp>();
		String sql="select * from emp where username=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			rs=ps.executeQuery();
			while(rs.next()) {
				Emp emp=new Emp();
				emp.setUsername(rs.getString("username"));
				emp.setPassword(rs.getString("password"));
				emp.setCreateTime(rs.getString("createtime"));
				emp.setPower(rs.getInt("power"));
				list.add(emp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Emp getEmpByUser(String username, String password){

		Emp emp=new Emp();
		String sql="select * from emp where username=?and password=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

			while(rs.next()) {
				emp.setUsername(rs.getString("username"));
				emp.setPassword(rs.getString("password"));
				emp.setCreateTime(rs.getString("createtime"));
				emp.setPower(rs.getInt("power"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
	public boolean getEmpByUsername(String username){

		boolean flag=false;
		String sql="select * from emp where username=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			rs=ps.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

			while(rs.next()) {
				flag=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public void addEmp(Emp emp) {
		String sql="insert into emp values(?,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, emp.getUsername());
			ps.setString(2, emp.getPassword());
			ps.setString(3, emp.getCreateTime());
			ps.setInt(4, emp.getPower());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteEmp(String username) {
		String sql="delete from emp where username=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void editEmp(Emp emp) {
		String sql="update emp set password=?,createtime=?, power=? where username=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,emp.getPassword());
			ps.setString(2,emp.getCreateTime());
			ps.setInt(3, emp.getPower());
			ps.setString(4, emp.getUsername());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		EmpDao ed=new EmpDao();
		Emp emp=new Emp();
		emp.setUsername("abcasdsa");
		emp.setPassword("123456");
		emp.setCreateTime("2018-9-14");
		emp.setPower(0);
		ed.addEmp(emp);
		ed.deleteEmp("abcasdsa");
		List list=ed.getAllEmp();
		System.out.println(list);

	}
}