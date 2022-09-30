package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BeenClasses.Complain;
import com.BeenClasses.Employee;
import com.BeenClasses.Engineer;
import com.BeenClasses.EngineerComplainDTO;
import com.Exceptions.ComplainException;
import com.Exceptions.EmployeeException;
import com.Exceptions.EngineerException;
import com.Utility.DBUtilityClass;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public String registerEmployee(Employee em) {
		
		String message = "Not Registered..";
		
		try(Connection conn= DBUtilityClass.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into Employee values(?,?,?,?)");
			
			ps.setInt(1,em.getEId());
			ps.setString(2, em.getEName());
			ps.setString(3, em.getEEmail());
			ps.setString(4, em.getEPassword());
			
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Registered Sucessfully... !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}

	@Override
	public String logInEmployee(String userName, String Password) throws EmployeeException {

		String comment = "Invalid User";
		
		try (Connection conn = DBUtilityClass.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from employee where EEmail = ? AND EPassword = ?");
			ps.setString(1, userName);
			ps.setString(2, Password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("EName");
				comment = "Welcome "+ name;
			}else {
				comment = "Wrong Id OR Password";
			}
			
			
		} catch (SQLException e) {
			e.getStackTrace();
			throw new EmployeeException("Employee Not Avilable ");
		}
			
		return comment;
	}

	@Override
	public String registerComplain(String cname, String com) {

		String message = "Complain Not Assigned... ! ";
		
		try(Connection conn= DBUtilityClass.provideConnection()) {
			
		PreparedStatement ps= conn.prepareStatement
			("insert into complain(CName,Catagory) values(?,?)");
		
		  ps.setString(1, cname);
		  ps.setString(2, com);
				
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Complain Assigned Sucessfully... !";
			
			
			
		} catch (SQLException sqle) {
			message = sqle.getMessage();
		}
		
		return message;
	}

	@Override
	public List<EngineerComplainDTO> checkComplainStatus(int eComplainId)throws ComplainException {
		
		List<EngineerComplainDTO> list = new ArrayList<>();
		
		try (Connection conn= DBUtilityClass.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement
					("select * from engineerComplainDTO where ENComplainId = ?");
			
			ps.setInt(1, eComplainId);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int employeeId = rs.getInt("ENId");
				String name = rs.getString("ENName");
				String catagory = rs.getString("ENCategory");
				int complainId = rs.getInt("EComplainId");
				String status = rs.getString("ComplainStatus");
				
				
			 EngineerComplainDTO e = new EngineerComplainDTO(complainId, name,catagory,eComplainId,status);
			 
				list.add(e);
				
			}
			
			
			
		} catch (SQLException e) {			
			throw new ComplainException(e.getMessage());
	
		}
		if(list.size()==0) {
			throw new ComplainException("No Complain Found");
		}
	
		
		return list;
	}

	@Override
	public List<Complain> getComplainByEmployee(String eName) {
		List<Complain> list = new ArrayList<>();
		try (Connection conn= DBUtilityClass.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement
					("select * from Complain where CName = ?");
			
			ps.setString(1, eName);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("ComplainId");
				String cname = rs.getString("CName");
				String catagory = rs.getString("catagory");
				
				
			 Complain c = new Complain(id, cname, catagory);
			 
				list.add(c);
				
			}
			
			
			
		} catch (SQLException e) {			
			
	          e.getMessage();
		}
		
		
		
		return list;
	}

	@Override
	public String changePassword(int ePassword,String p) {
		String message = "Password Not Changed";
		try(Connection conn = DBUtilityClass.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement
					("Update Employee set EPassword = ? where EId = ?");
			ps.setString(1, p);
			ps.setInt(2, ePassword);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Password Updated Sucessfull... !";
			}
			
			
		} catch (SQLException se) {
			message = se.getMessage();
		}
		
		return message;
	}

	

}
