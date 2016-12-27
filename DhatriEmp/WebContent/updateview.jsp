 <%@page import="java.util.Iterator"%>
<%@page import="com.employee.bean.EmployeeBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Employee Details</title>
</head>
<body align="center">

<div align="center">

<h2>Update Employee Details</h2>

<form action="Updateservlet1" method="post">
Enter Employee Id :
<input type="text" name="search" />
<input type="submit" value="Update By Id"><br><br>
<a href="index.html">Go To HomePage</a>
<hr>

</form>

</div>

<%
Object obj=session.getAttribute("employeeList");

if(obj!=null)
{
	%>
	
	

	<%
	ArrayList<EmployeeBean> employeeList=(ArrayList)obj;
	Iterator iterator=employeeList.iterator();
	EmployeeBean employeebean=null;
	while(iterator.hasNext())
	{
		employeebean=(EmployeeBean)iterator.next();
		%>
<form action="Updateservlet" method="post">		
<table align="center">

<tr>
<td>Employee Id:</td>
<td><input type="text" value="<%= employeebean.getEmpid() %>" name="eid" readonly/></td>
</tr>

<tr>
<td>Employee Name:</td>
<td><input type="text" value="<%= employeebean.getEmpname()  %>" name="ename"/></td>
</tr>

<tr>
<td>Employee Salary:</td>
<td><input type="text" value="<%= employeebean.getEmpsal() %>" name="esal"/></td>
</tr>

<tr>
<td>Employee Exp:</td>
<td><input type="text" value="<%= employeebean.getEmpexp() %>" name="eexp"/></td>
</tr>

<tr><td>Employee Location:</td>
<td><input type="text" value="<%= employeebean.getEmploc() %>" name="eloc"/></td>
</tr>

		
		</table><br>
		<div align="center">
		<input type="submit" value="Update" />
		<a href="index.html">Go To HomePage</a>
		</div>
		</form>
	<%	
	}
	session.removeAttribute("employeeList");
	
}
else
	
{
	out.print("No Data");
}

%>



</body>
</html>