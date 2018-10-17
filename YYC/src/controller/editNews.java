package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Goods;
import dao.GoodsDao;
import dao.News;
import dao.NewsDao;

/**
 * Servlet implementation class editNews
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/editNews" })
public class editNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editNews() {
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
		String time=request.getParameter("time");
		String author=request.getParameter("author");
		String content=request.getParameter("content");
		News news=new News();
		news.setTitle(title);
		news.setAuthor(author);
		news.setTime(time);
		news.setContent(content);
		NewsDao dao=new NewsDao();

		dao.editNews(news);
		response.sendRedirect("jsp/backstage.jsp#news");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
