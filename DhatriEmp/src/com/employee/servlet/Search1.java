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
 * Servlet implementation class Search1
 */
@WebServlet("/Search1")
public class Search1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search1() {
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
		
		response.setContentType("text/html");
		String searchElement=request.getParameter("dropdown");
		
		String temp=request.getParameter("emp");
		PrintWriter out=response.getWriter();
		if(searchElement.equals("id"))
		{
			try{
				double id;
				id=Double.parseDouble(temp);
				Dboperations dbo=new Dboperations();
				ArrayList<EmployeeBean> empList=dbo.search(id);
				HttpSession session=request.getSession();
				session.setAttribute("employeeList", empList);
				RequestDispatcher requestDis=request.getRequestDispatcher("viewsucess.jsp");
				requestDis.forward(request, response);
			}
			catch(Exception e)
			{
				out.print("Please Enter Correct Input");
				out.print("<html><body align='center'>");
				out.print("<form action='viewdropdwn.jsp' method='post'"+ ">");
				out.print("<br>");
				out.print("<input type='submit' value='Back'>");
				out.print("</form></body></html>");
			}
		}
		
		else if(searchElement.equals("name"))
		 
		{
			
			Dboperations dbo=new Dboperations();
			
			ArrayList<EmployeeBean> empList=dbo.searchname(temp);
			
			HttpSession session=request.getSession();
			session.setAttribute("employeeList", empList);
			RequestDispatcher requestDis=request.getRequestDispatcher("viewsucess.jsp");
			requestDis.forward(request, response);	
		
		}
		else if(searchElement.equals("sal"))
			 
		{
			try
			{
			double salary;
			Dboperations dbo=new Dboperations();
			salary=Double.parseDouble(temp);
			
			ArrayList<EmployeeBean> empList=dbo.searchsal(salary);
			
			HttpSession session=request.getSession();
			session.setAttribute("employeeList", empList);
			RequestDispatcher requestDis=request.getRequestDispatcher("viewsucess.jsp");
			
			requestDis.forward(request, response);	
			
			}
			catch(Exception e)
			{
				out.print("Please Enter Correct Input");
				out.print("<html><body align='center'>");
				out.print("<form action='viewdropdwn.jsp' method='post'"+ ">");
				out.print("<br>");
				out.print("<input type='submit' value='Back'>");
				out.print("</form></body></html>");
			}
		}
		
	}

}
