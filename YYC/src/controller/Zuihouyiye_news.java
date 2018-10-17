package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Goods;
import dao.GoodsDao;
import dao.News;
import dao.NewsDao;

/**
 * Servlet implementation class Zuihouyiye_news
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Zuihouyiye_news" })
public class Zuihouyiye_news extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Zuihouyiye_news() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NewsDao nd=new NewsDao();
		List<News> list=nd.getAllNews();
		
		HttpSession session=request.getSession();
		session.setAttribute("currentPage",list.size());
		
		
		response.sendRedirect("http://localhost:8080/YYC/jsp/backstage.jsp#news");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
