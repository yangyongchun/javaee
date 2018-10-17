package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Goods;
import dao.GoodsDao;
import dao.Renzheng;
import dao.RenzhengDao;

/**
 * Servlet implementation class addRenzheng
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/addRenzheng" })
public class addRenzheng extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addRenzheng() {
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
		String time=request.getParameter("time");
		String path=request.getParameter("path");

		RenzhengDao dao=new RenzhengDao();
		List list=dao.getAllRenzheng();
		int id=list.size()+1;
		if(dao.getRenzhengByPath(path)){
			out.println("图片已存在");
		}else {
		Renzheng renzheng=new Renzheng();
		renzheng.setId(id);
		renzheng.setPath(path);
		renzheng.setTime(time);
		dao.addRenzheng(renzheng);

		response.sendRedirect("jsp/backstage.jsp#jianjie");
		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
