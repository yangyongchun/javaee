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

/**
 * Servlet implementation class SelectUser
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/SelectUser" })
public class SelectUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		HttpSession session=request.getSession();
		EmpDao ed=new EmpDao();
		List<Emp> userlist=null;
		if(username.equals("")) {
			userlist=ed.getAllEmp();
		}else {
			userlist=ed.getEmpByUsername1(username);
			}
		
		if(userlist!=null) {
			request.setAttribute("userlist", userlist);
		}
		request.getRequestDispatcher("jsp/user_select.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
