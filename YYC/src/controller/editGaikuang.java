package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GaikuangDao;
import dao.Goods;
import dao.GoodsDao;

/**
 * Servlet implementation class editGaikuang
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/editGaikuang" })
public class editGaikuang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editGaikuang() {
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
		String content1=request.getParameter("content1");
		String content2=request.getParameter("content2");
		System.out.println(content1+","+content2);
		GaikuangDao dao=new GaikuangDao();
		dao.editGaikuang(content1, content2);
		response.sendRedirect("jsp/backstage.jsp#jianjie");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
