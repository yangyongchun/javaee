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
 * Servlet implementation class SelectGoods
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/SelectGoods" })
public class SelectGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectGoods() {
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
		HttpSession session=request.getSession();
		String name=request.getParameter("name");
		System.out.println(name);
		
		
		GoodsDao gd=new GoodsDao();
		List<Goods> goodslist=null;
		
		if(name.equals("")) {
			goodslist=gd.getAllGoods();
		}else {
		goodslist=gd.getGoodsByName1(name);
		}
		if(goodslist!=null) {
			session.setAttribute("goodslist", goodslist);
		}
		response.sendRedirect("jsp/selectGoods.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
