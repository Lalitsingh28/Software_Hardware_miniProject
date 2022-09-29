package com.Dao;

import java.util.List;

import com.BeenClasses.Complain;
import com.BeenClasses.Employee;
import com.BeenClasses.EngineerComplainDTO;
import com.Exceptions.EmployeeException;


public interface EmployeeDao {

    public String registerEmployee(Employee employee);
    
    public String logInEmployee(String usersName, String Password)throws EmployeeException;
    
	public String AssignComplain(Complain complain);
	
	public EngineerComplainDTO checkComplainStatus(int eComplainId);
	
	public List<EngineerComplainDTO> getComplainByEmployee(String eName, int eId);
	
	public String changePassword(String userName);
	
	
}
