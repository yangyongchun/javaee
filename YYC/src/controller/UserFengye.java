package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Emp;
import dao.EmpDao;
import dao.PageBean;

/**
 * Servlet implementation class UserFengye
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/UserFengye" })
public class UserFengye extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserFengye() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PageBean pageUser=new PageBean();
		HttpSession session=request.getSession();
		String curPage=request.getParameter("curPage");
		System.out.println(curPage);
		if(curPage!=null) {
		int curPage1=Integer.parseInt(curPage);
		
		pageUser.setCurPage(curPage1);
		}
		int i=(pageUser.getCurPage()-1)*pageUser.getPageSize();
		EmpDao dao=new EmpDao();
		List<Emp> Emplist=null;
		List<Emp> Emplist1=null;
		Emplist=dao.getEmpFengye(i,pageUser.getPageSize());
		Emplist1=dao.getAllEmp();
		if(Emplist!=null) {
			session.setAttribute("userlist", Emplist);
		}
		int totalPage=0;
		if(Emplist1.size()%pageUser.getPageSize()==0) {
			totalPage=	Emplist1.size()/pageUser.getPageSize();
				}
		else {
			totalPage=Emplist1.size()/pageUser.getPageSize()+1;
		}
		
		pageUser.setTotalPage(totalPage);
		session.setAttribute("pageUser", pageUser);
		
		response.sendRedirect("http://localhost:8080/YYC/jsp/backstage.jsp#users");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
