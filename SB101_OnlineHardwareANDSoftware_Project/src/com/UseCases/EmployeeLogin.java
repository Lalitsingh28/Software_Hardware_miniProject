package com.UseCases;

import java.util.Scanner;

import com.Dao.EmployeeDao;
import com.Dao.EmployeeDaoImpl;
import com.Exceptions.EmployeeException;


public class EmployeeLogin {
	
	public static void loginEmployee() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username:");
		String uname = sc.next();
		
		System.out.println("Enter Password:");
		String pass = sc.next();
		
		EmployeeDao hd = new EmployeeDaoImpl();
		
		try {
			String result = hd.logInEmployee(uname, pass);
			System.out.println(result);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EmployeeUseCasses.optionsEmployee();	
	}
}
