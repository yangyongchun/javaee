package com.yyc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet3
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Servlet3" })
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3() {
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
				ServletContext ctx=this.getServletContext();
				String username=request.getParameter("username");
				String password=request.getParameter("password");
				if(username.equals("abc")&&password.equals("123456")) {
//					out.println("yes");
					ctx.setAttribute("username", username);
					request.getRequestDispatcher("Servlet1").forward(request, response);
//					response.sendRedirect("Servlet2");
					
				}else {
				out.print("好");
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
