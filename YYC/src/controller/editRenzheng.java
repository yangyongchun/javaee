package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Renzheng;
import dao.RenzhengDao;

/**
 * Servlet implementation class editRenzheng
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/editRenzheng" })
public class editRenzheng extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editRenzheng() {
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
		String id=request.getParameter("id");
		String time=request.getParameter("time");
		String path=request.getParameter("path");
System.out.println(id);
		int id1=Integer.parseInt(id);
		RenzhengDao dao=new RenzhengDao();
		Renzheng renzheng=new Renzheng();
		renzheng.setId(id1);
		renzheng.setPath(path);
		renzheng.setTime(time);
		dao.editRenzheng(renzheng);

		response.sendRedirect("jsp/backstage.jsp#jianjie");	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
