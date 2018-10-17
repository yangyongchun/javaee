package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Goods;
import dao.GoodsDao;
import dao.PageBean;
import dao.Renzheng;
import dao.RenzhengDao;

/**
 * Servlet implementation class SearchRenzheng_qian
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/SearchRenzheng_qian" })
public class SearchRenzheng_qian extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchRenzheng_qian() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String curPage=request.getParameter("curPage");
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String time=dateFormat.format(new Date());
		RenzhengDao dao=new RenzhengDao();
		List<Renzheng> renzhenglist=null;
		List<Renzheng> renzhenglist1=new ArrayList();
		renzhenglist=dao.getAllRenzheng();
		for(Renzheng renzheng :renzhenglist) {
			if(time.compareTo(renzheng.getTime())<0) {
				renzhenglist1.add(renzheng);
			}
		}
		
		if(renzhenglist1!=null) {
			request.setAttribute("renzhenglist", renzhenglist1);
		}
		request.getRequestDispatcher("jsp/jianjie_2.jsp").forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
