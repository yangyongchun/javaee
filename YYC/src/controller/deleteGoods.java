package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import dao.GoodsDao;

/**
 * Servlet implementation class deleteGoods
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/deleteGoods" })
public class deleteGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteGoods() {
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
		String delstr=request.getParameter("del");
		delstr = java.net.URLDecoder.decode(delstr,"UTF-8"); 
		String[] del=delstr.split("/");
		GoodsDao gd=new GoodsDao();
		if(del.length>0) {
			for(String name:del) {
				System.out.println(name);
				gd.deleteGoods(name);
			}
			}
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
