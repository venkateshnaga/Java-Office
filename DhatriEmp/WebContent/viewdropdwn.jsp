<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head><br>
<body align="center">
<form action="Search1" method="post">
View By Employee Id|Name|Salary:
<select name="dropdown">
 <option value="id">Id</option>
<option value="name">Name</option>
<option value="sal">Salary</option>
</select>
<input type="text" name="emp"/>
<input type="submit" value="View"/>
</form><br>
<a href="index.html">Go To HomePage</a>
</body>
</html>