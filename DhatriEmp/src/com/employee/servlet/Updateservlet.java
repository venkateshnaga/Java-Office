package com.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
 * Servlet implementation class Updateservlet
 */
@WebServlet("/Updateservlet")
public class Updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateservlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String empid=request.getParameter("eid");
		String empname=request.getParameter("ename");
		String empsal=request.getParameter("esal");
		String empexp=request.getParameter("eexp");
		String emploc=request.getParameter("eloc");
		double salary;
		double exp;
		try
		{
			salary=Double.parseDouble(empsal);
			exp=Double.parseDouble(empexp);
		}
		catch(Exception e)
		{
			salary=0.0;
			exp=0.0;
		}
		EmployeeBean emp=new EmployeeBean();
		emp.setEmpid(empid);
		emp.setEmpname(empname);
		emp.setEmpsal(salary);
		emp.setEmpexp(exp);
		emp.setEmploc(emploc);

		Dboperations dbo=new Dboperations();
		int result=dbo.update(emp);
		out.print(result);
		
		
		
		RequestDispatcher requestDispact=request.getRequestDispatcher("usuccess.jsp");
		
		HttpSession session=request.getSession();
		session.setAttribute("empid", empid);
		
		if(result>0)
		{
			requestDispact.forward(request, response);
	}
}
}
