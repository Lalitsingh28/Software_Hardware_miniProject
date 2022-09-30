package com.Dao;

import java.util.List;

import com.BeenClasses.Engineer;
import com.BeenClasses.EngineerComplainDTO;
import com.Exceptions.ComplainException;
import com.Exceptions.EngineerException;

public interface EngineerDao {
	
	public String logInEngineer(String usersName, String Password)throws EngineerException;
	
	public List<EngineerComplainDTO> AssignedComplainByHod(int id)throws ComplainException;
	
	public String updateComplainStatus(int enId);
	
	public List<EngineerComplainDTO> getComplainByEngineer(int enid)throws ComplainException;
	
	public String changePassword(int ENId,String p);
	
	

}
