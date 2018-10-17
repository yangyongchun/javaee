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

/**
 * Servlet implementation class Zuihouyiye
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Zuihouyiye" })
public class Zuihouyiye extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Zuihouyiye() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GoodsDao gd=new GoodsDao();
		List<Goods> list=gd.getAllGoods();
		
		HttpSession session=request.getSession();
		session.setAttribute("currentPage",list.size());
		
		
		response.sendRedirect("http://localhost:8080/YYC/jsp/backstage.jsp#goods");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
