package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.News;
import dao.NewsDao;

/**
 * Servlet implementation class SelectNews
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/SelectNews" })
public class SelectNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectNews() {
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
		String title=request.getParameter("title");
		NewsDao nd=new NewsDao();
		List<News> newslist=null;
		System.out.println(title);

		if(title.equals("")) {
		newslist=nd.getAllNews();}
	

		else {
	newslist=nd.getNewsByTitle1(title);

		}
		if(newslist!=null) {
			request.setAttribute("newslist", newslist);
		}
		request.getRequestDispatcher("jsp/news_select.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
