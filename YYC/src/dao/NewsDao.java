package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDao {

	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public NewsDao() {
		conn=DBConnection.getConn();
	}
	public List<News> getNewsFengye(int x,int y){
		List<News> list=new ArrayList<News>();
		String sql="select * from news limit "+x+","+y;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				News news=new News();
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
				news.setAuthor(rs.getString("author"));
				news.setTime(rs.getString("time"));
				list.add(news);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<News> getAllNews(){
		List<News> list=new ArrayList<News>();
		String sql="select * from news";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				News news=new News();
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
				news.setAuthor(rs.getString("author"));
				news.setTime(rs.getString("time"));
				list.add(news);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<News> getNewsByTitle1(String title){
		List<News> list=new ArrayList<News>();
		String sql="select * from news where title=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, title);
			rs=ps.executeQuery();
			while(rs.next()) {
				News news=new News();
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
				news.setAuthor(rs.getString("author"));
				news.setTime(rs.getString("time"));
				list.add(news);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public Boolean getNewsByTitle(String title){
		Boolean flag=false;
		String sql="select * from news where title=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, title);
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
	public void addNews(News news) {
		String sql="insert into news values(?,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, news.getTitle());
			ps.setString(2, news.getContent());
			ps.setString(3, news.getTime());
			ps.setString(4, news.getAuthor());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteNews(String title) {
		String sql="delete from news where title=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,title);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void editNews(News news) {
		String sql="update news set content=?,time=?,author=? where title=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, news.getContent());
			ps.setString(2, news.getTime());
			ps.setString(3, news.getAuthor());
			ps.setString(4, news.getTitle());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		News news=new News();
		news.setTitle("sad");
		news.setAuthor("yyc");
		news.setContent("桑德拉建设路口");
		news.setTime("2018");

		NewsDao dao=new NewsDao();
		dao.editNews(news);
	}
	
}
