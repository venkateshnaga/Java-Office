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
<body style="background-color:DarkKhaki ">

<div align="center">
<%
Object obj=session.getAttribute("employeeList");

if(obj!=null)
{
	%>
	<table><br>
<tr>
<th>EmployeeId |</th>
<th>EmployeeName |</th>
<th>EmployeeSalary |</th>
<th>EmployeeExp |</th>
<th>EmployeeLocation |</th>
<th>EmployeeLoan |</th>
<th>EmployeeEmi</th>
</tr>
	<%
	ArrayList<EmployeeBean> employeeList=(ArrayList)obj;
	Iterator iterator=employeeList.iterator();
	EmployeeBean employeebean=null;
	while(iterator.hasNext())
	{
		employeebean=(EmployeeBean)iterator.next();
		%>
		<tr>
<td> <%=employeebean.getEmpid() %></td>	
<td> <%=employeebean.getEmpname() %></td>
<td> <%=employeebean.getEmpsal() %></td>
<td><%=employeebean.getEmpexp() %></td>
<td><%=employeebean.getEmploc() %></td>
<td><%=employeebean.getEmploan() %></td>
<td><%=employeebean.getEmpemi() %></td>		
		</tr>
		
	<%	
	}
	session.removeAttribute("employeeList");
	
}
else
	
{
	
	out.print("No Data");
}

%>
</table>


<br>
<br>
<br>
<a href="index.html">Go To HomePage</a>
</div>


</body>
</html>