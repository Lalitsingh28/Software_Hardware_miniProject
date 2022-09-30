package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BeenClasses.Engineer;
import com.BeenClasses.EngineerComplainDTO;
import com.Exceptions.ComplainException;
import com.Exceptions.EngineerException;
import com.Utility.DBUtilityClass;

public class EngineerDaoImpl implements EngineerDao {

	@Override
	public String logInEngineer(String userName, String Password) throws EngineerException {
        
		String comment = "Invalid User";
		
		try (Connection conn = DBUtilityClass.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from engineer where ENEmail = ? AND ENNPassword = ?");
			ps.setString(1, userName);
			ps.setString(2, Password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("ENName");
				comment = "Welcome "+ name;
			}else {
				comment = "Wrong Id OR Password";
			}
			
			
		} catch (SQLException e) {
			e.getStackTrace();
		}
			
		return comment;
	}

	@Override
	public List<EngineerComplainDTO> AssignedComplainByHod(int id) throws ComplainException {
		
		List<EngineerComplainDTO> list = new ArrayList<>();
		
		try(Connection conn = DBUtilityClass.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from EngineerComplainDTO where ENId = ?");
			ps.setInt(1, id);
			
			ResultSet rs =ps.executeQuery();
			
			while(rs.next()) {
				
				int engId = rs.getInt("ENId");
				String name = rs.getString("ENName");
				String catagory = rs.getString("ENCategory");
				int complainId = rs.getInt("EComplainId");
				String status = rs.getString("ComplainStatus");
				
				list.add(new EngineerComplainDTO(engId, name, catagory,complainId,status));
			}
			
			
		} catch (SQLException se) {
			throw new ComplainException("Complain Not Assigned");
		}
		
		if(list.size()==0) {
			throw new  ComplainException("No Complain Assigned");
		}
		return list;
	}

	@Override
	public String updateComplainStatus(int enId) {
		
		String message = "Complain Status Not Updates";
		try(Connection conn = DBUtilityClass.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement
					("Update EngineerComplainDTO set ComplainStatus = 'Solved' where EComplainId = ?");
			ps.setInt(1, enId);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Complain Status Updated Sucessfull... !";
			}
			
			
		} catch (SQLException se) {
			message = se.getMessage();
		}
		
		return message;
	}

	@Override
	public List<EngineerComplainDTO> getComplainByEngineer(int enid)throws ComplainException {
		
		List<EngineerComplainDTO> list = new ArrayList<>();
		
		try(Connection conn = DBUtilityClass.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement
					("select * from EngineerComplainDTO where ENId = ?");
			ps.setInt(1, enid);
			
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) {
				int engId = rs.getInt("ENId");
				String name = rs.getString("ENName");
				String catagory = rs.getString("ENCategory");
				int complainId = rs.getInt("EComplainId");
				String status = rs.getString("ComplainStatus");
				
				list.add(new EngineerComplainDTO(engId, name, catagory,complainId,status ));
				
				
			}
			
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ComplainException("No Complain Found");
			}
			
			return list;
		} 
		

		
		
	

	@Override
	public String changePassword(int ENId,String p) {
		
		String message = "Password Changed";
		try(Connection conn = DBUtilityClass.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement
					("Update Engineer set ENNPassword = ? where ENId = ?");
			ps.setString(1, p);
			ps.setInt(2, ENId);
			
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
