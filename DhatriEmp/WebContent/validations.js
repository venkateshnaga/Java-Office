/**
 * 
 */

function validation()
{
	var employeeId=document.getElementById("employeeid").value;
	var employeeName=document.getElementById("employeename").value;
	var employeeExp=document.getElementById("empexp").value;
	if(employeeId==""||employeeId==null)
		{
		alert("please enter employee Id");
		//document.getElementById("error").innerHTML="please enter id";
		return false;
		}
	if(employeeName==""||employeeName==null)
	{

		alert("please enter employee name");
		//document.getElementById("error").innerHTML="please enter name";
		return false;
	}
	if(employeeExp==""||employeeExp==null)
	{

		alert("please enter employee exp");
		//document.getElementById("error").innerHTML="please enter exp";
		return false;
	}
	else
		return true;
		
	}

	function clearField()
	{
		document.getElementById("error").innerHTML=" ";
	}

