package com.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
 * Servlet implementation class Loanservlet
 */
@WebServlet("/Loanservlet")
public class Loanservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loanservlet() {
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
		
		
	try
	{
		String tempid=request.getParameter("tempid");
		
		Dboperations dbo=new Dboperations();
		
		ArrayList<EmployeeBean> empList=dbo.loan(tempid);
	
		RequestDispatcher requestDispact=request.getRequestDispatcher("loansucess.jsp");
		
		HttpSession session=request.getSession();
		session.setAttribute("employeeList", empList);
		
		requestDispact.forward(request, response);
	}
	catch(Exception e)
	{
		out.print("Please Enter Valid Input");
		out.print("<html><body align='center'>");
		out.print("<form action='loan.jsp' method='post'"+ ">");
		out.print("<br>");
		out.print("<input type='submit' value='Back'>");
		out.print("</form></body></html>");
	}

	}
	}


