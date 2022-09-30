package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BeenClasses.Complain;
import com.BeenClasses.Engineer;
import com.BeenClasses.EngineerComplainDTO;
import com.Exceptions.ComplainException;
import com.Exceptions.EngineerException;
import com.Utility.DBUtilityClass;

public class HodDaoImpl implements HodDao{

	@Override
	public String logInHod(String userName, String Password) {
		String comment = "Invalid User";
		
		try (Connection conn = DBUtilityClass.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from HOD where HODEmail = ? AND HODPassword = ?");
			ps.setString(1, userName);
			ps.setString(2, Password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("HODName");
				comment = "Welcome "+ name;
			}
			
			
		} catch (SQLException e) {
			e.getStackTrace();
		}
			
		return comment;
	}

	@Override
	public String registerEngineer(Engineer engineer) {
		
		String message = "Not Inserted..";
		
		try(Connection conn= DBUtilityClass.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into Engineer values(?,?,?,?,?)");
			
			ps.setInt(1,engineer.getENId());
			ps.setString(2, engineer.getENName());
			ps.setString(3, engineer.getENEmail());
			ps.setString(4, engineer.getENNPassword());
			ps.setString(5, engineer.getENCategory());
			
			int x= ps.executeUpdate();
			
			if(x > 0)
				message = "Engineer Registered Sucessfully... !";
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}

	@Override
	public List<Engineer> getEngineers() throws EngineerException {

		List<Engineer> engineer= new ArrayList<>();
		
		
		try (Connection conn= DBUtilityClass.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select * from Engineer");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int employeeId = rs.getInt("ENId");
				String name = rs.getString("ENName");
				String email = rs.getString("ENEmail");
				String password = rs.getString("ENNPassword");
				String catagory = rs.getString("ENCategory");
				
				
			 Engineer e = new Engineer(employeeId,name,email,password,catagory);
				engineer.add(e);
				
			}
			
			
			
			
		} catch (SQLException e) {			
			e.getMessage();
	
		}
		if(engineer.size()==0) {
			throw new EngineerException("No Engineer Found");
		}
	
	
	
		return engineer;
	}

	@Override
	public String removeEngineer(int enId) {
		
		String del = "Engineer Not Found";
		
		try (Connection conn = DBUtilityClass.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("delete from engineer where ENId=?");
			ps.setInt(1, enId);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				del = "Engineer Deleted Sucessfully...!";
			}
			
			
		} catch (SQLException e) {
			del = e.getMessage();
		}
		
		return del;
	}

	
   @Override
	public String assignComplain(int enid,String enname,String cat,int cid,String sts) {

		String message = "Complain Not Assigned... ! ";
		
		try(Connection conn= DBUtilityClass.provideConnection()) {
			
		PreparedStatement ps= conn.prepareStatement
			("insert into EngineerComplainDTO(ENId,ENName,ENCategory,EComplainId,ComplainStatus) values(?,?,?,?,?)");
		
		ps.setInt(1, enid);
		ps.setString(2, enname);
		ps.setString(3, cat);
		ps.setInt(4, cid);
		ps.setString(5, sts);
				
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Complain Assigned To Engineer Sucessfully... !";
			
			
			
		} catch (SQLException sqle) {
			message = sqle.getMessage();
		}
		
		return message;
	}

	@Override
	public List<Complain> getAllComplain() throws ComplainException {

		List<Complain> complain= new ArrayList<>();
		
		
		try (Connection conn= DBUtilityClass.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select * from complain");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int Cid =rs.getInt("ComplainId");
				String Cname = rs.getString("CName");
				String comlainCataogory = rs.getString("Catagory");
				
				Complain c = new Complain(Cid,Cname,comlainCataogory);
				complain.add(c);
				
			}
			
			
			
		} catch (SQLException e) {			
			throw new ComplainException(e.getMessage());
	
		}
		if(complain.size()==0) {
			throw new ComplainException("No Complains Found");
		}
	
	
	
		return complain;
	}
	

}
