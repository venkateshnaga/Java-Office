package com.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee.bean.EmployeeBean;
import com.employee.dbo.Dboperations;

/**
 * Servlet implementation class Deleteservlet
 */
@WebServlet("/Deleteservlet")
public class Deleteservlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deleteservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String tempid=request.getParameter("tempid");
		
		EmployeeBean emp=new EmployeeBean();
		emp.setEmpid(tempid);
		
		Dboperations dbo=new Dboperations();
		int result=dbo.delete(emp);

		RequestDispatcher requestDispact=request.getRequestDispatcher("deletesucess.jsp");
		
		HttpSession session=request.getSession();
	
		session.setAttribute("emp", tempid);
		
		if(result>0)
		{
			requestDispact.forward(request, response);
		}
		else
		{
			out.print("No Employee Data To Delete");
			out.print("<html><body align='center'>");
			out.print("<form action='delete.jsp' method='post'"+ ">");
			out.print("<br>");
			out.print("<input type='submit' value='Back'>");
			out.print("</form></body></html>");
			
		}

	}

}
