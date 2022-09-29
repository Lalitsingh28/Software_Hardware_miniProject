package com.Dao;

import java.util.List;

import com.BeenClasses.EngineerComplainDTO;
import com.Exceptions.ComplainException;

public interface EngineerDao {
	
	public String logInEngineer(String usersName, String Password);
	
	public String AssignedComplainEngineer(String ename,int enId)throws ComplainException;
	
	public String updateComplainStatus(int eComplainId);
	
	public List<EngineerComplainDTO> getComplainByEngineer(String enName, int enId);
	
	public String changePassword(int enId);
	
	

}
