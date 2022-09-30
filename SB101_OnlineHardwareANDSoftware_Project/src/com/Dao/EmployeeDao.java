package com.Dao;

import java.util.List;

import com.BeenClasses.Complain;
import com.BeenClasses.Employee;
import com.BeenClasses.EngineerComplainDTO;
import com.Exceptions.ComplainException;
import com.Exceptions.EmployeeException;


public interface EmployeeDao {

    public String registerEmployee(Employee employee);
    
    public String logInEmployee(String usersName, String Password)throws EmployeeException;
    
	public String registerComplain(String cname,String com);
	
	public List<EngineerComplainDTO> checkComplainStatus(int eComplainId)throws ComplainException;
	
	public List<Complain> getComplainByEmployee(String eName);
	
	public String changePassword(int ep,String p);
	
	
}
