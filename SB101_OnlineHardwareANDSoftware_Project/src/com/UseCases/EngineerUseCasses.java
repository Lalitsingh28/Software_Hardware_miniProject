package com.UseCases;

import java.util.List;
import java.util.Scanner;

import com.BeenClasses.EngineerComplainDTO;
import com.Dao.EngineerDao;
import com.Dao.EngineerDaoImpl;
import com.Exceptions.ComplainException;



public class EngineerUseCasses {
	
	public static void optionsEngineer() {
		
		
		Scanner sc = new Scanner(System.in);
		EngineerDao hd = new EngineerDaoImpl();
		System.out.println("\nPlease Select An Option To Continue");
		System.out.println(
				"\n1. See Problems Assignes By HOD\n2. Update Problem Status\n3. List Of All problems Attended\n4. Change Password\n5. Exit");
		
		int number = sc.nextInt();
		
		switch(number) {
		case 1: 
			System.out.println("Enter Engineer Id : ");
			int n = sc.nextInt();
			try {
				List<EngineerComplainDTO> list = hd.AssignedComplainByHod(n);
				list.forEach(e -> System.out.println(e));
			} catch (ComplainException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			EngineerUseCasses.optionsEngineer();
			break;
	        
		 case 2:
			 System.out.println("Enter Engineer Id To Update Problem Status :");
			 int num = sc.nextInt();
			 String s = hd.updateComplainStatus(num);
			 System.out.println(s);
			 EngineerUseCasses.optionsEngineer();
			 break;
		     
		  case 3:
			  System.out.println("Enter Engineer Id to Get List of Complains :");
			  int Enid = sc.nextInt();
			  try {
				List<EngineerComplainDTO> eclist = hd.getComplainByEngineer(Enid);
				eclist.forEach(e -> System.out.println(e));
			} catch (ComplainException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			  EngineerUseCasses.optionsEngineer();
			  break;
			  
			  
		  case 4:
			  System.out.println("Enter Engineer Id :");
			  int engineerId = sc.nextInt();
			  System.out.println("Enter New Password :");
			  String password = sc.next();
			  String up = hd.changePassword(engineerId, password);
			  System.out.println(up);
			  EngineerUseCasses.optionsEngineer();
			  break;
			  
			  
		  case 5:
			  break;
			  			  
		}
	}

}
