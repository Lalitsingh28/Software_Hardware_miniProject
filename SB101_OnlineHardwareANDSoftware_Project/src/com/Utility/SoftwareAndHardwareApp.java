package com.Utility;

import java.util.Scanner;

import com.BeenClasses.Employee;
import com.Dao.EmployeeDao;
import com.Dao.EmployeeDaoImpl;
import com.UseCases.EmployeeLogin;
import com.UseCases.EngineerLogin;
import com.UseCases.HodLoginUses;

public class SoftwareAndHardwareApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\nPlease Select An Option To Continue");
		System.out.println(
				"\n1. Login As HOD\n2. Login As Engineer\n3. Register As Employee\n4. Login As Employee\n5. Exit");
		
		int number = sc.nextInt();
		
		switch(number) {
		case 1:
			HodLoginUses.loginHod();
			break;
		
		
		case 2:
			EngineerLogin.loginEngineer();
			break;
			
		case 3:
			EmployeeDao ed = new EmployeeDaoImpl();
			System.out.println("Enter Employee Id :");
			int eid = sc.nextInt();
			System.out.println("Enter Employee Name :");
			String ename = sc.next();
			System.out.println("Enter Employee Email/UserName :");
			String email = sc.next();
			System.out.println("Enter Password :");
			String pass = sc.next();
			
			Employee em = new Employee(eid, ename, email, pass);
			
			System.out.println(ed.registerEmployee(em));
			System.out.println("Enter To Login :");
			EmployeeLogin.loginEmployee();
			break;
			
		case 4:
			EmployeeLogin.loginEmployee();
			break;
			
		case 5:
			break;
			
		}
		
		
		System.out.println("Thank You For Using Our Services");
		

	}

}
