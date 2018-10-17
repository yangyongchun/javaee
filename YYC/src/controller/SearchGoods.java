package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Emp;
import dao.EmpDao;
import dao.Goods;
import dao.GoodsDao;

/**
 * Servlet implementation class SearchGoods
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/SearchGoods" })
public class SearchGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchGoods() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=utf-8");
		GoodsDao gd=new GoodsDao();
		List<Goods> goodslist=null;
		goodslist=gd.getAllGoods();
		if(goodslist!=null) {
			request.setAttribute("goodslist", goodslist);
		}
		request.getRequestDispatcher("jsp/goods_hou.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
