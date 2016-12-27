<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Employee Details</title>

<script src="validations.js">
/* function validation()
{
	var employeeId=document.getElementById("employeeid").value;
	
	if(employeeId==""||employeeId==null)
		{
		alert("please enter employee Id");
		//document.getElementById("error").innerHTML="please enter id";
		return false;
		}
	else
		return true;
}
	function clearField()
	{
		document.getElementById("error").innerHTML=" ";
	} */
</script>

<style type="text/css">
#star{
color: red;
}
</style>
</head>
<body style="background-color:Moccasin">
<div align="center">
<h1>Insert Employee Details</h1>
<p>All <sup id="star">*</sup> Fields Are Mandatory</p>
<form action="Insertservlet" method="post">

 <table>
  <tr>
      <td>Enter Employee Id: <sup id="star">*</sup> </td>
      <td><input type="text" name="empid" id="employeeid" onkeypress="return clearField()"/></td>
      <td> <span id="error"></span> </td>
    </tr>
    <tr>
      <td>Enter Employee Name:<sup id="star">*</sup></td>
      <td><input type="text" name="empname" id="employeename" onkeypress="return clearField()"/></td>
    </tr>

    <tr>
      <td>Enter Salary:</td>
      <td><input type="number" name="empsal" /></td>
    </tr>
     <tr>
      <td>Enter Location:</td>
      <td><input type="text" name="emploc" /></td>
    </tr>
    <tr>
      <td>Enter Experience:<sup id="star">*</sup></td>
      <td><input type="number" name="empexp" id="empexp" onkeypress="return clearField()"/></td>
    </tr>
     
   
</table>

<input type="submit" value="Submit" onclick="return validation()">
</form>

</div>

</body>

</html>