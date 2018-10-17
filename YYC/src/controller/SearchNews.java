package controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class SearchNews
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/SearchNews" })
public class SearchNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

response.setContentType("text/html;charset=utf-8");
		
		String title=request.getParameter("title");
		NewsDao nd=new NewsDao();
		List<News> newslist=null;
		System.out.println(title);
		newslist=nd.getAllNews();
	

		if(newslist!=null) {
			request.setAttribute("newslist", newslist);
		}
		request.getRequestDispatcher("jsp/news_hou.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
