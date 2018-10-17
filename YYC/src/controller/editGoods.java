package controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class editGoods
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/editGoods" })
public class editGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editGoods() {
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
		String name=request.getParameter("name");
		String pic=request.getParameter("pic");
		String introduce=request.getParameter("introduce");
		System.out.println(pic);
		Goods goods=new Goods();
		goods.setName(name);
		goods.setPic(pic);
		goods.setIntroduce(introduce);
		GoodsDao dao=new GoodsDao();
		dao.editGoods(goods);
		response.sendRedirect("jsp/backstage.jsp#goods");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
