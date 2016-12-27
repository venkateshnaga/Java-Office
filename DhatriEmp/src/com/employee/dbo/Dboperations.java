package com.employee.dbo;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;


import com.employee.bean.EmployeeBean;

public class Dboperations
{
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet resultset=null;

	public Dboperations()
	{
		con=MyConnection.getInstance().connection;
	}
	
	
	public int insert(EmployeeBean emp)
	{
		int result=0;
		
		
		//String query="insert into emp(empname,empsal,empexp,emploc,emploan,empemi) values(?,?,?,?,?,?)";
		String query="insert into empdb values(?,?,?,?,?,?,?)";
		
		try 
		{
			pst=con.prepareStatement(query);
			pst.setString(1,emp.getEmpid());
			pst.setString(2,emp.getEmpname());
			pst.setDouble(3,emp.getEmpsal());	
			pst.setDouble(4,emp.getEmpexp());
			pst.setString(5,emp.getEmploc());			
			pst.setDouble(6,emp.getEmploan());
			pst.setDouble(7,emp.getEmpemi());
			
			result=pst.executeUpdate();
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public int update(EmployeeBean emp)
	{
		int result=0;

	
		try{
			
			pst = con.prepareStatement("update empdb set empname=?,empsal=?,emploc=?,empexp=? where empid=?");
				  
				
				pst.setString(1,emp.getEmpname());  
				pst.setDouble(2,emp.getEmpsal());  
				pst.setString(3,emp.getEmploc()); 
				pst.setDouble(4,emp.getEmpexp()); 
				pst.setString(5,emp.getEmpid());  
				
				result=pst.executeUpdate();  
				
			System.out.println(result);
			}
			
			catch (SQLException e) 
			{
			
				e.printStackTrace();
			}
		

		return result;
	}
	
	public int delete(EmployeeBean emp)
	{
		int result=0;
		
		try
		{
			pst=con.prepareStatement("delete from empdb where empid=? ");
			pst.setString(1,emp.getEmpid());
			result=pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	public ArrayList<EmployeeBean> search(double tempid)
	{
		ArrayList<EmployeeBean> employeeList=new ArrayList<EmployeeBean>();
		
		String query="select empid,empname,empsal,empexp,emploc,emploan,empemi from empdb where empid=?";
		
		try {
			pst=con.prepareStatement(query);
			pst.setDouble(1, tempid);
			
			resultset=pst.executeQuery();
			
			EmployeeBean empBean=null;
			while(resultset.next())
			{
				empBean=new EmployeeBean();
				empBean.setEmpid(resultset.getString(1));
				empBean.setEmpname(resultset.getString(2));
				empBean.setEmpsal(resultset.getDouble(3));
				empBean.setEmpexp(resultset.getDouble(4));
				empBean.setEmploc(resultset.getString(5));
				empBean.setEmploan(resultset.getDouble(6));
				empBean.setEmpemi(resultset.getDouble(7));
				employeeList.add(empBean);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;
		
	}
	public ArrayList<EmployeeBean> search1(String searchVariable)
	{
		ArrayList<EmployeeBean> employeeList=new ArrayList<EmployeeBean>();
		
		String query="select empid,empname,empsal,empexp,emploc,emploan,empemi from empdb where empid=?";
		
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, searchVariable);
			
			resultset=pst.executeQuery();
			
			EmployeeBean empBean=null;
			while(resultset.next())
			{
				empBean=new EmployeeBean();
				empBean.setEmpid(resultset.getString(1));
				empBean.setEmpname(resultset.getString(2));
				empBean.setEmpsal(resultset.getDouble(3));
				empBean.setEmpexp(resultset.getDouble(4));
				empBean.setEmploc(resultset.getString(5));
				empBean.setEmploan(resultset.getDouble(6));
				empBean.setEmpemi(resultset.getDouble(7));
				employeeList.add(empBean);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;
		
	}
	public ArrayList<EmployeeBean> searchsal(double salary)
	{
		ArrayList<EmployeeBean> employeeList=new ArrayList<EmployeeBean>();
		
		String query="select empid,empname,empsal,empexp,emploc,emploan,empemi from empdb where empsal=?";
		
		try {
			pst=con.prepareStatement(query);
			pst.setDouble(1, salary);
			
			resultset=pst.executeQuery();
			
			EmployeeBean empBean=null;
			while(resultset.next())
			{
				empBean=new EmployeeBean();
				empBean.setEmpid(resultset.getString(1));
				empBean.setEmpname(resultset.getString(2));
				empBean.setEmpsal(resultset.getDouble(3));
				empBean.setEmpexp(resultset.getDouble(4));
				empBean.setEmploc(resultset.getString(5));
				empBean.setEmploan(resultset.getDouble(6));
				empBean.setEmpemi(resultset.getDouble(7));
				employeeList.add(empBean);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;
		
	}

	public ArrayList<EmployeeBean> searchname(String name)
	{
		ArrayList<EmployeeBean> employeeList=new ArrayList<EmployeeBean>();
		
		String query="select empid,empname,empsal,empexp,emploc,emploan,empemi from empdb where empname=?";
		
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, name);
			
			resultset=pst.executeQuery();
			
			EmployeeBean empBean=null;
			while(resultset.next())
			{
				empBean=new EmployeeBean();
				empBean.setEmpid(resultset.getString(1));
				empBean.setEmpname(resultset.getString(2));
				empBean.setEmpsal(resultset.getDouble(3));
				empBean.setEmpexp(resultset.getDouble(4));
				empBean.setEmploc(resultset.getString(5));
				empBean.setEmploan(resultset.getDouble(6));
				empBean.setEmpemi(resultset.getDouble(7));
				employeeList.add(empBean);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;
		
	}
	
	public ArrayList<EmployeeBean> loan(String tempid)
	{
		
		
		ArrayList<EmployeeBean> al=new ArrayList<EmployeeBean>();
		EmployeeBean db=null;		
		
		String query="select * from empdb where empid=?";
		try 
		{
			pst=con.prepareStatement(query);
			pst.setString(1, tempid);
			resultset=pst.executeQuery();

			while(resultset.next())
			{
				db=new EmployeeBean();
				db.setEmpid(resultset.getString(1));
				db.setEmpname(resultset.getString(2));
				db.setEmpsal(resultset.getDouble(3));
				db.setEmpexp(resultset.getDouble(4));
				db.setEmploc(resultset.getString(5));
				db.setEmploan(resultset.getDouble(6));
				db.setEmpemi(resultset.getDouble(7));
				al.add(db);
			}
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Iterator<EmployeeBean> it=al.iterator();
		EmployeeBean ee=null;
		
		
		while(it.hasNext())
		{
			
		ee=(EmployeeBean)it.next();
		if(db.getEmpexp()<=2 && db.getEmpexp()>1)
		{
			double insal=db.getEmpsal()/2;
			ee.setEmploan(insal);
			double emi=((db.getEmploan()*0.14+db.getEmploan())/9);
			ee.setEmpemi(emi);
		}
		else if(db.getEmpexp()>2 && db.getEmpexp()<5)
		{
			
			double insal=(3*ee.getEmpsal()/4);
			ee.setEmploan(insal);
			double emi=((db.getEmploan()*0.14+db.getEmploan())/9);
			ee.setEmpemi(emi);
		}
		
		
	}
		return al;
		
	
}
	
	public ArrayList<EmployeeBean> loanupdate(String tempid)
	{
		//String tempid1="555";
		ArrayList<EmployeeBean> ref=loan(tempid);
		
		Iterator<EmployeeBean> it=ref.iterator();
		EmployeeBean ee=null;
		
		while(it.hasNext())
		{
			
		ee=(EmployeeBean)it.next();
		try 
		{
			
			String query1="update empdb set emploan=?,empemi=? where empid=?";
			pst=con.prepareStatement(query1);
			pst.setDouble(1, ee.getEmploan());
			pst.setDouble(2, ee.getEmpemi());
			pst.setString(3, tempid);
			int x=pst.executeUpdate();
		}
		catch (SQLException e) 
		{
		e.printStackTrace();
		}
		
	}
		return ref;
	}
}
	