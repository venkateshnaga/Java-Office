<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Employee</title>
</head>
<body style="background-color: MediumAquaMarine">
<div align="center">
<form action="Deleteservlet" method="post">

<table>
<tr><br><br>
<td>Enter Employee Id To Delete:</td>
	<td> <input type="text" name="tempid" /></td>
	</tr>

</table>
<br>
<input type="submit" name="Delete" />

</form><br>
<a href="index.html">Go To HomePage</a>
</div>

</body>
</html>