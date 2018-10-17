package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.News;
import dao.NewsDao;

/**
 * Servlet implementation class addNews
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/addNews" })
public class addNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String title=request.getParameter("title");
		String content=request.getParameter("content");

		HttpSession session=request.getSession();
		String author=(String) session.getAttribute("username");
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String time=dateFormat.format(new Date());
		NewsDao nd=new NewsDao();
		if(nd.getNewsByTitle(title)){
			out.println("标题已存在");
		}else {
		News news=new News();
		news.setTitle(title);
	
		news.setContent(content);
		news.setTime(time);
		news.setAuthor(author);
		nd.addNews(news);
		response.sendRedirect("jsp/backstage.jsp#news");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
