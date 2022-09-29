package com.Dao;

import java.util.List;

import com.BeenClasses.Engineer;
import com.BeenClasses.EngineerComplainDTO;
import com.Exceptions.ComplainException;
import com.Exceptions.EngineerException;

public interface HodDao {
	
	public String logInHod(String usersName, String Password);
	
	public String registerEngineer(Engineer engineer);
	
	public List<Engineer> getEngineers()throws EngineerException;
	
	public String removeEngineer(int enId);
	
	public List<EngineerComplainDTO> getAllComplain()throws ComplainException;
	
	public String assignComplain(int eComplainId);
	
	
	
	

}
