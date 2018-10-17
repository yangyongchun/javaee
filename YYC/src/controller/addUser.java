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

/**
 * Servlet implementation class addServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/addUser" })
public class addUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addUser() {
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
		String createtime=request.getParameter("createtime");
		String power=request.getParameter("power");
		int power1=Integer.parseInt(power);
		EmpDao ed=new EmpDao();
		if(ed.getEmpByUsername(username)) {
			out.println("用户已存在");
		}else {
		Emp emp=new Emp();
		emp.setUsername(username);
		emp.setPassword(password);
		emp.setCreateTime(createtime);
		emp.setPower(power1);
		ed.addEmp(emp);
		response.sendRedirect("jsp/backstage.jsp#users");
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
