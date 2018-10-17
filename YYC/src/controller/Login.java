package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Emp;
import dao.EmpDao;

/**
 * Servlet implementation class Login
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		EmpDao ed=new EmpDao();
		Emp emp=new Emp();
		emp=ed.getEmpByUser(username, password);
		if(emp.getUsername()!=null) {

	
			String.valueOf(emp.getPower());
			HttpSession session=request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("password", emp.getPassword());
			session.setAttribute("createtime", emp.getCreateTime());
			session.setAttribute("power", String.valueOf(emp.getPower()));
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String logtime=dateFormat.format(new Date());
			session.setAttribute("logtime", logtime);
			session.setAttribute("currentPage", "1");
			if(session.getAttribute("power").equals("1")) {
			response.sendRedirect("jsp/backstage.jsp");
			}
			else {
				response.sendRedirect("jsp/user0.jsp");
			}

			
		}else {
		out.print("登录失败");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
